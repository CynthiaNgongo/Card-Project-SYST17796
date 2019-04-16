/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;


public class CPU extends Player {

    public CPU(String playerID) {
        this.playerID = playerID;
    }
        
    @Override
    public void play() {
    }
    
    //count cpu wins
    @Override
    public void win() {
        wins++;
    }

    @Override
    public void lose() {
    }

}
