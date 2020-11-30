package com.codeup.demoproject.controllers;
import com.codeup.demoproject.models.Ad;
import com.codeup.demoproject.models.User;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.connection_config.DBConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Controller
public class UserController {

    @GetMapping("/users/index")
    public String index(Model model){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        User user = User.findById(3);
        user.getId();
        model.addAttribute("user",user);
        Base.close();
        return "/users/index";
    }

    public static void createUser(){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        User u = new User();
        u.set("username","oscar");
        u.set("email","email@email.com");
        u.set("password","password");
        u.set("avatar","avatar");
        u.set("role","admin");
        if(u.save()){
            System.out.println("success");
        }else{
            System.out.println(u.errors().get("username"));
        }
        Base.close();
    }

    public static void createAd(){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        Ad a = new Ad();
        a.set("user_id",1);
        a.set("title","This is a Title");
        a.set("description","my description");
        a.set("price",10.00);
        a.set("sold",0);
        a.set("location","san antonio");
        if(a.save()){
            System.out.println("success");
        }else{
            System.out.println(a.errors().get("username"));
        }
        User user = User.findFirst("username =?","pedro.juarez");
        Base.close();
    }

    @GetMapping("/users/user/{id}")
    public String showUser(Model model, @PathVariable(name ="id")long id){
        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();
        User user = User.findById(id);
        List<Ad> userAds = user.getAll(Ad.class);
        for(Ad a : userAds){
            System.out.println(a.getString("title"));
            System.out.println(a.getString("description"));
            System.out.println(a.getString("price"));
            System.out.println(a.getString("location"));
        }
        model.addAttribute("user",user);
        model.addAttribute("user-ads",userAds);
        Base.close();
        return "/users/show";
    }

    public static void main(String[] args) {
        createUser();
        createAd();
    }
}
