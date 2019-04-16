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
        System.out.println("getValueGood");
        Hand instance = new Hand();
        instance.addCard(new PlayingCard(1, 4));
        int expResult = 4;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Hand.
     * Bad because you do not want to use this function when the Hand is empty
     */
    @Test
    public void testGetValueBad() {
        System.out.println("getValueBad");
        Hand instance = new Hand();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Hand.
     */
    @Test
    public void testGetValueBoundary() {
        System.out.println("getValueBoundary");
        Hand instance = new Hand();
        instance.addCard(new PlayingCard(1, 13));
        int expResult = 10;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

}
