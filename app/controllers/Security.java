package controllers;
 
import models.*;
import play.*; 
public class Security extends Secure.Security {
 
    static boolean authentify(String username, String password) {
        return (username.equals(Play.configuration.get("admin.login.username")) && password.equals(Play.configuration.get("admin.login.password")));
    }
    
}
