/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Discharge;
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
public class DischargeUtilsTest {
    
    public DischargeUtilsTest() {
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
     * Test of updateDischarge method, of class DischargeUtils.
     
    @Test
    public void testUpdateDischarge() {
        System.out.println("updateDischarge");
        Discharge discharge = new Discharge(4,4,"qwerty",1,"2021-10-11","02:56","Colombo");
        
        boolean result = DischargeUtils.updateDischarge(discharge);
        assertEquals(true, result);
       
        //Check the added Discharge
        Discharge resultDischarge = DischargeUtils.getDischarge(discharge.getDischarge_id());
        assertEquals(discharge.getAdmit_id(), resultDischarge.getAdmit_id());
        assertEquals(discharge.getDischarge_reason(), resultDischarge.getDischarge_reason());
        assertEquals(discharge.getWard_id(), resultDischarge.getWard_id());
        assertEquals(discharge.getDischarge_date(), resultDischarge.getDischarge_date());
        assertEquals(discharge.getDischarge_time(), resultDischarge.getDischarge_time());
        assertEquals(discharge.getDischarge_branch(), resultDischarge.getDischarge_branch());
    }
*/
    /**
     * Test of deleteDischarge method, of class DischargeUtils.
     
    @Test
    public void testDeleteDischarge() {
        System.out.println("deleteDischarge");
        int id = 5;
        boolean expResult = DischargeUtils.deleteDischarge(id);
        boolean result = DischargeUtils.deleteDischarge(id);
        assertEquals(true, result);
        
    }
*/
    /**
     * Test of addDischarge method, of class DischargeUtils.
    
    @Test
    public void testAddDischarge() {
        System.out.println("addDischarge");
        Discharge discharge = new Discharge(4,4,"qwerty",1,"2021-10-11","02:56","Colombo");
        //Add the Discharge
        boolean result = DischargeUtils.addDischarge(discharge);
        assertEquals(true, result);
        
        Discharge resultDischarge = DischargeUtils.getDischarge(discharge.getDischarge_id());
        assertEquals(discharge.getAdmit_id(), resultDischarge.getAdmit_id());
        assertEquals(discharge.getDischarge_reason(), resultDischarge.getDischarge_reason());
        assertEquals(discharge.getWard_id(), resultDischarge.getWard_id());
        assertEquals(discharge.getDischarge_date(), resultDischarge.getDischarge_date());
        assertEquals(discharge.getDischarge_time(), resultDischarge.getDischarge_time());
        assertEquals(discharge.getDischarge_branch(), resultDischarge.getDischarge_branch());
        

    }
 */
    /**
     * Test of getDischarge method, of class DischargeUtils.
     
    @Test
    public void testGetDischarge_int() {
        System.out.println("getDischarge");
        int id = 4;
        Discharge expResult = new Discharge(4,4,"qwerty",1,"2021-10-11","02:56","Colombo");
        Discharge result = DischargeUtils.getDischarge(id);
       
        assertEquals(expResult.getDischarge_id(), result.getDischarge_id());
        assertEquals(expResult.getAdmit_id(), result.getAdmit_id());
        assertEquals(expResult.getDischarge_reason(), result.getDischarge_reason());
        assertEquals(expResult.getWard_id(), result.getWard_id());
        assertEquals(expResult.getDischarge_date(), result.getDischarge_date());
        assertEquals(expResult.getDischarge_time(), result.getDischarge_time());
        assertEquals(expResult.getDischarge_branch(), result.getDischarge_branch());
        
        
        
    }
*/
    
}
