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
    
    public Money getMoney(){
        return money;
    }

    @Override
    public void play() {
    }

    @Override
    public void win() {
        money.add();
        wins++;
    }

    @Override
    public void lose() {
        money.remove();
        losses++;
    }
}