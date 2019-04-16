/**
 * SYST 17796 Project Winter 2019 Base code.
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

public abstract class Player {

    protected String playerID; //the unique ID for this player
    protected int wins = 0; //num of wins for the Player
    protected Money money; //money for GamePlayer, could be added for other types of players
    
    //return money amount
    public int getMoney() {
        return money.getAmount();
    }
    
    //set the value of the Money field
    public void setMoney(int amount) {
        money.setAmount(amount);
    }
    
    //get the name of the player
    public String getPlayerID() {
        return playerID;
    }
    //change the name of the player
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }
    
    //find player wins
    public int getWins() {
        return wins;
    }
    
    //add 100 to money variable
    public void addMoney() {
        money.add();
    }

    //subtract 1pp from money variable
    public void removeMoney() {
        money.remove();
    }
    //force implementation of play method
    public abstract void play();
    
    //force implementation of win method
    public abstract void win();
    
    //force implementation of lose method
    public abstract void lose();

}
