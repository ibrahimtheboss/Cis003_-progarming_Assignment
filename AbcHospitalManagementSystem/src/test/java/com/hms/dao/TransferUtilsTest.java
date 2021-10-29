/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.Transfer;
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
public class TransferUtilsTest {
    
    public TransferUtilsTest() {
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
     * Test of updateTransfer method, of class TransferUtils.
     
    @Test
    public void testUpdateTransfer() {
        System.out.println("updateTransfer");
        Transfer transfer = new Transfer(3,2,"just","Galle","Colombo","2021-10-29") ;
        
        boolean result = TransferUtils.updateTransfer(transfer);
        assertEquals(true, result);
        
        
       
       
        //Check the added transfer
        Transfer resultTransfer = TransferUtils.getTransfer(transfer.getTransfer_id());
        assertEquals(transfer.getAdmit_id(), resultTransfer.getAdmit_id());
        assertEquals(transfer.getTransfer_reason(), resultTransfer.getTransfer_reason());
        assertEquals(transfer.getTransfer_from(), resultTransfer.getTransfer_from());
        assertEquals(transfer.getTransfer_to(), resultTransfer.getTransfer_to());
        assertEquals(transfer.getTransfer_date(), resultTransfer.getTransfer_date());
        
    }
*/
    /**
     * Test of deleteTransfer method, of class TransferUtils.
     
    @Test
    public void testDeleteTransfer() {
        System.out.println("deleteTransfer");
        int id = 3;
        boolean expResult = TransferUtils.deleteTransfer(id);
        boolean result = TransferUtils.deleteTransfer(id);
        assertEquals(expResult, result);
        
    }
*/
    /**
     * Test of addTransfer method, of class TransferUtils.
     
    @Test
    public void testAddTransfer() {
        System.out.println("addTransfer");
        Transfer transfer = new Transfer(3,2,"just","Galle","Colombo","2021-10-29") ;
        
        boolean result = TransferUtils.addTransfer(transfer);
        assertEquals(true, result);
        //Check the added transfer
        Transfer resultTransfer = TransferUtils.getTransfer(transfer.getTransfer_id());
        assertEquals(transfer.getAdmit_id(), resultTransfer.getAdmit_id());
        assertEquals(transfer.getTransfer_reason(), resultTransfer.getTransfer_reason());
        assertEquals(transfer.getTransfer_from(), resultTransfer.getTransfer_from());
        assertEquals(transfer.getTransfer_to(), resultTransfer.getTransfer_to());
        assertEquals(transfer.getTransfer_date(), resultTransfer.getTransfer_date());
        
       
       
    }*/

    /**
     * Test of getTransfer method, of class TransferUtils.
     */
    @Test
    public void testGetTransfer_int() {
        System.out.println("getTransfer");
        int id = 3;
        Transfer expResult = new Transfer(3,2,"just","Galle","Colombo","2021-10-29") ;
        Transfer result = TransferUtils.getTransfer(id);
        assertEquals(expResult.getTransfer_id(), result.getTransfer_id());
        assertEquals(expResult.getAdmit_id(), result.getAdmit_id());
        assertEquals(expResult.getTransfer_reason(), result.getTransfer_reason());
        assertEquals(expResult.getTransfer_from(), result.getTransfer_from());
        assertEquals(expResult.getTransfer_to(), result.getTransfer_to());
        assertEquals(expResult.getTransfer_date(), result.getTransfer_date());
        
        
    
    }

    
    
}
