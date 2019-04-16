/*
 * Cynthia Ngongo
 * 2019-04-15
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Cynthia Ngongo
 * 2019-04-15
 */
public class DealerTest {
    
    public DealerTest() {
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
     * Test of deal method, of class Dealer.
     * for this to be a good test, theNewRound is set to true, since in reality
     * the new deal would be a new round
     */
    @Test
    public void testDealGood() {
        System.out.println("dealGood");
        Hand hand = new Hand();
        Dealer instance = new Dealer();
        instance.getNewRound(true);
        instance.deal(hand);
    }
    
    /**
     * Test of deal method (bad), of class Dealer.
     * for this to be a bad test, the newRound is set to false, however the 
     * program understands that this is not a new round and will continue
     */
    @Test
    public void testDealBad() {
        System.out.println("dealBad");
        Hand hand = new Hand();
        Dealer instance = new Dealer();
        instance.getNewRound(false);
        instance.deal(hand);
    }
}
