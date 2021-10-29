/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;


import com.hms.dbConnection.databaseconn;
import com.hms.objects.AdmittedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class AdmittedListUtils {
    public static databaseconn conn ;
    // this is to generate full detail report for addimiteed patients in the hospital
    
    public static AdmittedList getAdmitdetails(int id1){
       
       AdmittedList admit1 = null ;
       
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT a.admit_id, a.patient_id , p.patient_fname,"
                 + " a.admit_reason, a.ward_id,w.ward_no, a.admit_date, a.admit_time ,"
                 + "a.admit_branch"
                 + " FROM admit a RIGHT JOIN patient p ON a.patient_id=p.patient_id"
                 + " LEFT JOIN ward w ON a.ward_id=w.ward_id "
                 + " WHERE a.admit_id =" +id1);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            admit1 = new AdmittedList();
            admit1.setAdmit_id(rs.getInt("a.admit_id"));
            admit1.setPatient_id(rs.getInt("a.patient_id"));
            admit1.setPatient_name(rs.getString("p.patient_fname"));
            admit1.setAdmit_reason(rs.getString("a.admit_reason"));
            admit1.setWard_id(rs.getInt("a.ward_id"));
            admit1.setWard_no(rs.getString("w.ward_no"));
            admit1.setAdmit_date(rs.getString("a.admit_date"));
            admit1.setAdmit_time(rs.getString("a.admit_time"));
            admit1.setAdmit_branch(rs.getString("a.admit_branch"));
            
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return admit1 ;
   }
}
