/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dao;

import com.hms.objects.User;
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
public class UserUtilsTest {
    
    public UserUtilsTest() {
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
     * Test of updateUser method, of class UserUtils.
    
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User user = new User(2,"Bill","abc123","Admin");
        
        boolean result = UserUtils.updateUser(user);
        assertEquals(true, result);
        
       
       
        //Check the added user
        User resultUser = UserUtils.getUser(user.getUser_id());
        assertEquals(user.getUsername(), resultUser.getUsername());
        assertEquals(user.getPassword(), resultUser.getPassword());
        assertEquals(user.getRole(), resultUser.getRole());
        
        
    } */

    /**
     * Test of deleteUser method, of class UserUtils.
     
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int id = 3;
        boolean expResult = UserUtils.deleteUser(id);
        boolean result = UserUtils.deleteUser(id);
        assertEquals(expResult, result);
        
    }
*/
    /**
     * Test of addUser method, of class UserUtils.
     
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User(4,"John","123","Admin");
        
        boolean result = UserUtils.addUser(user);
        assertEquals(true, result);
        //Check the added user
        User resultUser = UserUtils.getUser(user.getUser_id());
        assertEquals(user.getUsername(), resultUser.getUsername());
        assertEquals(user.getPassword(), resultUser.getPassword());
        assertEquals(user.getRole(), resultUser.getRole());
    }
*/
    /**
     * Test of getUser method, of class UserUtils.
     
    @Test
    public void testGetUser_int() {
        System.out.println("getUser");
        int id = 2;
        User expResult = new User(2,"Bill","abc123","Admin");
        User result = UserUtils.getUser(id);
        assertEquals(expResult.getUser_id(), result.getUser_id());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getRole(), result.getRole());
        
    }
*/
  
    
}
