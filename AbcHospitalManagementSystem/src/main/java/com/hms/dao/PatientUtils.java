/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PatientUtils {
    
    public static databaseconn conn ;
    
    public static boolean updatePatient(Patient patient){
       
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE patient "
                 + "SET patient_fname='"+patient.getPatient_fname()+"', patient_lname='"+patient.getPatient_lname()+"'"
                 + ", patient_dob='"+patient.getPatient_dob()+"', patient_nic='"+patient.getPatient_nic()+"'"
                 + ", patient_phone_no='"+patient.getPatient_phone_no()+"', patient_email='"+patient.getPatient_email()+"'"
                 + ", patient_address='"+patient.getPatient_address()+"', patient_gender='"+patient.getPatient_gender()+"'"
                 + " WHERE (patient_id ='"+patient.getPatient_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deletePatient(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM patient WHERE (patient_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addPatient(Patient patient){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO patient(`patient_id`,`patient_fname`, `patient_lname`, `patient_dob`, `patient_nic`, `patient_phone_no`, "
                 + "`patient_email`, `patient_address`, `patient_gender`)" 
                 + "VALUES ('"+patient.getPatient_id()+"',"
                 +"'"+patient.getPatient_fname()+"',"
                 +"'"+patient.getPatient_lname()+"','"+patient.getPatient_dob()+"',"
                 +"'"+patient.getPatient_nic()+"','"+patient.getPatient_phone_no()+"',"
                 +"'"+patient.getPatient_email()+"','"+patient.getPatient_address()+"',"
                 +"'"+patient.getPatient_gender()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   
      public static Patient getPatient(int id){
       
       Patient patient = null ;
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT patient_id, patient_fname,"
                 + " patient_lname, patient_dob, patient_nic, patient_phone_no ,"
                 + "patient_email, patient_address, patient_gender FROM patient WHERE patient_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column names
            patient = new Patient();
            patient.setPatient_id(rs.getInt("patient_id"));
            patient.setPatient_fname(rs.getString("patient_fname"));
            patient.setPatient_lname(rs.getString("patient_lname"));
            patient.setPatient_dob(rs.getString("patient_dob"));
            patient.setPatient_nic(rs.getString("patient_nic"));
            patient.setPatient_phone_no(rs.getInt("patient_phone_no"));
            patient.setPatient_email(rs.getString("patient_email"));
            patient.setPatient_address(rs.getString("patient_address"));
            patient.setPatient_gender(rs.getString("patient_gender"));
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return patient ;
   }
   
   
   public static List<Patient> getPatient(){
       
       List<Patient> patient = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT patient_id, patient_fname,"
                 + " patient_lname, patient_dob, patient_nic, patient_phone_no ,"
                 + "patient_email, patient_address, patient_gender FROM patient");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Patient p = new Patient();
            p.setPatient_id(rs.getInt("patient_id"));
            p.setPatient_fname(rs.getString("patient_fname"));
            p.setPatient_lname(rs.getString("patient_lname"));
            p.setPatient_dob(rs.getString("patient_dob"));
            p.setPatient_nic(rs.getString("patient_nic"));
            p.setPatient_phone_no(rs.getInt("patient_phone_no"));
            p.setPatient_email(rs.getString("patient_email"));
            p.setPatient_address(rs.getString("patient_address"));
            p.setPatient_gender(rs.getString("patient_gender"));
            
            
            patient.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return patient;
   }
}
