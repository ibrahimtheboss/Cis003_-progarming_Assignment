/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.bill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BillUtils {
    public static databaseconn conn ;
    
    public static boolean updateBill(bill bill){
       
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE bill "
                 + "SET patient_id='"+bill.getPatient_id()+"', medical_charge='"+bill.getMedical_charge()+"'"
                 + ", appointment_charge='"+bill.getAppointment_charge()+"', hospital_charge='"+bill.getHospital_charge()+"'"
                 + ", discount='"+bill.getDiscount()+"', total='"+bill.getTotal()+"'"
                 + " WHERE (bill_id ='"+bill.getBill_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteBill(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM bill WHERE (bill_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   public static boolean addBill(bill bill){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO bill(`bill_id`,`patient_id`, `medical_charge`, "
                 + "`appointment_charge`, `hospital_charge`, `discount`, "
                 + "`total`)" 
                 + "VALUES ('"+bill.getBill_id()+"',"
                 +"'"+bill.getPatient_id()+"',"
                 +"'"+bill.getMedical_charge()+"','"+bill.getAppointment_charge()+"',"
                 +"'"+bill.getHospital_charge()+"','"+bill.getDiscount()+"',"
                 +"'"+bill.getTotal()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
    
   
      public static bill getBill(int id){
       
       bill bill = null ;
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT bill_id, patient_id, datetime,"
                 + " medical_charge, appointment_charge, hospital_charge, discount ,"
                 + "total FROM bill WHERE bill_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            bill = new bill();
            bill.setBill_id(rs.getInt("bill_id"));
            bill.setPatient_id(rs.getInt("patient_id"));
            bill.setDatetime(rs.getString("datetime"));
            bill.setMedical_charge(rs.getDouble("medical_charge"));
            bill.setAppointment_charge(rs.getDouble("appointment_charge"));
            bill.setHospital_charge(rs.getDouble("hospital_charge"));
            bill.setDiscount(rs.getDouble("discount"));
            bill.setTotal(rs.getDouble("total"));
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return bill ;
   }
   
   
   public static List<bill> getBill(){
       
       List<bill> bill = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT bill_id, patient_id, datetime,"
                 + " medical_charge, appointment_charge, hospital_charge, discount ,"
                 + "total FROM bill");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            bill dis = new bill();
             dis.setBill_id(rs.getInt("bill_id"));
            dis.setPatient_id(rs.getInt("patient_id"));
            dis.setDatetime(rs.getString("datetime"));
            dis.setMedical_charge(rs.getDouble("medical_charge"));
            dis.setAppointment_charge(rs.getDouble("appointment_charge"));
            dis.setHospital_charge(rs.getDouble("hospital_charge"));
            dis.setDiscount(rs.getDouble("discount"));
            dis.setTotal(rs.getDouble("total"));
            
            
            
            bill.add(dis);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return bill;
   }
}
