/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Appointment;
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
public class AppointmentUtilsTest {
    
    public AppointmentUtilsTest() {
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
     * Test of updateAppointment method, of class AppointmentUtils.
    
    @Test
    public void testUpdateAppointment() {
        System.out.println("updateAppointment");
        
        //Update the appointment
        Appointment appointment = new Appointment(3,"Junty",12,"Male",8,"2021-10-13","16:26",778845147,1,2500.0,"47","Colombo");
       double charge = appointment.getAppointment_charge();
        boolean result = AppointmentUtils.updateAppointment(appointment);
        assertEquals(true, result);
        
       
        
        //Check the added admit Appointment
        Appointment resultAppointment = AppointmentUtils.getAppointment(appointment.getAppointment_id());
        assertEquals(appointment.getAppointment_name(), resultAppointment.getAppointment_name());
        assertEquals(appointment.getAppointment_age(), resultAppointment.getAppointment_age());
        assertEquals(appointment.getAppointment_gender(), resultAppointment.getAppointment_gender());
        assertEquals(appointment.getDoctor_id(), resultAppointment.getDoctor_id());
        assertEquals(appointment.getAppointment_date(), resultAppointment.getAppointment_date());
        assertEquals(appointment.getAppointment_time(), resultAppointment.getAppointment_time());
        assertEquals(appointment.getAppointment_tel(), resultAppointment.getAppointment_tel());
        assertEquals(appointment.getPatient_id(), resultAppointment.getPatient_id());
        assertEquals(appointment.getAppointment_charge(), resultAppointment.getAppointment_charge(),charge);
        assertEquals(appointment.getAppointment_no(), resultAppointment.getAppointment_no());
        assertEquals(appointment.getAppointment_branch(), resultAppointment.getAppointment_branch());
        
    }*/
 
    /**
     * Test of deleteAppointment method, of class AppointmentUtils.
     
    @Test
    public void testDeleteAppointment() {
        System.out.println("deleteAppointment");
        int id = 8;
        boolean expResult = AppointmentUtils.deleteAppointment(id);
        boolean result = AppointmentUtils.deleteAppointment(id);
        assertEquals(true, result);
        
    }
*/
    /**
     * Test of addAppointment method, of class AppointmentUtils.
    
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        Appointment appointment = new Appointment(3,"Junty",12,"Male",8,"2021-10-13","16:26",778845147,1,2500.0,"47","Colombo");
         //Add the Appointment
         double charge = appointment.getAppointment_charge();
        boolean result = AppointmentUtils.addAppointment(appointment);
        assertEquals(true, result);
        //Check the added admit Appointment
        Appointment resultAppointment = AppointmentUtils.getAppointment(appointment.getAppointment_id());
        assertEquals(appointment.getAppointment_name(), resultAppointment.getAppointment_name());
        assertEquals(appointment.getAppointment_age(), resultAppointment.getAppointment_age());
        assertEquals(appointment.getAppointment_gender(), resultAppointment.getAppointment_gender());
        assertEquals(appointment.getDoctor_id(), resultAppointment.getDoctor_id());
        assertEquals(appointment.getAppointment_date(), resultAppointment.getAppointment_date());
        assertEquals(appointment.getAppointment_time(), resultAppointment.getAppointment_time());
        assertEquals(appointment.getAppointment_tel(), resultAppointment.getAppointment_tel());
        assertEquals(appointment.getPatient_id(), resultAppointment.getPatient_id());
        assertEquals(appointment.getAppointment_charge(), resultAppointment.getAppointment_charge(),charge);
        assertEquals(appointment.getAppointment_no(), resultAppointment.getAppointment_no());
        assertEquals(appointment.getAppointment_branch(), resultAppointment.getAppointment_branch());
        
       
    } */

    /**
     * Test of getAppointment method, of class AppointmentUtils.
     /
    @Test
    public void testGetAppointment_int() {
        System.out.println("getAppointment");
        int id = 3;
        Appointment expResult = new Appointment(3,"Junty",12,"Male",8,"2021-10-13","16:26",778845147,1,2500.0,"47","Colombo");
        double charge = expResult.getAppointment_charge();
        Appointment result = AppointmentUtils.getAppointment(id);
        //Check the  admit Appointment
        
        assertEquals(expResult.getAppointment_id(), result.getAppointment_id());
        assertEquals(expResult.getAppointment_name(), result.getAppointment_name());
        assertEquals(expResult.getAppointment_age(), result.getAppointment_age());
        assertEquals(expResult.getAppointment_gender(), result.getAppointment_gender());
        assertEquals(expResult.getDoctor_id(), result.getDoctor_id());
        assertEquals(expResult.getAppointment_date(), result.getAppointment_date());
        assertEquals(expResult.getAppointment_time(), result.getAppointment_time());
        assertEquals(expResult.getAppointment_tel(), result.getAppointment_tel());
        assertEquals(expResult.getPatient_id(), result.getPatient_id());
        assertEquals(expResult.getAppointment_charge(), result.getAppointment_charge(),charge);
        assertEquals(expResult.getAppointment_no(), result.getAppointment_no());
        assertEquals(expResult.getAppointment_branch(), result.getAppointment_branch());
        
    }
*/
   
}
