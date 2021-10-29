/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.bill;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BillUtilsTest {
    
    public BillUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateBill method, of class BillUtils.
     
    @Test
    public void testUpdateBill() {
        System.out.println("updateBill");
        bill bill = new bill(1,1,"2021-10-24 19:32:40",2.0,5.0,45.0,4.0,48.0) ;
        double Appointment_charge = bill.getAppointment_charge();
        double Medical_charge = bill.getMedical_charge();
        double Hospital_charge = bill.getHospital_charge();
        double Discount_charge = bill.getDiscount();
        double Total_charge = bill.getTotal();
        boolean result = BillUtils.updateBill(bill);
        assertEquals(true, result);
        
       
       
        
        //Check the added admit Appointment
       
        
        bill resultbill = BillUtils.getBill(bill.getBill_id());
        assertEquals(bill.getPatient_id(), resultbill.getPatient_id());
        assertEquals(bill.getMedical_charge(), resultbill.getMedical_charge(),Medical_charge);
        assertEquals(bill.getAppointment_charge(), resultbill.getAppointment_charge(),Appointment_charge);
        assertEquals(bill.getHospital_charge(), resultbill.getHospital_charge(),Hospital_charge);
        assertEquals(bill.getDiscount(), resultbill.getDiscount(),Discount_charge);
        assertEquals(bill.getTotal(), resultbill.getTotal(),Total_charge);
        
    }*/

    /**
     * Test of deleteBill method, of class BillUtils.
    
    @Test
    public void testDeleteBill() {
        System.out.println("deleteBill");
        int id = 4;
        boolean expResult = BillUtils.deleteBill(id);
        boolean result = BillUtils.deleteBill(id);
        assertEquals(true, result);
   
    } */

    /**
     * Test of addBill method, of class BillUtils.
     
    @Test
    public void testAddBill() {
        System.out.println("addBill");
        bill bill = new bill(1,1,"2021-10-24 19:32:40",2.0,5.0,45.0,4.0,48.0) ;
        double Appointment_charge = bill.getAppointment_charge();
        double Medical_charge = bill.getMedical_charge();
        double Hospital_charge = bill.getHospital_charge();
        double Discount_charge = bill.getDiscount();
        double Total_charge = bill.getTotal();
        //Add the bill
        boolean result = BillUtils.addBill(bill);
        assertEquals(true, result);
         
        bill resultbill = BillUtils.getBill(bill.getBill_id());
        assertEquals(bill.getPatient_id(), resultbill.getPatient_id());
        assertEquals(bill.getMedical_charge(), resultbill.getMedical_charge(),Medical_charge);
        assertEquals(bill.getAppointment_charge(), resultbill.getAppointment_charge(),Appointment_charge);
        assertEquals(bill.getHospital_charge(), resultbill.getHospital_charge(),Hospital_charge);
        assertEquals(bill.getDiscount(), resultbill.getDiscount(),Discount_charge);
        assertEquals(bill.getTotal(), resultbill.getTotal(),Total_charge);
        
        
    }*/

    /**
     * Test of getBill method, of class BillUtils.
    
    @Test
    public void testGetBill_int() {
        System.out.println("getBill");
        int id = 1;
        bill expResult = new bill(1,1,"2021-10-24 19:32:40",2.0,5.0,45.0,4.0,48.0) ;
        double Appointment_charge = expResult.getAppointment_charge();
        double Medical_charge = expResult.getMedical_charge();
        double Hospital_charge = expResult.getHospital_charge();
        double Discount_charge = expResult.getDiscount();
        double Total_charge = expResult.getTotal();
        bill result = BillUtils.getBill(id);
        
        
        assertEquals(expResult.getBill_id(), result.getBill_id());
         assertEquals(expResult.getPatient_id(), result.getPatient_id());
        assertEquals(expResult.getMedical_charge(), result.getMedical_charge(),Medical_charge);
        assertEquals(expResult.getAppointment_charge(), result.getAppointment_charge(),Appointment_charge);
        assertEquals(expResult.getHospital_charge(), result.getHospital_charge(),Hospital_charge);
        assertEquals(expResult.getDiscount(), result.getDiscount(),Discount_charge);
        assertEquals(expResult.getTotal(), result.getTotal(),Total_charge);
        
        
    }
 */
    
}
