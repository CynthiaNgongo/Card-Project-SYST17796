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

    private static GroupOfCards deck = new GroupOfCards();
    private CardHand cards = new CardHand();
    private static Dealer instance = null;

    private Dealer() {
    }
    
    public void selfDeal() {
        cards.clear();
        cards.addAll(deal());
    }

    public static ArrayList<PlayingCard> deal() {
        ArrayList<PlayingCard> card = new ArrayList<>();
        if (deck.showCards().size() < 15) {
            deck = new GroupOfCards();
        }
        for (int i = 0; i < 2; i++) {
            card.add(deck.showCards().get(0));
            deck.showCards().remove(0);
        }
        return card;
    }

    public static PlayingCard hit() {
        PlayingCard card = null;
        card = deck.showCards().get(0);
        deck.showCards().remove(card);
        return card;
    }
    
    public String showFirstCard() {
        return "Dealer have: " + cards.get(0).toString();
    }
    
    public String showAllCards() {
        lessThen17();
        String allCards = "Dealer have:\n";
        for (PlayingCard card : cards) {
            allCards += card.toString() + "\n";
        }
        return allCards;
    }
    
    public int dealerTotal(){
        return cards.getTotalValues();
    }
    
    public static Dealer getInstance() {
        if (instance == null) {
            instance = new Dealer();
        }
        return instance;
    }
    
    private void lessThen17() {
        while (cards.getTotalValues() < 17) {
            cards.add(hit());
        }
    }
}
