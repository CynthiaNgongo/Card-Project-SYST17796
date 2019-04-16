/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

public class Money {
    
    //amount field
    private int amount;
    
    //constructor setting amount
    public Money(int amount) {
        this.amount = amount;
    }
    
    //default constructor
    public Money() {
    }
    
    //use to return amount field
    public int getAmount() {
        return amount;
    }
    //use to set amount field
    public void setAmount(int amount) {
        this.amount = amount;
    }
    //use to subtract 100 from amount field
    public void remove() {
        amount -= 100;
    }
    //use to add 100 to the amount field
    public void add() {
        amount += 100;
    }

}
