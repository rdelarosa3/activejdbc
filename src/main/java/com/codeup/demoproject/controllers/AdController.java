package com.codeup.demoproject.controllers;

import com.codeup.demoproject.models.Ad;
import com.codeup.demoproject.models.User;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.connection_config.DBConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
public class AdController {
    @GetMapping("/ads")
    public String index(Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        Ad ad = Ad.findById(1);
        model.addAttribute("ad", ad );
        Base.close();
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id,Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        model.addAttribute("ad", Ad.findFirst("id =?",id));
        Base.close();
        return "ads/show";
    }

    @GetMapping("/ads/new")
    public String createAd(){
        return "ads/new";
    }

    @PostMapping("/ads/new")
    public String submitAd(@RequestParam Map<String, String> requestParams,Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
//        prepare Ad
        Ad ad = new Ad();
//        create Ad from mapping params to Ad model
        ad.fromMap(requestParams);
//        prepare the user that the ad will belong to
        User user = User.findById(1);
//        add the created ad to the user
        try{
            user.add(ad);
            model.addAttribute("ad", ad);
            return "redirect:/ads/"+ad.getId();
        }catch(Exception e){
            model.addAttribute("errors", ad.errors());
            System.out.println(ad.errors());
            return "ads/new";
        }
    }

    @GetMapping("/ads/{id}/edit")
    public String createAd(@PathVariable(name ="id") long id, Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        model.addAttribute("ad", Ad.findFirst("id =?",id));
        Base.close();
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String submitAd(@PathVariable(name ="id") long id, Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        model.addAttribute("ad", Ad.findFirst("id =?",id));
        Base.close();
        return "ads/edit";
    }

}
