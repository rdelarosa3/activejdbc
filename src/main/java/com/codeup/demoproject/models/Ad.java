package com.codeup.demoproject.models;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.connection_config.DBConfiguration;

public class Ad extends Model {
    static{
        validatePresenceOf("user_id").message("Ad must have a user");
        validatePresenceOf("title").message("Please Enter a Title");
        validatePresenceOf("description").message("Please Enter a Description");
        validatePresenceOf("price").message("Please Enter a Price");
        validateNumericalityOf("price").message("Price needs to be a number;");
        validatePresenceOf("location").message("Please Enter a Location");
    }

    public Ad(){}

    public Ad(long user_id,String title, String description, Double price, String location, Boolean sold) {
        set("title",title);
        set("description",description);
        set("price",price);
        set("location",location);
        set("user_id",user_id);
        set("sold",sold);
        
    }

    public String getTitle() {
        String t = getString("title");
        return t;
    }

    public String getDescription() {
        String d =  getString("description");
        return d;
    }

    public Double getPrice() {
        double p = getDouble("price");
        return p;
    }

    public String getLocation() {
        String l = getString("location");
        return l;
    }

    public User getAuthor() {
        User u = parent(User.class);
        return u;
    }

    public Boolean getSold() {
        boolean s = getBoolean("sold");
        return s;
    }
}
