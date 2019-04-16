/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

/**
 * Description: This class is used to create a playing card for a poker deck.
 *              Used by GroupOfCards class.
 */
public class PlayingCard extends Card {

    private char suit;
    private String value;

    /**
     * Default constructor
     *
     * @param suit 0 for Spade, 1 for Heart, 2 for Club, 3 for Diamond
     * @param value the card's value from 1-13(K)
     */
    public PlayingCard(int suit, int value) {
        setSuit(suit);
        setValue(value);
    }
    //return suit unicode character
    public char getSuit() {
        return suit;
    }
    //use to set the value of the suit 
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
    
    //return the value in a string
    public String getValue() {

        return value;
    }
    //change or set the value
    public void setValue(Integer value) {
        switch (value) {
            case 1:
                this.value = "A";
                break;
            case 11:
                this.value = "J";
                break;
            case 12:
                this.value = "Q";
                break;
            case 13:
                this.value = "K";
                break;
            default:
                this.value = value.toString();
                break;
        }
    }
    //return a string with the suit and value
    @Override
    public String toString() {
        return getSuit() + getValue() + " ";
    }

}
