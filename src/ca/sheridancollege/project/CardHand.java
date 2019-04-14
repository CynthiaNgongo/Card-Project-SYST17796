/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
*  Author: Kendrick, Tsz-Kin Yeung
*  Program:
*  Date:
*
*  Description:
*/
public class CardHand extends ArrayList<PlayingCard>{

    public CardHand() {
    }
    
    public int getTotalValues() {
        int total = 0;
        for (PlayingCard card : this) {
            total += card.getIntValue();
        }
        return total;
    }
}
