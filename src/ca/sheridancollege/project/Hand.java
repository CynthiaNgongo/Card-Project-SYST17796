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

    public String getHiddenHand() {
        String print = "?? ";
        for (int i = 1; i < hand.size(); i++) {
            print += hand.get(i).toString();
        }

        return print;
    }

    public int getValue() {
        value = 0;
        for (PlayingCard pc : hand) {
            if (pc.getValue().equals("A") || pc.getValue().equals("J")
                    || pc.getValue().equals("Q") || pc.getValue().equals("K")) {
                value += 10;
            } else {
                value += Integer.parseInt(pc.getValue());
            }
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
