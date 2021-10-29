/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.common.Response;
import com.hms.dao.WardUtils;
import com.hms.objects.Ward;
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
public class WardServiceImpTest {
    
    public WardServiceImpTest() {
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
     * Test of getWard method, of class WardServiceImp.
     
    @Test
    public void testGetWard_int() {
        System.out.println("getWard");
        int id = 1;
        WardServiceImp instance = new WardServiceImp();
        String expResult = "{\"ward_id\":1,\"ward_no\":\"01\",\"ward_type\":\"Emergency\",\"ward_status\":\"Avaliable\"}";
        String result = instance.getWard(id);
        assertEquals(expResult, result);
       
    }
*/
    /**
     * Test of getWard method, of class WardServiceImp.
     */
 

    /**
     * Test of addWard method, of class WardServiceImp.
    
    @Test
    public void testAddWard() {
        System.out.println("addWard");
        String json = "{\"ward_no\":\"71\",\"ward_type\":\"Accident\",\"ward_status\":\"Avaliable\"}";
        
        WardServiceImp instance = new WardServiceImp();
        Response expResult = new Response();
        Response result = instance.addWard(json);
        assertEquals(expResult, result);
      */ 
           
      /**  
      
      
        
        
      
        
    } 
    }*/
 
    /**
     * Test of updateWard method, of class WardServiceImp.
     
    @Test
    public void testUpdateWard() {
        System.out.println("updateWard");
        String json = "{\"ward_id\":15,\"ward_no\":\"0222\",\"ward_type\":\"Accident\",\"ward_status\":\"Avaliable\"}";
        WardServiceImp instance = new WardServiceImp();
        Response result = instance.updateWard(json);
        assertEquals(true, result);
        
    }
*/
    /**
     * Test of deleteWard method, of class WardServiceImp.
    
    @Test
    public void testDeleteWard() {
        System.out.println("deleteWard");
        int id = 8;
        WardServiceImp instance = new WardServiceImp();
        boolean expResult = instance.deleteWard(id);;
        Response result = instance.deleteWard(id);
        assertEquals(true, result);
        
    }
 */
    
   
} 
