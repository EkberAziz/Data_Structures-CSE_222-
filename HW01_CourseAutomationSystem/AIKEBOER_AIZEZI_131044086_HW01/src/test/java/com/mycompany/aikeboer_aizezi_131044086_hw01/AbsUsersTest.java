/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aikeboer_aizezi_131044086_hw01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akbar Aziz
 */
public class AbsUsersTest {
    
    public AbsUsersTest() {
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
     * Test of setID method, of class AbsUsers.
     */
    @org.junit.Test
    public void testSetID() {
        System.out.println("setID");
        int id = 0;
        AbsUsers instance = new AbsUsersImpl();
        instance.setID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class AbsUsers.
     */
    @org.junit.Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        AbsUsers instance = new AbsUsersImpl();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class AbsUsers.
     */
    @org.junit.Test
    public void testSetPassword() {
        System.out.println("setPassword");
        int password = 0;
        AbsUsers instance = new AbsUsersImpl();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class AbsUsers.
     */
    @org.junit.Test
    public void testGetID() {
        System.out.println("getID");
        AbsUsers instance = new AbsUsersImpl();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class AbsUsers.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        AbsUsers instance = new AbsUsersImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeName method, of class AbsUsers.
     */
    @org.junit.Test
    public void testChangeName() {
        System.out.println("changeName");
        String name = "";
        AbsUsers instance = new AbsUsersImpl();
        instance.changeName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class AbsUsers.
     */
    @org.junit.Test
    public void testChangePassword() {
        System.out.println("changePassword");
        int password = 0;
        AbsUsers instance = new AbsUsersImpl();
        instance.changePassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class AbsUsers.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        AbsUsers aUser = null;
        AbsUsers instance = new AbsUsersImpl();
        boolean expResult = false;
        boolean result = instance.equals(aUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbsUsersImpl extends AbsUsers {

        public boolean equals(AbsUsers aUser) {
            return false;
        }
    }
    
}
