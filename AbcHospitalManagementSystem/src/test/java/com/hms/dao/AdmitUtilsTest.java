/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Admit;
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

public class AdmitUtilsTest {
    
    public AdmitUtilsTest() {
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
     * Test of updateAdmit method, of class AdmitUtils.
     *                                                  ///test Pass
    @Test
    public void testUpdateAdmit() {
        System.out.println("updateAdmit");
        //Update the admit
        Admit admit = new Admit(5,6,"Covid-19",9,"2021-10-27","07:24","Jaffna");
        boolean result = AdmitUtils.updateAdmit(admit);
        assertEquals(true, result);
        
        
        //Check the added admit Patient
        Admit resultAdmit = AdmitUtils.getAdmit(admit.getAdmit_id());
        assertEquals(admit.getPatient_id(), resultAdmit.getPatient_id());
        assertEquals(admit.getAdmit_reason(), resultAdmit.getAdmit_reason());
        assertEquals(admit.getWard_id(), resultAdmit.getWard_id());
        assertEquals(admit.getAdmit_date(), resultAdmit.getAdmit_date());
        assertEquals(admit.getAdmit_time(), resultAdmit.getAdmit_time());
        assertEquals(admit.getAdmit_branch(), resultAdmit.getAdmit_branch());
        
      
    } */
 
    /**
     * Test of deleteAdmit method, of class AdmitUtils.
    
    @Test
    public void testDeleteAdmit() {
    //Delete the Patient
        System.out.println("deleteAdmit");
        int id = 5;
        boolean expResult = AdmitUtils.deleteAdmit(id);
        boolean resultAdmit =  AdmitUtils.deleteAdmit(id);;
        assertEquals(true, result);
        
    }
 */
    /**
     * Test of addAdmit method, of class AdmitUtils.
    
    @Test
    public void testAddAdmit() {
        System.out.println("addAdmit");
        Admit admit = new Admit(5,6,"corona",9,"2021-10-27","07:24","Jaffna");
        
        //Add the admit
        
        boolean result = AdmitUtils.addAdmit(admit);
        assertEquals(true, result);
        
        
        //Check the Admitted patient
        Admit resultAdmit = AdmitUtils.getAdmit(admit.getAdmit_id());
        assertEquals(admit.getPatient_id(), resultAdmit.getPatient_id());
        assertEquals(admit.getAdmit_reason(), resultAdmit.getAdmit_reason());
        assertEquals(admit.getWard_id(), resultAdmit.getWard_id());
        assertEquals(admit.getAdmit_date(), resultAdmit.getAdmit_date());
        assertEquals(admit.getAdmit_time(), resultAdmit.getAdmit_time());
        assertEquals(admit.getAdmit_branch(), resultAdmit.getAdmit_branch());
        
      
    }
 */
    /**
     * Test of getAdmit method, of class AdmitUtils.
    
    @Test
    public void testGetAdmit_int() {
        System.out.println("getAdmit");
        int id = 5;
        Admit expResult = new Admit(5,6,"corona",9,"2021-10-27","07:24","Jaffna");;
        Admit result = AdmitUtils.getAdmit(id);
        assertEquals(expResult.getAdmit_id(), result.getAdmit_id());
        assertEquals(expResult.getPatient_id(), result.getPatient_id());
        assertEquals(expResult.getAdmit_reason(), result.getAdmit_reason());
        assertEquals(expResult.getWard_id(), result.getWard_id());
        assertEquals(expResult.getAdmit_date(), result.getAdmit_date());
        assertEquals(expResult.getAdmit_time(), result.getAdmit_time());
        assertEquals(expResult.getAdmit_branch(), result.getAdmit_branch());
        
        
      
    }
 */
    /**
     * Test of getAdmit method, of class AdmitUtils.
     
    */
}
