/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.common.Response;
import com.hms.objects.Admit;
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
public class AdmitServiceImpTest {
    
    public AdmitServiceImpTest() {
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
     * Test of getAdmit method, of class AdmitServiceImp.
     */
    @Test
    public void testGetAdmit_int() {
        System.out.println("getAdmit");
        int id = 1;
       AdmitServiceImp instance = new AdmitServiceImp();
        String expResult = "{\"admit_id\":1,\"patient_id\":1,\"admit_reason\":\"Accident\",\"ward_id\":1,\"admit_date\":\"2021-10-13\",\"admit_time\":\"08:20\",\"admit_branch\":\"Galle\"}";
        String result = instance.getAdmit(id);
        assertEquals(expResult, result);
       
        
    }

    
    /**
     * Test of addAdmit method, of class AdmitServiceImp.
     
    @Test
    public void testAddAdmit() {
        System.out.println("addAdmit");
        String json = "{\"patient_id\":1,\"admit_reason\":\"Accident\",\"ward_id\":1,\"admit_date\":\"2021-10-13\",\"admit_time\":\"08:20\",\"admit_branch\":\"Galle\"}";
        AdmitServiceImp instance = new AdmitServiceImp();
        Response expResult = instance.addAdmit(json);
        Response result = instance.addAdmit(json);
        assertEquals(true, result);
        
    }
*/
    /**
     * Test of updateAdmit method, of class AdmitServiceImp.
     
    @Test
    public void testUpdateAdmit() {
        System.out.println("updateAdmit");
        String json = "{\"admit_id\":1,\"patient_id\":1,\"admit_reason\":\"Accident\",\"ward_id\":1,\"admit_date\":\"2021-10-13\",\"admit_time\":\"08:20\",\"admit_branch\":\"Galle\"}";
        AdmitServiceImp instance = new AdmitServiceImp();
        Response expResult = null;
        Response result = instance.updateAdmit(json);
        assertEquals(expResult, result);
        
    }
*/
    /**
     * Test of deleteAdmit method, of class AdmitServiceImp.
     
    @Test
    public void testDeleteAdmit() {
        System.out.println("deleteAdmit");
        int id = 5;
        AdmitServiceImp instance = new AdmitServiceImp();
        Response expResult = instance.deleteAdmit(id);
        Response result = instance.deleteAdmit(id);
        assertEquals(true, result);
       
    }
*/
   
}
