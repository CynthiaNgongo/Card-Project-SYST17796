/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

/**
 *
 * @author lstif
 */
public class PlayBlackjack {
    
    public static void main(String[] args) {
        //declaring Blackjack object
        Blackjack blackjack = new Blackjack("Blackjack");
        //print title
        System.out.println("---------Blackjack---------");
        //call blackjack play method to play the game
        blackjack.play();
    }
}
