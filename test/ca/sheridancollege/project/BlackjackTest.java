/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

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
public class BlackjackTest {
    
    public BlackjackTest() {
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
     * Test of play method, of class Blackjack.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Blackjack instance = null;
        instance.play();
    }

    /**
     * Test of declareWinner method, of class Blackjack.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        Blackjack instance = null;
        instance.declareWinner();
    }

    /**
     * Test of checkValue method, of class Blackjack.
     */
    @Test
    public void testCheckValue() {
        System.out.println("checkValue");
        Blackjack instance = null;
        instance.checkValue();
    }
    
}
