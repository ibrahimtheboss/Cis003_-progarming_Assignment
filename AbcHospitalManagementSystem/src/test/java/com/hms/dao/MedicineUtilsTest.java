/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Medicine;
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
public class MedicineUtilsTest {
    
    public MedicineUtilsTest() {
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
     * Test of updateMedicine method, of class MedicineUtils.
    
    @Test
    public void testUpdateMedicine() {
        System.out.println("updateMedicine");
        Medicine medicine = new Medicine(6,"Bandage Roll","BFF12",80.0,"1000");
       double price = medicine.getMedicine_price();
        boolean result = MedicineUtils.updateMedicine(medicine);
        assertEquals(true, result);
        
        //Check the added Medicine
        Medicine resultMedicine = MedicineUtils.getMedicine(medicine.getMedicine_id());
        assertEquals(medicine.getMedicine_name(), resultMedicine.getMedicine_name());
        assertEquals(medicine.getMedicine_price(), resultMedicine.getMedicine_price(),price);
        assertEquals(medicine.getMedicine_qty(), resultMedicine.getMedicine_qty());
       
    } */

    /**
     * Test of deleteMedicine method, of class MedicineUtils.
     
    @Test
    public void testDeleteMedicine() {
        System.out.println("deleteMedicine");
         //Delete the Medicine
        int id = 6;
        boolean expResult = MedicineUtils.deleteMedicine(id);
        boolean result = MedicineUtils.deleteMedicine(id);
        assertEquals(true, result);
        
      
       
    }*/

    /**
     * Test of addMedicine method, of class MedicineUtils.
     
    @Test
    public void testAddMedicine() {
        System.out.println("addMedicine");
        Medicine medicine = new Medicine(6,"Bandage Roll","BFF12",80.0,"1000");
        //Add the medicine
        boolean result = MedicineUtils.addMedicine(medicine);
        assertEquals(true, result);
       double price = medicine.getMedicine_price();
        //Check the added medicine
        Medicine resultMedicine = MedicineUtils.getMedicine(medicine.getMedicine_id());
        
        assertEquals(medicine.getMedicine_name(), resultMedicine.getMedicine_name());
        assertEquals(medicine.getMedicine_price(), resultMedicine.getMedicine_price(),price);
        assertEquals(medicine.getMedicine_qty(), resultMedicine.getMedicine_qty());
       
    }
*/ 
    /**
     * Test of getMedicine method, of class MedicineUtils.
     */
    @Test
    public void testGetMedicine_int() {
        System.out.println("getMedicine");
        int id = 6;
        Medicine expResult = new Medicine(6,"Bandage Roll","BFF12",80.0,"1000");
        Medicine result = MedicineUtils.getMedicine(id);
        double price = expResult.getMedicine_price();
        assertEquals(expResult.getMedicine_id(), result.getMedicine_id());
        assertEquals(expResult.getMedicine_name(), result.getMedicine_name());
        assertEquals(expResult.getMedicine_price(), result.getMedicine_price(),price);
        assertEquals(expResult.getMedicine_qty(), result.getMedicine_qty());



        
    }

  
    
}
