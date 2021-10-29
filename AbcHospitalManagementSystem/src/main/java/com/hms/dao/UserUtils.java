/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class UserUtils {
    
    public static databaseconn conn ; // declared as public 
    
   public static boolean updateUser(User user){
       
       try{
         conn = databaseconn.getInstance();  //get the only object 
         Statement stmt = conn.getConnection().createStatement();  //show and get the connection
         stmt.executeUpdate("UPDATE users "
                 + "SET username='"+user.getUsername()+"', password='"+user.getPassword()+"'"
                 + ", role='"+user.getRole()+"'"
                 + " WHERE (user_id ='"+user.getUser_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteUser(int id){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM users WHERE (user_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addUser(User user){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO users(`user_id`,`username`, `password`, `role`)" 
                 + "VALUES ('"+user.getUser_id()+"',"
                 +"'"+user.getUsername()+"',"
                 +"'"+user.getPassword()+"','"+user.getRole()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   
      public static User getUser(int id){
       
       User user = null ;
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT user_id, username, password, role FROM users WHERE user_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
           
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return user;
   }
   
   
   public static List<User> getUser(){
       
       List<User> user = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT user_id, username, password, role FROM users");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            User u = new User();
            u.setUser_id(rs.getInt("user_id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setRole(rs.getString("role"));
            
            
            user.add(u);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return user;
   }
}
