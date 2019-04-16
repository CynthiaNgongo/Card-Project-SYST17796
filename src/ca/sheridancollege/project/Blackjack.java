/*
 * Leonardo Stifano
 * Cynthia Ngongo
 * Vinushan Wickramasingam
 * Tsz-Kin Yeung
 */
package ca.sheridancollege.project;

import java.util.Scanner;

public class Blackjack extends Game {
    //declaring global variables
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
            //before starting round, check if the user has run out of money
            if (player.getMoney() <= 0) {
                //if the user runs out of money, break them out of the loop
                System.out.println("Sorry, you ran out of money\nGoodbye!");
                break;
            }
            //take user input
            System.out.print("1 for Deal, 2 for Cash in: ");
            int deal = in.nextInt();
            in = new Scanner(System.in);
            //execute if the user wants to get dealt a card
            if (deal == 1) {
                //set a new round for dealer validation
                dealer.setNewRound(true);
                //create the new hands
                playerHand = new Hand();
                cpuHand = new Hand();
                //after dealing to one player, make new round false
                dealer.deal(cpuHand);
                dealer.setNewRound(false);
                //deal to next player
                dealer.deal(playerHand);
                //display dealers hand without revealing the first card
                System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                //display whole player hand
                System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                //initialize done and stay variables
                done = false;
                stay = false;
                //while execution is not done, continue
                while (done == false) {
                    //continue while the user did not select STAY or the user has not gone bust
                    while (playerHand.getValue() < 21 && stay == false) {
                        System.out.print("1 for HIT, 2 for STAY: ");
                        hit = in.nextInt();
                        //if user choses HIT, deal to them
                        if (hit == 1) {
                            dealer.hit(playerHand);
                            //if the cpu hand value is under 17, deal to them as well
                            if (cpuHand.getValue() < 17) {
                                dealer.hit(cpuHand);
                            }
                            //display dealer hand (hidden first card) and player hand
                            System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                            System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                            //loop continues execution due to HIT being selected
                            
                        //if the player chooses to STAY, continue to deal to the cpu unless the cpu hand value is 17 or greater
                        } else {
                            while (cpuHand.getValue() < 17) {
                                dealer.hit(cpuHand);
                            }
                            //display dealer hand(hidden first) and player hand
                            System.out.println("Dealer Hand:\t" + cpuHand.getHiddenHand());
                            System.out.println(player.getPlayerID() + "'s Hand:\t" + playerHand.getHand());
                            //initialize stay to true, to stop loop from starting
                            stay = true;
                            //go to the checkValue() function

                        }

                    }
                    //compare hand values, then finish loop
                    checkValue();
                }

            } 
            //if the user selects 2(or any other value), cash them out and find out if they won
            else {
                System.out.println("You cashed in for $" + player.getMoney() + "\nYour wins: " + player.getWins());
                //player wins if they end with at least $1000
                declareWinner();
                System.out.println("Thank you, Goodbye!");
                break;
            }

        }
    }
    //check if they player won
    @Override
    public void declareWinner() {
        if (player.getMoney() >= 1000) {
            System.out.println("You have cashed out with $1000 or over\nYou won");
        } else {
            System.out.println("Sorry you lost. You needed at least $1000");
        }
    }
    //compares the values of the player and cpu cards
    //must check that the values are equal to 21 or over, before comparing cpu and player values
    //otherwise, extra validation would be needed
    public void checkValue() {
        //check player first
        //player wins if they have 21
        if (playerHand.getValue() == 21) {
            //call win function - adds 1 win and $100
            player.win();
            System.out.println("You got 21! You win. You now have: $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //cpu wins if value is 21 and the player did not
        } else if (cpuHand.getValue() == 21) {
            player.lose();
            System.out.println("The dealer has gotten 21. You lost and have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //player loses if they go over 21
        } else if (playerHand.getValue() > 21) {
            player.lose();
            System.out.println("You have gone bust. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //cpu loses if the go over 21 and the player hasn't
        } else if (cpuHand.getValue() > 21) {
            player.win();
            System.out.println("The dealer has gone bust. You win and have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //if the player hand is greater than the cpu hand, the player wins (and !<= 21)
        } else if (playerHand.getValue() > cpuHand.getValue()) {
            player.win();
            System.out.println("You have won. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //if the player hand is less than the cpu hand, the player loses
        } else if (playerHand.getValue() < cpuHand.getValue()) {
            player.lose();
            System.out.println("You have lost. You have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;
        //if the player and cpu have the same value, they tie
        } else if (playerHand.getValue() == cpuHand.getValue()) {
            System.out.println("You have tied. You still have $" + player.getMoney());
            System.out.println("The dealer had: " + cpuHand.getHand());
            done = true;

        } 
    }
}
