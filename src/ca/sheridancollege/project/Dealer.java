/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * Class name: Dealer Author: Kendrick, Tsz-Kin Yeung Date: 11 Apr 2019
 *
 * Description:
 */
public class Dealer {

    private GroupOfCards deck = new GroupOfCards();

    public Card[] deal() {
        Card[] card = null;
        for (int i = 0; i < 2; i++) {
            if (deck.showCards().size() > 0) {
                card[i] = deck.showCards().get(0);
                deck.showCards().remove(card[i]);
            }
        }
        return card;
    }
}
