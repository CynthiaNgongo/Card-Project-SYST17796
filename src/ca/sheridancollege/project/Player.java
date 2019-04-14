
/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

public abstract class Player {

    protected String playerID; //the unique ID for this player
    protected int wins, losses;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
    

    public abstract void play();

    public abstract void win();

    public abstract void lose();
}