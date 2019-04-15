/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

public abstract class Player {

    protected String playerID; //the unique ID for this player
    protected int wins = 0, losses = 0;
    protected Money money;

    public int getMoney() {
        return money.getAmount();
    }

    public void setMoney(int amount) {
        money.setAmount(amount);
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    public int getWins() {
        return wins;
    }
//
//    public void win(int wins) {
//        this.wins = wins + 1;
//    }

    public int getLosses() {
        return losses;
    }
//
//    public void lose(int losses) {
//        this.losses = losses + 1;
//    }

    public void addMoney() {
        money.add();
    }

    public void removeMoney() {
        money.remove();
    }

    public abstract void play();

    public abstract void win();

    public abstract void lose();
}
