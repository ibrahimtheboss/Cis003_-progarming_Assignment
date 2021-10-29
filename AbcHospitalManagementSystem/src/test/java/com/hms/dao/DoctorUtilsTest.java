/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.doctor;
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
public class DoctorUtilsTest {
    
    public DoctorUtilsTest() {
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
     * Test of updateDoctor method, of class DoctorUtils.
     
    @Test
    public void testUpdateDoctor() {
        System.out.println("updateDoctor");
        doctor d = new doctor(11,"YENURA","MUNASINGHE","1976-10-27","8986656580","Male",775643219,"1234 Main Street","ALLERGY  AND IMMUNOLOGIST","ALLERGY HOPITAL UNIT","Galle");
       
        boolean result = DoctorUtils.updateDoctor(d);
        assertEquals(true, result);
       
        
        //Check the added doctor
        doctor resultdoctor = DoctorUtils.getDoctor(d.getDoc_id());
        assertEquals(d.getDoc_firstname(), resultdoctor.getDoc_firstname());
        assertEquals(d.getDoc_lastname(), resultdoctor.getDoc_lastname());
        assertEquals(d.getDoc_dateofbirth(), resultdoctor.getDoc_dateofbirth());
        assertEquals(d.getDoc_sex(), resultdoctor.getDoc_sex());
        assertEquals(d.getDoc_phone_no(), resultdoctor.getDoc_phone_no());
        assertEquals(d.getDoc_address(), resultdoctor.getDoc_address());
        assertEquals(d.getSpecilization(), resultdoctor.getSpecilization());
        assertEquals(d.getDoc_department(), resultdoctor.getDoc_department());
        assertEquals(d.getBranch(), resultdoctor.getBranch());
    }
*/
    /**
     * Test of deleteDoctor method, of class DoctorUtils.
    
    @Test
    public void testDeleteDoctor() {
        System.out.println("deleteDoctor");
        int id = 12;
        boolean expResult = DoctorUtils.deleteDoctor(id);
        boolean result = DoctorUtils.deleteDoctor(id);
        assertEquals(true, result);
        
    }
 */
    /**
     * Test of addDoctor method, of class DoctorUtils.
     
    @Test
    public void testAddDoctor() {
        System.out.println("addDoctor");
        doctor d = new doctor(11,"YENURA","MUNASINGHE","1976-10-27","8986656580","Male",775643219,"1234 Main Street","ALLERGY  AND IMMUNOLOGIST","ALLERGY HOPITAL UNIT","Galle");
        //Add the doctor
        boolean result = DoctorUtils.addDoctor(d);
        assertEquals(true, result);
        
      
         //Check the added doctor
        doctor resultdoctor = DoctorUtils.getDoctor(d.getDoc_id());
        assertEquals(d.getDoc_firstname(), resultdoctor.getDoc_firstname());
        assertEquals(d.getDoc_lastname(), resultdoctor.getDoc_lastname());
        assertEquals(d.getDoc_dateofbirth(), resultdoctor.getDoc_dateofbirth());
        assertEquals(d.getDoc_sex(), resultdoctor.getDoc_sex());
        assertEquals(d.getDoc_phone_no(), resultdoctor.getDoc_phone_no());
        assertEquals(d.getDoc_address(), resultdoctor.getDoc_address());
        assertEquals(d.getSpecilization(), resultdoctor.getSpecilization());
        assertEquals(d.getDoc_department(), resultdoctor.getDoc_department());
        assertEquals(d.getBranch(), resultdoctor.getBranch());
    }
*/
    /**
     * Test of getDoctor method, of class DoctorUtils.
   
    @Test
    public void testGetDoctor_int() {
        System.out.println("getDoctor");
        int id = 11;
        doctor expResult = new doctor(11,"YENURA","MUNASINGHE","1976-10-27","8986656580","Male",775643219,"1234 Main Street","ALLERGY  AND IMMUNOLOGIST","ALLERGY HOPITAL UNIT","Galle");
        doctor result = DoctorUtils.getDoctor(id);
       
        assertEquals(expResult.getDoc_id(), result.getDoc_id());
        assertEquals(expResult.getDoc_firstname(), result.getDoc_firstname());
        assertEquals(expResult.getDoc_lastname(), result.getDoc_lastname());
        assertEquals(expResult.getDoc_dateofbirth(), result.getDoc_dateofbirth());
        assertEquals(expResult.getDoc_sex(), result.getDoc_sex());
        assertEquals(expResult.getDoc_phone_no(), result.getDoc_phone_no());
        assertEquals(expResult.getDoc_address(), result.getDoc_address());
        assertEquals(expResult.getSpecilization(), result.getSpecilization());
        assertEquals(expResult.getDoc_department(), result.getDoc_department());
        assertEquals(expResult.getBranch(), result.getBranch());
    }
 
    */
}
