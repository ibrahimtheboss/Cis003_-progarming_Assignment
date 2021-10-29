/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Discharge;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DischargeUtils {
    public static databaseconn conn ;
    
    public static boolean updateDischarge(Discharge discharge){
       
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE discharge "
                 + "SET admit_id='"+discharge.getAdmit_id()+"', discharge_reason='"+discharge.getDischarge_reason()+"'"
                 + ", ward_id='"+discharge.getWard_id()+"', discharge_date='"+discharge.getDischarge_date()+"'"
                 + ", discharge_time='"+discharge.getDischarge_time()+"', discharge_branch='"+discharge.getDischarge_branch()+"'"
                 + " WHERE (discharge_id ='"+discharge.getDischarge_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteDischarge(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM discharge WHERE (discharge_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
  
   public static boolean addDischarge(Discharge discharge){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO discharge(`discharge_id`,`admit_id`, `discharge_reason`, "
                 + "`ward_id`, `discharge_date`, `discharge_time`, "
                 + "`discharge_branch`)" 
                 + "VALUES ('"+discharge.getDischarge_id()+"',"
                 +"'"+discharge.getAdmit_id()+"',"
                 +"'"+discharge.getDischarge_reason()+"','"+discharge.getWard_id()+"',"
                 +"'"+discharge.getDischarge_date()+"','"+discharge.getDischarge_time()+"',"
                 +"'"+discharge.getDischarge_branch()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
    
   
      public static Discharge getDischarge(int id){
       
       Discharge discharge = null ;
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT discharge_id, admit_id,"
                 + " discharge_reason, ward_id, discharge_date, discharge_time ,"
                 + "discharge_branch FROM discharge WHERE discharge_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            discharge = new Discharge();
            discharge.setDischarge_id(rs.getInt("discharge_id"));
            discharge.setAdmit_id(rs.getInt("admit_id"));
            discharge.setDischarge_reason(rs.getString("discharge_reason"));
            discharge.setWard_id(rs.getInt("ward_id"));
            discharge.setDischarge_date(rs.getString("discharge_date"));
            discharge.setDischarge_time(rs.getString("discharge_time"));
            discharge.setDischarge_branch(rs.getString("discharge_branch"));
            
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return discharge ;
   }
   
   
   public static List<Discharge> getDischarge(){
       
       List<Discharge> discharge = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT discharge_id, admit_id,"
                 + " discharge_reason, ward_id, discharge_date, discharge_time ,"
                 + "discharge_branch FROM discharge");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Discharge dis = new Discharge();
            dis.setDischarge_id(rs.getInt("discharge_id"));
            dis.setAdmit_id(rs.getInt("admit_id"));
            dis.setDischarge_reason(rs.getString("discharge_reason"));
            dis.setWard_id(rs.getInt("ward_id"));
            dis.setDischarge_date(rs.getString("discharge_date"));
            dis.setDischarge_time(rs.getString("discharge_time"));
            dis.setDischarge_branch(rs.getString("discharge_branch"));
            
            
            
            discharge.add(dis);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return discharge;
   }
}
