/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Patient;
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
public class PatientUtilsTest {
    
    public PatientUtilsTest() {
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
     * Test of updatePatient method, of class PatientUtils.
                        // pass
    @Test               
    public void testUpdatePatient() {
        System.out.println("updatePatient");
        //Update the patient
        Patient patient = new Patient(9,"Casim", "Khan", "1984-08-11", "198461155v" ,
         778489123,"Casimkhan@gmail.com","172,Bambalapity","male");
        boolean result = PatientUtils.updatePatient(patient);
        assertEquals(true, result);
        
        //Check the added patient
        Patient resultPatient = PatientUtils.getPatient(patient.getPatient_id());
        assertEquals(patient.getPatient_id(), resultPatient.getPatient_id());
        assertEquals(patient.getPatient_fname(), resultPatient.getPatient_fname());
        assertEquals(patient.getPatient_lname(), resultPatient.getPatient_lname());
        assertEquals(patient.getPatient_dob(), resultPatient.getPatient_dob());
        assertEquals(patient.getPatient_nic(), resultPatient.getPatient_nic());
        assertEquals(patient.getPatient_phone_no(), resultPatient.getPatient_phone_no());
        assertEquals(patient.getPatient_email(), resultPatient.getPatient_email());
        assertEquals(patient.getPatient_address(), resultPatient.getPatient_address());
        assertEquals(patient.getPatient_gender(), resultPatient.getPatient_gender());
    }
    */
    /**
     * Test of deletePatient method, of class PatientUtils.
     *                   // pass
    @Test
    public void testDeletePatient() {
        System.out.println("deletePatient");
        
        //Delete the Patient
        int id = 8;
        
        boolean result = PatientUtils.deletePatient(id);
        boolean resultPatient = PatientUtils.deletePatient(id);
        assertEquals(true, result);
       
       
    }*/ 
  
    /**
     * Test of addPatient method, of class PatientUtils.
     * 
      
    @Test
    public void testAddPatient() {
        System.out.println("addPatient");
        Patient patient =  new Patient(8,"Casim", "Khan", "1994-08-11", 
                "199761155v" ,778489123,"Casimkhan@gmail.com","172,Bambalapity","male");
       //Add the patient
        boolean result = PatientUtils.addPatient(patient);
        assertEquals(true, result);
        
        //Check the added patient
        Patient resultPatient = PatientUtils.getPatient(patient.getPatient_id());
        assertEquals(patient.getPatient_id(), resultPatient.getPatient_id());
        assertEquals(patient.getPatient_fname(), resultPatient.getPatient_fname());
        assertEquals(patient.getPatient_lname(), resultPatient.getPatient_lname());
        assertEquals(patient.getPatient_dob(), resultPatient.getPatient_dob());
        assertEquals(patient.getPatient_nic(), resultPatient.getPatient_nic());
        assertEquals(patient.getPatient_phone_no(), resultPatient.getPatient_phone_no());
        assertEquals(patient.getPatient_email(), resultPatient.getPatient_email());
        assertEquals(patient.getPatient_address(), resultPatient.getPatient_address());
        assertEquals(patient.getPatient_gender(), resultPatient.getPatient_gender());
      
        
    }
*/ 
    /**
     * Test of getPatient method, of class PatientUtils.  // pass
     */
    @Test
    public void testGetPatient_int() {
        System.out.println("getPatient");
        int id = 1;
        Patient expResult = new Patient(1,"Gary", "Hard", "1987-10-15", "100061155v"
                , 778455666,"gary@gmail.com","123,mount lavinia","male");
        Patient result = PatientUtils.getPatient(id);
        assertEquals(expResult.getPatient_id(), result.getPatient_id());
        assertEquals(expResult.getPatient_fname(), result.getPatient_fname());
        assertEquals(expResult.getPatient_lname(), result.getPatient_lname());
        assertEquals(expResult.getPatient_dob(), result.getPatient_dob());
        assertEquals(expResult.getPatient_nic(), result.getPatient_nic());
        assertEquals(expResult.getPatient_phone_no(), result.getPatient_phone_no());
        assertEquals(expResult.getPatient_email(), result.getPatient_email());
        assertEquals(expResult.getPatient_address(), result.getPatient_address());
        assertEquals(expResult.getPatient_gender(), result.getPatient_gender());
    }

   
    
}
