/*
 * Leonardo Stifano
 * Student ID: 991 532 946
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author lstif
 */
public class Hand {

    private ArrayList<PlayingCard> hand = new ArrayList<>();
    private int value;

    public String getHand() {
        String print = "";
        for (PlayingCard c : hand) {
            print += c.toString();
        }
        return print;
    }

    public int getValue() {
        value = 0;
        for (PlayingCard pc : hand) {
            value += Integer.parseInt(pc.getValue());
        }
        return value;
    }

    public void setHand(ArrayList<PlayingCard> hand) {
        this.hand = hand;
    }

    public void addCard(PlayingCard c) {
        hand.add(c);
    }

}
