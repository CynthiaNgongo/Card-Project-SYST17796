/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/*Description : This class handles the dealing aspect of the game. It moves 
                Card objects from the GroupOfCards class to the Hand chosen 
                with the parameter. 
*/ 
public class Dealer {
    
    //declaring fields
    private GroupOfCards deck = new GroupOfCards();
    //field to allow for validation in the deal method
    private boolean newRound;
    
    //initial deal to player and cpu
    //deals to chosen hand
    public void deal(Hand hand) {
        //reset deck when cut off point is reached when there is a new round.
        if (deck.getSize() < 15 && newRound == true) {
            deck = new GroupOfCards();
        }
        //add 2 cards from the deck to the hand, and remove them from the deck
        for (int i = 0; i < 2; i++) {
            if (deck.showCards().size() > 0) {
                hand.addCard(deck.showCards().get(0));
                deck.showCards().remove(0);
            }
            
        }
        //reduce deck size by  2
        deck.setSize(deck.getSize() - 2);
    }
    
    public boolean isNewRound() {
        return newRound;
    }
    
    public void setNewRound(boolean newRound) {
        this.newRound = newRound;
    }
    
    public boolean getNewRound(boolean newRound){
        return this.newRound;
    }
    
    public void hit(Hand hand) {
        hand.addCard(deck.showCards().get(0));
        deck.showCards().remove(0);
        
        deck.setSize(deck.getSize() - 1);
        
    }
}
