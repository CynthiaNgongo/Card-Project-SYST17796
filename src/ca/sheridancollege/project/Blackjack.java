/*
 * Leonardo Stifano
 * Student ID: 991 532 946
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author lstif
 */
public class Blackjack extends Game {
    
    private Player cpu;
    private Player player;
    private Money money;
    private Hand playerHand, cpuHand;
    private Dealer dealer;
    
    public Blackjack(String givenName) {
        super(givenName);
        cpu = new CPU("Dealer");
    }
    
    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = in.nextLine();
        in = new Scanner(System.in);
        dealer = new Dealer();
        money = new Money(500);
        player = new GamePlayer(name, money);
        boolean cont = true;
        while (cont) {
            System.out.println("1 for Deal, 2 for Cash in: ");
            int deal = in.nextInt();
            if (deal == 1) {
                dealer.setNewRound(true);
                playerHand = new Hand();
                cpuHand = new Hand();
                dealer.deal(cpuHand);
                dealer.deal(playerHand);
                
                System.out.println("Dealer Hand: " + cpuHand.getHand());
                System.out.println(player.getPlayerID() + "'s Hand: " + playerHand.getHand());
                
            } else {
                System.out.println("You cashed in for $" + player.getMoney());
                System.out.println("Thank you!");
                break;
            }
            
        }
    }
    
    @Override
    public void declareWinner() {
    }
}
