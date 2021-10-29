/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;


import static com.hms.dao.AppointmentUtils.conn;
import com.hms.dbConnection.databaseconn;

import com.hms.objects.AppointmentList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AppointmentReadUtils {
    public static databaseconn conn ;
    public static AppointmentList getAppointmentList(int id){
       
       AppointmentList appointmentlist = null ;
       
       
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT a.appointment_id, a.appointment_name,"
                 + " a.appointment_age,a.appointment_gender, a.doctor_id,d.doc_fname,d.doc_lname, a.appointment_date, "
                 + "a.appointment_time, a.appointment_tel, a.patient_id, a.appointment_charge ,"
                 + "a.appointment_no, a.appointment_branch FROM appointment a LEFT JOIN doctor d ON a.doctor_id= d.doc_id"
                 + " WHERE a.appointment_id =" +id);

         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            appointmentlist = new AppointmentList();
            appointmentlist.setAppointmentList_id(rs.getInt("a.appointment_id"));
            appointmentlist.setAppointmentList_name(rs.getString("a.appointment_name"));
            appointmentlist.setAppointmentList_age(rs.getInt("a.appointment_age"));
            appointmentlist.setAppointmentList_gender(rs.getString("a.appointment_gender"));
            appointmentlist.setDoctor_id(rs.getInt("a.doctor_id"));
            appointmentlist.setDoctor_fname(rs.getString("d.doc_fname"));
            appointmentlist.setDoctor_lname(rs.getString("d.doc_lname"));
            appointmentlist.setAppointmentList_date(rs.getString("a.appointment_date"));
            appointmentlist.setAppointmentList_time(rs.getString("a.appointment_time"));
            appointmentlist.setAppointmentList_tel(rs.getInt("a.appointment_tel"));
            appointmentlist.setPatient_id(rs.getInt("a.patient_id"));
            appointmentlist.setAppointmentList_charge(rs.getDouble("a.appointment_charge"));
            appointmentlist.setAppointmentList_no(rs.getString("a.appointment_no"));
            appointmentlist.setAppointmentList_branch(rs.getString("a.appointment_branch"));
           
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return appointmentlist ;
   }
    
     public static List<AppointmentList> getAppointment(){
       
       List<AppointmentList> appointmentlist = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT a.appointment_id, a.appointment_name,"
                 + " a.appointment_age,a.appointment_gender, a.doctor_id,d.doc_fname,d.doc_lname, a.appointment_date, "
                 + "a.appointment_time, a.appointment_tel, a.patient_id, a.appointment_charge ,"
                 + "a.appointment_no, a.appointment_branch FROM appointment a LEFT JOIN doctor d ON a.doctor_id= d.doc_id");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            AppointmentList a = new AppointmentList();
            a.setAppointmentList_id(rs.getInt("a.appointment_id"));
            a.setAppointmentList_name(rs.getString("a.appointment_name"));
            a.setAppointmentList_age(rs.getInt("a.appointment_age"));
            a.setAppointmentList_gender(rs.getString("a.appointment_gender"));
            a.setDoctor_id(rs.getInt("a.doctor_id"));
            a.setDoctor_fname(rs.getString("d.doc_fname"));
            a.setDoctor_lname(rs.getString("d.doc_lname"));
            a.setAppointmentList_date(rs.getString("a.appointment_date"));
            a.setAppointmentList_time(rs.getString("a.appointment_time"));
            a.setAppointmentList_tel(rs.getInt("a.appointment_tel"));
            a.setPatient_id(rs.getInt("a.patient_id"));
            a.setAppointmentList_charge(rs.getDouble("a.appointment_charge"));
            a.setAppointmentList_no(rs.getString("a.appointment_no"));
            a.setAppointmentList_branch(rs.getString("a.appointment_branch"));
            
          
            appointmentlist.add(a);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return appointmentlist;
   }
}
