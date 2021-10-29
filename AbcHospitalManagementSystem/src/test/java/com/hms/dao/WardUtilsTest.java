/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Ward;
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
public class WardUtilsTest {
    
    public WardUtilsTest() {
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
     * Test of updateWard method, of class WardUtils.
     
    @Test
    public void testUpdateWard() {
        System.out.println("updateWard");
        Ward ward = new Ward(19,"71","Accident","Avaliable");
        
        boolean result = WardUtils.updateWard(ward);
        assertEquals(true, result);
        //Check the update ward
        Ward resultWard = WardUtils.getWard(ward.getWard_id());
        assertEquals(ward.getWard_no(), resultWard.getWard_no());
        assertEquals(ward.getWard_type(), resultWard.getWard_type());
        assertEquals(ward.getWard_status(), resultWard.getWard_status());
        
       
    }*/

    /**
     * Test of deleteWard method, of class WardUtils.
    
    @Test
    public void testDeleteWard() {
        System.out.println("deleteWard");
        int id = 19;
        boolean expResult = WardUtils.deleteWard(id);
        boolean result = WardUtils.deleteWard(id);
        assertEquals(true, result);
        
    } */

    /**
     * Test of addWard method, of class WardUtils.
     
    @Test
    public void testAddWard() {
        System.out.println("addWard");
        Ward ward = new Ward(21,"72","Accident","Avaliable");
        
        boolean result = WardUtils.addWard(ward);
        assertEquals(true, result);
       
        //Check the added ward
        Ward resultWard = WardUtils.getWard(ward.getWard_id());
        assertEquals(ward.getWard_id(), resultWard.getWard_id());
        assertEquals(ward.getWard_no(), resultWard.getWard_no());
        assertEquals(ward.getWard_type(), resultWard.getWard_type());
        assertEquals(ward.getWard_status(), resultWard.getWard_status());
    }*/

    /**
     * Test of getWard method, of class WardUtils.
     
    @Test
    public void testGetWard_int() {
        System.out.println("getWard");
        int id = 21;
        Ward expResult = new Ward(21,"72","Accident","Avaliable");
        Ward result = WardUtils.getWard(id);
        assertEquals(expResult.getWard_id(), result.getWard_id());
        assertEquals(expResult.getWard_no(), result.getWard_no());
        assertEquals(expResult.getWard_type(), result.getWard_type());
        assertEquals(expResult.getWard_status(), result.getWard_status());

    }
    */
}
