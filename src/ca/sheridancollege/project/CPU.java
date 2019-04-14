/*
 * Leonardo Stifano
 * Student ID: 991 532 946
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

/**
 *
 * @author lstif
 */
public class CPU extends Player{

    public CPU(String playerID){
        this.playerID = playerID;
    }
    @Override
    public void play() {
    }

    @Override
    public void win() {
        wins++;
    }

    @Override
    public void lose() {
        losses++;
    }
    
    public void cpuLogic(Hand hand){
        
    }
    
}