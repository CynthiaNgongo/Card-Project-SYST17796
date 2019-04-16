/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

public class GamePlayer extends Player {
    //Money field
    private Money money;
    
    //GamePLayer must be made with these parameters
    public GamePlayer(String playerID, Money money) {
        this.playerID = playerID;
        this.money = money;
        this.wins = 0;
    }

    public void play() {
    }
    
    //call this function when the GamePlayer wins
    //uses the add function from the Money class and increments player wins
    public void win() {
        money.add();
        wins++;
    }
    //call this function when the GamePlayer loses
    //uses the remove function from the money class
    public void lose() {
        money.remove();
    }
    
    //give the value of the Money
    public int getMoney() {
        return money.getAmount();
    }
    
}
