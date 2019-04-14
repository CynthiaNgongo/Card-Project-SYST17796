/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
*  Class name:
*  Author: Kendrick, Tsz-Kin Yeung
*  Date:
*
*  Description:
*/
public class BlackJack extends Game{
    
    private Dealer dealer;

    public BlackJack() {
        super("BlackJack");
        setDealer();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer() {
        this.dealer = new Dealer();
    }

    @Override
    public void play() {
    }

    @Override
    public void declareWinner() {
    }

}
