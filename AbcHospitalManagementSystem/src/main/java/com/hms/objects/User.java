/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement (name="user")

public class User {
    
    private int user_id;
    private String username;
    private String password;
    private String role;

    public User(int user_id, String username, String password, String role) { 
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {  // Default Constructor 
        this.user_id = 0;
        this.username = "";
        this.password = "";
        this.role = "";
    }

    public int getUser_id() { // Getter 
        return user_id;
    }

    public void setUser_id(int user_id) { //Setter
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
    @Override
    public String toString() {
        return user_id+"::"+username+"::"+password+"::"+role ;
    } 
}
