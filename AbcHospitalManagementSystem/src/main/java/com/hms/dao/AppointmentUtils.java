/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Appointment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

public class AppointmentUtils {
     public static databaseconn conn ;
    
    public static boolean updateAppointment(Appointment appointment){
      
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE appointment "
                 + "SET appointment_name='"+appointment.getAppointment_name()+"'"
                 + ",appointment_age='"+appointment.getAppointment_age()+"'"
                 + ",appointment_gender='"+appointment.getAppointment_gender()+"'"
                 + ",doctor_id='"+appointment.getDoctor_id()+"'"
                 + ",appointment_date='"+appointment.getAppointment_date()+"' "
                 + ",appointment_time='"+appointment.getAppointment_time()+"'"
                 + ",appointment_tel='"+appointment.getAppointment_tel()+"'"
                 + " ,patient_id='"+appointment.getPatient_id()+"'"
                 + ", appointment_charge='"+appointment.getAppointment_charge()+"'"
                 + ", appointment_no='"+appointment.getAppointment_no()+"'"
                 + " ,appointment_branch='"+appointment.getAppointment_branch()+"'"
                 + " WHERE (appointment_id ='"+appointment.getAppointment_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteAppointment(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM appointment WHERE (appointment_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean addAppointment(Appointment appointment){
       
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO appointment(`appointment_id`,`appointment_name`, `appointment_age`,"
                 + " `appointment_gender`,`doctor_id`, `appointment_date`, `appointment_time`, "
                 + "`appointment_tel`, `patient_id`, `appointment_charge`, `appointment_no`, `appointment_branch`)" 
                 + "VALUES ('"+appointment.getAppointment_id()+"',"
                 +"'"+appointment.getAppointment_name()+"',"
                 +"'"+appointment.getAppointment_age()+"','"+appointment.getAppointment_gender()+"',"
                 +"'"+appointment.getDoctor_id()+"','"+appointment.getAppointment_date()+"',"
                 +"'"+appointment.getAppointment_time()+"','"+appointment.getAppointment_tel()+"',"
                 +"'"+appointment.getPatient_id()+"','"+appointment.getAppointment_charge()+"',"
                 +"'"+appointment.getAppointment_no()+"','"+appointment.getAppointment_branch()+"')");
           
           
          
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   
      public static Appointment getAppointment(int id){
       
       Appointment appointment = null ;
       
       
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT appointment_id, appointment_name,"
                 + " appointment_age,appointment_gender, doctor_id, appointment_date, "
                 + "appointment_time, appointment_tel, patient_id, appointment_charge ,"
                 + "appointment_no, appointment_branch FROM appointment  WHERE appointment_id =" +id);

         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            appointment = new Appointment();
            appointment.setAppointment_id(rs.getInt("appointment_id"));
            appointment.setAppointment_name(rs.getString("appointment_name"));
            appointment.setAppointment_age(rs.getInt("appointment_age"));
            appointment.setAppointment_gender(rs.getString("appointment_gender"));
            appointment.setDoctor_id(rs.getInt("doctor_id"));
            
            appointment.setAppointment_date(rs.getString("appointment_date"));
            appointment.setAppointment_time(rs.getString("appointment_time"));
            appointment.setAppointment_tel(rs.getInt("appointment_tel"));
            appointment.setPatient_id(rs.getInt("patient_id"));
            appointment.setAppointment_charge(rs.getDouble("appointment_charge"));
            appointment.setAppointment_no(rs.getString("appointment_no"));
            appointment.setAppointment_branch(rs.getString("appointment_branch"));
           
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return appointment ;
   }
   
   
   public static List<Appointment> getAppointment(){
       
       List<Appointment> appointment = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT appointment_id, appointment_name,"
                 + " appointment_age,appointment_gender, doctor_id, appointment_date, "
                 + "appointment_time, appointment_tel, patient_id, appointment_charge ,"
                 + "appointment_no, appointment_branch FROM appointment");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Appointment a = new Appointment();
            a.setAppointment_id(rs.getInt("appointment_id"));
            a.setAppointment_name(rs.getString("appointment_name"));
            a.setAppointment_age(rs.getInt("appointment_age"));
            a.setAppointment_gender(rs.getString("appointment_gender"));
            a.setDoctor_id(rs.getInt("doctor_id"));
            a.setAppointment_date(rs.getString("appointment_date"));
            a.setAppointment_time(rs.getString("appointment_time"));
            a.setAppointment_tel(rs.getInt("appointment_tel"));
            a.setPatient_id(rs.getInt("patient_id"));
            a.setAppointment_charge(rs.getDouble("appointment_charge"));
            a.setAppointment_no(rs.getString("appointment_no"));
            a.setAppointment_branch(rs.getString("appointment_branch"));
            
          
            appointment.add(a);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return appointment;
   }
}
