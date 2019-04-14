/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
*  Class name: Playing Card
*  Author: Kendrick, Tsz-Kin Yeung
*  Date:
*
*  Description:
*/
public class PlayingCard extends Card{
    private char suit;
    private String value;

    /**
     * Default constructor
     * @param suit 0 for Spade, 1 for Heart, 2 for Club, 3 for Diamond
     * @param value the card's value from 1-13(K)
     */
    public PlayingCard(int suit, int value) {
        setSuit(suit);
        setValue(value);
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        switch (suit) {
            case 0:
                this.suit = '\u2660';
                break;
            case 1:
                this.suit = '\u2665';
                break;
            case 2:
                this.suit = '\u2663';
                break;
            case 3:
                this.suit = '\u2666';
                break;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(Integer value) {
        switch (value) {
            case 1:
                this.value = "A";
                break;
            default:
                this.value = value.toString();
                break;
        }
    }
    
    @Override
    public String toString() {
        return getSuit() + " " + getValue() + "\n";
    }

}
