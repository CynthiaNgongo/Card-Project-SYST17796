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
    //calling fields outside to be used by all methods
    private Player cpu;
    private Player player;
    private Money money;
    private Hand playerHand, cpuHand;
    private Dealer dealer;
    private boolean cont, done, stay;
    private int hit;
    //constructor with gameName
    public Blackjack(String givenName) {
        super(givenName);
    }
    //contains the content of the game 
    @Override
    public void play() {
        //declare and initialize scanner object
        Scanner in = new Scanner(System.in);
        //get input from user
        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        //initialize a Dealer and Money
        dealer = new Dealer();
        money = new Money(500);
        //initiial cpu and player
        player = new GamePlayer(name, money);
        cpu = new CPU("Dealer");
        cont = true;
        //loop through until the player runs out of money or cashes in
        while (cont) {
            if (player.getMoney() <= 0) {
                System.out.println("Sorry, you ran out of money\nGoodbye!");
                break;
            }
            System.out.print("1 for Deal, 2 for Cash in: ");
            int deal = in.nextInt();
            in = new Scanner(System.in);
            if (deal == 1) {

                dealer.setNewRound(true);
                playerHand = new Hand();
                cpuHand = new Hand();
                dealer.deal(cpuHand);
                dealer.setNewRound(false);
                dealer.deal(playerHand);

                System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                done = false;
                stay = false;
                while (done == false) {
                    while (playerHand.getValue() < 21 && stay == false) {
                        System.out.print("1 for HIT, 2 for STAY: ");
                        hit = in.nextInt();
                        if (hit == 1) {
                            dealer.hit(playerHand);
                            if (cpuHand.getValue() < 17) {
                                dealer.hit(cpuHand);
                            }

                            System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                            System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());

                        } else {
                            while (cpuHand.getValue() < 17) {
                                dealer.hit(cpuHand);
                            }
                            System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                            System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                            stay = true;

                        }

                    }
                    checkValue();
                    //comparing values
                }

            } else {
                System.out.println("You cashed in for $" + player.getMoney() + "\nYour wins: " + player.getWins());
                declareWinner();
                System.out.println("Thank you, Goodbye!");
                break;
            }

        }
    }

    @Override
    public void declareWinner() {
        if (player.getMoney() >= 1000) {
            System.out.println("You have cashed out with $1000 or over\nYou won");
        } else {
            System.out.println("Sorry you lost. You didn't cash out with $1000");
        }
    }

    public void checkValue() {
        if (playerHand.getValue() == 21) {
            player.win();
            System.out.println("You got 21! You win. You now have: $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if (cpuHand.getValue() == 21) {
            player.lose();
            System.out.println("The dealer has gotten 21. You lost and have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if (playerHand.getValue() > 21) {

            player.lose();
            System.out.println("You have gone bust. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if (cpuHand.getValue() > 21) {

            player.win();
            System.out.println("The dealer has gone bust. You win and have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());

            done = true;

        } else if (playerHand.getValue() > cpuHand.getValue()) {
            player.win();
            System.out.println("You have won. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if (playerHand.getValue() < cpuHand.getValue()) {
            player.lose();
            System.out.println("You have lost. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if (playerHand.getValue() == cpuHand.getValue()) {
            System.out.println("You have tied. You still have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } else if ((cpuHand.getValue() == 21 && playerHand.getValue() == 21)
                || (cpuHand.getValue() == playerHand.getValue())) {
            System.out.println("You and the dealer have tied. You still have: $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        }
    }
}
