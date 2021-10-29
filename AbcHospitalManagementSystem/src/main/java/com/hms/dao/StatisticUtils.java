/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;


import com.hms.dbConnection.databaseconn;

import com.hms.objects.Statistics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class StatisticUtils {
     public static databaseconn conn ;
      public static List<Statistics> getStatistics(){
       
       List<Statistics> statistics = new ArrayList<>();
       
       try{
         conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs;
           rs = stmt.executeQuery(" SELECT (SELECT COUNT(*)FROM users)as total_users,"
                   + " (SELECT COUNT(*)FROM doctor ) AS total_doc,"
                   + " (SELECT COUNT(*) FROM patient)AS total_patient, "
                   + "(SELECT COUNT(*) FROM ward) AS total_wards,"
                   + "(SELECT COUNT(*)FROM ward WHERE ward_status='Avaliable') AS total_ward_av ,"
                   + "(SELECT COUNT(*) FROM ward WHERE ward_status='Taken') AS total_ward_tk,"
                   + "(SELECT COUNT(*) FROM appointment) AS total_appoint ,"
                   + "(SELECT COUNT(*) FROM admit) AS total_admit ,"
                   + "(SELECT COUNT(*) FROM discharge) AS total_discharge ,"
                   + "(SELECT COUNT(*)FROM admit)-(SELECT COUNT(*) FROM discharge) AS total_admit_now ,"
                   + "(SELECT COUNT(*) FROM transfer) AS total_transfer,"
                   + "(SELECT COUNT(*) FROM medicine) AS total_medtype  ,"
                   + "(SELECT SUM(total) FROM bill) AS total_revenue "); 
                  
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Statistics s = new Statistics();
            s.setTotal_user(rs.getInt("total_users"));
            s.setTotal_doctor(rs.getInt("total_doc"));
            s.setTotal_patientreg(rs.getInt("total_patient"));
             s.setTotal_wards(rs.getInt("total_wards"));
             s.setTotal_wards_av(rs.getInt("total_ward_av"));
             s.setTotal_wards_tk(rs.getInt("total_ward_tk"));
             s.setTotal_appoint(rs.getInt("total_appoint"));
             s.setTotal_admit(rs.getInt("total_admit"));
             s.setTotal_discharge(rs.getInt("total_discharge"));
             s.setTotal_curadmit(rs.getInt("total_admit_now"));
             s.setTotal_transfers(rs.getInt("total_transfer"));
             s.setTotal_medicine(rs.getInt("total_medtype"));
             s.setTotal_revenue(rs.getInt("total_revenue"));
            
            statistics.add(s);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return statistics;
   }
     
}
