/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Admit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AdmitUtils {
     public static databaseconn conn ;
    
    public static boolean updateAdmit(Admit admit){
       
       
        
        
        
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE admit "
                 + "SET patient_id='"+admit.getPatient_id()+"', admit_reason='"+admit.getAdmit_reason()+"'"
                 + ", ward_id='"+admit.getWard_id()+"', admit_date='"+admit.getAdmit_date()+"'"
                 + ", admit_time='"+admit.getAdmit_time()+"', admit_branch='"+admit.getAdmit_branch()+"'"
                 + " WHERE (admit_id ='"+admit.getAdmit_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteAdmit(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM admit WHERE (admit_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
  
   public static boolean addAdmit(Admit admit){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO admit(`admit_id`,`patient_id`, `admit_reason`, "
                 + "`ward_id`, `admit_date`, `admit_time`, "
                 + "`admit_branch`)" 
                 + "VALUES ('"+admit.getAdmit_id()+"',"
                 +"'"+admit.getPatient_id()+"',"
                 +"'"+admit.getAdmit_reason()+"','"+admit.getWard_id()+"',"
                 +"'"+admit.getAdmit_date()+"','"+admit.getAdmit_time()+"',"
                 +"'"+admit.getAdmit_branch()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
    
   
      public static Admit getAdmit(int id){
       
       Admit admit = null ;
       
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT admit_id, patient_id,"
                 + " admit_reason, ward_id, admit_date, admit_time ,"
                 + "admit_branch FROM admit WHERE admit_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            admit = new Admit();
            admit.setAdmit_id(rs.getInt("admit_id"));
            admit.setPatient_id(rs.getInt("patient_id"));
            admit.setAdmit_reason(rs.getString("admit_reason"));
            admit.setWard_id(rs.getInt("ward_id"));
            admit.setAdmit_date(rs.getString("admit_date"));
            admit.setAdmit_time(rs.getString("admit_time"));
            admit.setAdmit_branch(rs.getString("admit_branch"));
            
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return admit ;
   }
   
   
   public static List<Admit> getAdmit(){
       
       List<Admit> admit = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT admit_id, patient_id,"
                 + " admit_reason, ward_id, admit_date, admit_time ,"
                 + "admit_branch FROM admit");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Admit ad = new Admit();
            ad.setAdmit_id(rs.getInt("admit_id"));
            ad.setPatient_id(rs.getInt("patient_id"));
            ad.setAdmit_reason(rs.getString("admit_reason"));
            ad.setWard_id(rs.getInt("ward_id"));
            ad.setAdmit_date(rs.getString("admit_date"));
            ad.setAdmit_time(rs.getString("admit_time"));
            ad.setAdmit_branch(rs.getString("admit_branch"));
            
            
            
            admit.add(ad);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return admit;
   }
   
    
}
