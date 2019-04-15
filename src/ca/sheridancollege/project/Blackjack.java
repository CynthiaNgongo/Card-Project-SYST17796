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
        cpu = new CPU("Dealer");
        boolean cont = true;
        while (cont) {
            if (player.getMoney() <= 0) {
                System.out.println("Sorry, you ran out of money\nGoodbye!");
                break;
            }
            System.out.println("1 for Deal, 2 for Cash in: ");
            int deal = in.nextInt();
            in = new Scanner(System.in);
            if (deal == 1) {

                dealer.setNewRound(true);
                playerHand = new Hand();
                cpuHand = new Hand();
                dealer.deal(cpuHand);
                dealer.deal(playerHand);

                System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                boolean done = false;
                boolean stupidthing = true;
                while (done == false) {
                    int hit = 1;
                    while (playerHand.getValue() < 21 && stupidthing == true) {
                        System.out.println("1 for HIT, 2 for STAY");
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
                            stupidthing = false;

                        }

                    }
                    if (playerHand.getValue() == 21) {
                        player.addMoney();
                        player.win();
                        System.out.println("You got 21! You win. You now have: $" + player.getMoney());
                        done = true;

                    } else if (cpuHand.getValue() == 21) {
                        player.removeMoney();
                        System.out.println("The dealer has gotten 21. You lost and have $" + player.getMoney());
                        player.lose();
                        done = true;

                    } else if (playerHand.getValue() > 21) {

                        player.removeMoney();
                        System.out.println("You have gone bust. You have $" + player.getMoney());
                        player.lose();
                        done = true;

                    } else if (cpuHand.getValue() > 21) {

                        player.addMoney();
                        System.out.println("The dealer has gone bust. You win and have $" + player.getMoney());
                        player.win();
                        done = true;

                    } else if (playerHand.getValue() > cpuHand.getValue()) {
                        player.addMoney();
                        System.out.println("You have won. You have $" + player.getMoney());
                        player.win();
                        done = true;

                    } else if (playerHand.getValue() < cpuHand.getValue()) {
                        player.removeMoney();
                        System.out.println("You have lost. You have $" + player.getMoney());
                        player.lose();
                        done = true;

                    } else if (playerHand.getValue() == cpuHand.getValue()) {
                        System.out.println("You have tied. You have $" + player.getMoney());
                        done = true;

                    } else if ((cpuHand.getValue() == 21 && playerHand.getValue() == 21)
                            || (cpuHand.getValue() == playerHand.getValue())) {
                        System.out.println("You and the dealer have tied. You still have: $" + player.getMoney());
                        done = true;
                    }
                }

            } else {
                System.out.println("You cashed in for $" + player.getMoney());
                System.out.println("Thank you, Goodbye!");
                break;
            }

        }
    }

    @Override
    public void declareWinner() {
    }
}
