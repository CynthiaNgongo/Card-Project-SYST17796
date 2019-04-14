/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Class name: Dealer Author: Kendrick, Tsz-Kin Yeung Date: 11 Apr 2019
 *
 * Description:
 */
public class Dealer {
    
    private GroupOfCards deck = new GroupOfCards();
    private boolean newRound;
    
    public void deal(Hand hand) {
        //prevent duplicates
        if (deck.getSize() > 15) {
            deck = new GroupOfCards();
        }
        for (int i = 0; i < 2; i++) {
            if (deck.showCards().size() > 0) {
                hand.addCard(deck.showCards().get(0));
                deck.showCards().remove(0);
            }
            
        }
        
        deck.setSize(deck.getSize() - 2);
    }
    
    public boolean isNewRound() {
        return newRound;
    }
    
    public void setNewRound(boolean newRound) {
        this.newRound = newRound;
    }
    
    public void hit(Hand hand) {
        hand.addCard(deck.showCards().get(0));
        deck.showCards().remove(0);
        
        deck.setSize(deck.getSize() - 1);
        
    }
}
