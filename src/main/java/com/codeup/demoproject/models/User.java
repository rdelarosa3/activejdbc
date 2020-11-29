package com.codeup.demoproject.models;
import org.javalite.activejdbc.Model;

public class User extends Model{
    static {
        validatePresenceOf("username").message("Please, provide your username");
        validatePresenceOf("email").message("Please, provide your email");
        validateEmailOf("email").message("Enter a valid email");
        validatePresenceOf("password").message("Please, provide your password");
    }

    public User(){};
    public User(String username, String email, String password, String avatar, String role) {
        set("username", username);
        set("email", email);
        set("password",password);
        set("avatar", avatar);
        set("role", role);
    }

    public String getUsername() {
        return getString("username");

    }

    public String getEmail() {
        return getString("email");
    }

    public String getPassword() {
        return getString("password");
    }

    public String getAvatar() {
        return getString("avatar");
    }

    public String getRole() {
        return getString("role");
    }
}
