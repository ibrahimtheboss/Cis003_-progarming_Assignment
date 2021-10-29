/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Medicine;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Medicine
 */
public class MedicineUtils {
     public static databaseconn conn ;
    
   public static boolean updateMedicine(Medicine medicine){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE medicine "
                 + "SET medicine_name='"+medicine.getMedicine_name()+"', medicine_code='"+medicine.getMedicine_code()+"'"
                 + ", medicine_price='"+medicine.getMedicine_price()+"', medicine_qty='"+medicine.getMedicine_qty()+"'"
                 + " WHERE (medicine_id ='"+medicine.getMedicine_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteMedicine(int id){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM medicine WHERE (medicine_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addMedicine(Medicine medicine){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO medicine(`medicine_id`,`medicine_name`, `medicine_code`, "
                 + "`medicine_price`, `medicine_qty`)" 
                 + "VALUES ('"+medicine.getMedicine_id()+"',"
                 +"'"+medicine.getMedicine_name()+"',"
                 +"'"+medicine.getMedicine_code()+"','"+medicine.getMedicine_price()+"',"
                         + "'"+medicine.getMedicine_qty()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
  
   
   
      public static Medicine getMedicine(int id){
       
       Medicine medicine = null ;
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT medicine_id, medicine_name, "
                 + "medicine_code, medicine_price , medicine_qty FROM medicine WHERE medicine_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            medicine = new Medicine();
            medicine.setMedicine_id(rs.getInt("medicine_id"));
            medicine.setMedicine_name(rs.getString("medicine_name"));
            medicine.setMedicine_code(rs.getString("medicine_code"));
            medicine.setMedicine_price(rs.getDouble("medicine_price"));
            medicine.setMedicine_qty(rs.getString("medicine_qty"));
           
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return medicine;
   }
   
   
   public static List<Medicine> getMedicine(){
       
       List<Medicine> medicine = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT medicine_id, medicine_name, "
                 + "medicine_code, medicine_price , medicine_qty FROM medicine");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Medicine med = new Medicine();
            med = new Medicine();
            med.setMedicine_id(rs.getInt("medicine_id"));
            med.setMedicine_name(rs.getString("medicine_name"));
            med.setMedicine_code(rs.getString("medicine_code"));
            med.setMedicine_price(rs.getDouble("medicine_price"));
            med.setMedicine_qty(rs.getString("medicine_qty"));
            
            
            medicine.add(med);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return medicine;
   }
}
