/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
*  Author: Kendrick, Tsz-Kin Yeung
*  Program:
*  Date:
*
*  Description:
*/
public class BlackJackGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        Player human = new GamePlayer("human", new Money(200));
        Player CPU = new CPU("CPU");
        
        blackJack.getPlayers().add(human);
        blackJack.getPlayers().add(CPU);
        
        blackJack.play();
    }

}
