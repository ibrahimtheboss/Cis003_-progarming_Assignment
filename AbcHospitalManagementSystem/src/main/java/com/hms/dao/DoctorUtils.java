/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DoctorUtils {
    
    public static databaseconn conn ;
    
     public static boolean updateDoctor(doctor d){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE doctor "
                 + "SET doc_fname='"+d.getDoc_firstname()+"', doc_lname='"+d.getDoc_lastname()+"'"
                 + ", doc_dob='"+d.getDoc_dateofbirth()+"', doc_nic_no='"+d.getDoc_nic_no()+"'"
                 + ", doc_sex='"+d.getDoc_sex()+"', doc_phone_no='"+d.getDoc_phone_no()+"'"
                 + ", doc_address='"+d.getDoc_address()+"', specilization='"+d.getSpecilization()+"'"
                 + ", doc_department='"+d.getDoc_department()+"', branch='"+d.getBranch()+"'"
                 + " WHERE (doc_id ='"+d.getDoc_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteDoctor(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM doctor WHERE (doc_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addDoctor(doctor d){
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO doctor(`doc_id`,`doc_fname`, `doc_lname`, `doc_dob`, `doc_nic_no`, `doc_sex`, "
                 + "`doc_phone_no`, `doc_address`, `specilization`, `doc_department`, `branch`)" 
                 + "VALUES ('"+d.getDoc_id() +"',"
                 +"'"+d.getDoc_firstname()+"',"
                 +"'"+d.getDoc_lastname()+"','"+d.getDoc_dateofbirth()+"',"
                 +"'"+d.getDoc_nic_no()+"','"+d.getDoc_sex()+"',"
                 +"'"+d.getDoc_phone_no()+"','"+d.getDoc_address()+"',"
                 +"'"+d.getSpecilization()+"','"+d.getDoc_department()+"',"
                 +"'"+d.getBranch()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   
      public static doctor getDoctor(int id){
       
       doctor d = null ;
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT doc_id, doc_fname, doc_lname, doc_dob, doc_nic_no, doc_sex ,"
                 + "doc_phone_no, doc_address, specilization, doc_department, branch FROM doctor WHERE doc_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            d = new doctor();
            d.setDoc_id(rs.getInt("doc_id"));
            d.setDoc_firstname(rs.getString("doc_fname"));
            d.setDoc_lastname(rs.getString("doc_lname"));
            d.setDoc_dateofbirth(rs.getString("doc_dob"));
            d.setDoc_nic_no(rs.getString("doc_nic_no"));
            d.setDoc_sex(rs.getString("doc_sex"));
            d.setDoc_phone_no(rs.getInt("doc_phone_no"));
            d.setDoc_address(rs.getString("doc_address"));
            d.setSpecilization(rs.getString("specilization"));
            d.setDoc_department(rs.getString("doc_department"));
            d.setBranch(rs.getString("branch"));
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return d;
   }
   
   
   public static List<doctor> getDoctor(){
       
       List<doctor> d = new ArrayList<>();
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT doc_id, doc_fname, doc_lname, doc_dob, doc_nic_no, doc_sex, doc_phone_no, doc_address, specilization, doc_department, branch FROM doctor");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            doctor all = new doctor();
            all.setDoc_id(rs.getInt("doc_id"));
            all.setDoc_firstname(rs.getString("doc_fname"));
            all.setDoc_lastname(rs.getString("doc_lname"));
            all.setDoc_dateofbirth(rs.getString("doc_dob"));
            all.setDoc_nic_no(rs.getString("doc_nic_no"));
            all.setDoc_sex(rs.getString("doc_sex"));
            all.setDoc_phone_no(rs.getInt("doc_phone_no"));
            all.setDoc_address(rs.getString("doc_address"));
            all.setSpecilization(rs.getString("specilization"));
            all.setDoc_department(rs.getString("doc_department"));
            all.setBranch(rs.getString("branch"));
            
            d.add(all);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return d;
   }
}
