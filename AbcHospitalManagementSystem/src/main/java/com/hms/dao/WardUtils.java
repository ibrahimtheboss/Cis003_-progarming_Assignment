/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Ward;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class WardUtils {
   public static databaseconn conn ;
    
   public static boolean updateWard(Ward ward){ // argument 
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE ward "
                 + "SET ward_no ='"+ward.getWard_no()+"', ward_type ='"+ward.getWard_type()+"'"
                 + " , ward_status ='"+ward.getWard_status()+"'"
                 + " WHERE (ward_id ='"+ward.getWard_id()+"')");    
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteWard(int id){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM ward WHERE (ward_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addWard(Ward ward){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO ward(`ward_id`,`ward_no`, `ward_type`,`ward_status`)" 
                 + "VALUES ('"+ward.getWard_id()+"',"
                 +"'"+ward.getWard_no()+"',"
                 +"'"+ward.getWard_type()+"','Avaliable')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   
      public static Ward getWard(int id){
       
       Ward ward = null ;
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT ward_id, ward_no, ward_type, ward_status  FROM ward WHERE ward_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            ward = new Ward();
            ward.setWard_id(rs.getInt("ward_id"));
            ward.setWard_no(rs.getString("ward_no"));
            ward.setWard_type(rs.getString("ward_type"));
            ward.setWard_status(rs.getString("ward_status"));
            
           
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return ward;
   }
   
   
   public static List<Ward> getWard(){
       
       List<Ward> ward = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT ward_id, ward_no, ward_type, ward_status  FROM ward");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Ward w = new Ward();
            w.setWard_id(rs.getInt("ward_id"));
            w.setWard_no(rs.getString("ward_no"));
            w.setWard_type(rs.getString("ward_type"));
            w.setWard_status(rs.getString("ward_status"));
            
            
            ward.add(w);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return ward;
   }
}
