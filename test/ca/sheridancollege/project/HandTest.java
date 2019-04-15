/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cynthia Ngongo
 */
public class HandTest {
    
    public HandTest() {
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
     * Test of getValue method, of class Hand.
     */
    @Test
    public void testGetValueGood() {
        System.out.println("getValue");
        Hand instance = new Hand();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValue method, of class Hand.
     */
    @Test
    public void testGetValueBad() {
        System.out.println("getValue");
        Hand instance = new Hand();
        int expResult = 15;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getValue method, of class Hand.
     */
    @Test
    public void testGetValueBoundary() {
        System.out.println("getValue");
        Hand instance = new Hand();
        int expResult = 13;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    
}
