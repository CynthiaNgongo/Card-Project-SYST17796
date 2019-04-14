/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.*;

/**
*  Author: Kendrick, Tsz-Kin Yeung
*  Program:
*  Date:
*
*  Description:
*/
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GroupOfCards gpCard = new GroupOfCards();
        //gpCard.shuffle();
        ArrayList<Card> cards = gpCard.showCards();
        for (Card card : cards) {
            System.out.print(card.toString());
        }
    }

}
