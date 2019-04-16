/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<PlayingCard> cards;
    private int size;//the size of the grouping
    
    //create deck when object is made and shuffle
    public GroupOfCards() {
        cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards.add(new PlayingCard(i, j));
            }
        }
        shuffle();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<PlayingCard> showCards() {
        return cards;
    }
    
    //shuffle the cards when called
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

}//end class
