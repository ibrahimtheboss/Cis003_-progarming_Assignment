/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.dbConnection.databaseconn;
import com.hms.objects.Transfer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TransferUtils {
    
    public static databaseconn conn ;
    
    public static boolean updateTransfer(Transfer transfer){
       
       try{
           conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("UPDATE transfer "
                 + "SET admit_id='"+transfer.getAdmit_id()+"', transfer_reason='"+transfer.getTransfer_reason()+"'"
                 + ", transfer_from='"+transfer.getTransfer_from()+"', transfer_to='"+transfer.getTransfer_to()+"'"
                 + ", transfer_date='"+transfer.getTransfer_date()+"'"
                 + " WHERE (transfer_id ='"+transfer.getTransfer_id()+"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
   
   public static boolean deleteTransfer(int id){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("DELETE FROM transfer WHERE (transfer_id = '"+ id +"')");
      
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
  
   public static boolean addTransfer(Transfer transfer){
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         stmt.executeUpdate("INSERT INTO transfer(`transfer_id`,`admit_id`, `transfer_reason`, "
                 + "`transfer_from`, `transfer_to`, `transfer_date`)" 
                 + "VALUES ('"+transfer.getTransfer_id()+"',"
                 +"'"+transfer.getAdmit_id()+"',"
                 +"'"+transfer.getTransfer_reason()+"','"+transfer.getTransfer_from()+"',"
                 +"'"+transfer.getTransfer_to()+"',"
                 +"'"+transfer.getTransfer_date()+"')");
    
         // Extract data from result set
      return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return false;
   }
   
   
    
   
      public static Transfer getTransfer(int id){
       
       Transfer transfer = null ;
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT transfer_id, admit_id,"
                 + " transfer_reason, transfer_from, transfer_to,"
                 + " transfer_date FROM transfer WHERE transfer_id =" +id);
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            transfer = new Transfer();
            transfer.setTransfer_id(rs.getInt("transfer_id"));
            transfer.setAdmit_id(rs.getInt("admit_id"));
            transfer.setTransfer_reason(rs.getString("transfer_reason"));
            transfer.setTransfer_from(rs.getString("transfer_from"));
            transfer.setTransfer_to(rs.getString("transfer_to"));
            transfer.setTransfer_date(rs.getString("transfer_date"));
            
            
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return transfer ;
   }
   
   
   public static List<Transfer> getTransfer(){
       
       List<Transfer> transfer = new ArrayList<>();
       
       try{
          conn = databaseconn.getInstance(); 
         Statement stmt = conn.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT transfer_id, admit_id,"
                 + " transfer_reason, transfer_from, transfer_to, transfer_date FROM transfer");
    
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            Transfer tr = new Transfer();
            tr.setTransfer_id(rs.getInt("transfer_id"));
            tr.setAdmit_id(rs.getInt("admit_id"));
            tr.setTransfer_reason(rs.getString("transfer_reason"));
            tr.setTransfer_from(rs.getString("transfer_from"));
            tr.setTransfer_to(rs.getString("transfer_to"));
            tr.setTransfer_date(rs.getString("transfer_date"));
            
            
            
            transfer.add(tr);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
       return transfer;
   }
}
