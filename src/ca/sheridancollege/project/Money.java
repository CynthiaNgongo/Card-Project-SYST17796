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
public class Money {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }
      

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void remove(){
        this.amount = amount - 100;
    }
    
    public void add(){
        this.amount = amount + 100;
    }
}
