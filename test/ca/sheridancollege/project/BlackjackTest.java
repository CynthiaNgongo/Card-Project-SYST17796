/*
 * Leonardo Stifano
 * Student ID: 991 532 946
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lstif
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
   

    /**
     * Test of play method, of class Blackjack.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Blackjack instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
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
