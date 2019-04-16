/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand {
    
    //create an arrayList of PLayingCards
    private ArrayList<PlayingCard> hand = new ArrayList<>();
    private int value; //value field
    
    //use this for the player hand (could be used for cpu hand at the end of the round)
    //return the values contained in hand (number + suit )
    public String getHand() {
        String print = "";
        for (PlayingCard c : hand) {
            print += c.toString();
        }
        return print;
    }
    //use this when displaying the cpu hand
    //return values in the hand, hiding the first value with ??
    public String getHiddenHand() {
        String print = "?? ";
        for (int i = 1; i < hand.size(); i++) {
            print += hand.get(i).toString();
        }

        return print;
    }
    
    //return the sum of card values
    public int getValue() {
        //set field to 0
        value = 0;
        
        //go through all cards in the hand
        for (PlayingCard pc : hand) {
            //J, Q, and K all have a value of 10
            if (pc.getValue().equals("J") || pc.getValue().equals("Q") || pc.getValue().equals("K")) {
                value += 10;
                //A has a value of 1
            } else if (pc.getValue().equals("A")) {
                value += 1;
            } else {
                value += Integer.parseInt(pc.getValue());
            }
        }
        //retrun sum of values
        return value;
    }
    //sets hand to a new hand
    public void setHand(ArrayList<PlayingCard> hand) {
        this.hand = hand;
    }
    //use in dealer class methods
    //adds a card to the hand
    public void addCard(PlayingCard c) {
        hand.add(c);
    }

}
