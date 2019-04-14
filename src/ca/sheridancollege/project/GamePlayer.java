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
public class GamePlayer extends Player {

    private Money money;

    public GamePlayer(String playerID, Money money) {
        this.playerID = playerID;
        this.money = money;
        this.losses = 0;
        this.wins = 0;
    }

    public void play() {
    }

    public void win() {
        money.add();
        wins++;
    }

    public void lose() {
        money.remove();
        losses++;
    }

    public int getMoney() {
        return money.getAmount();
    }
    
    public void addMoney(){
        money.add();
    }
    
    public void removeMoney(){
        money.remove();
    }
    
    
    
    
}