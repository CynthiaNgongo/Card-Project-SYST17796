/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * Class name: Author: Kendrick, Tsz-Kin Yeung Date:
 *
 * Description:
 */
public class BlackJack extends Game {

    private Dealer dealer;

    public BlackJack() {
        super("BlackJack");
        setDealer();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer() {
        this.dealer = Dealer.getInstance();
    }

    private void showCardHand(Player player) {
        for (PlayingCard card : player.getCards()) {
            System.out.println(card.toString());
        }
    }

    @Override
    public void play() {
        do {
            System.out.println("Starting a new Game");
            dealer.selfDeal();
            for (Player player : getPlayers()) {
                player.getCards().clear();
                System.out.println(player.getPlayerID() + ":");
                player.getCards().addAll(Dealer.deal());
                showCardHand(player);
                System.out.print("\n");
            }
            System.out.println(dealer.showFirstCard());
            askHit();
            showAllPlayerCards();
            System.out.println(dealer.showAllCards());
            getResult();
        } while (again());
    }

    private void askHit() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < getPlayers().size(); i++) {
            Player player = getPlayers().get(i);
            if (player.getCards().getTotalValues() < 21) {
                if (player instanceof GamePlayer) {
                    boolean cont;
                    do {
                        System.out.println(player.getPlayerID() + ", do yow want to hit another card? (Y)");
                        if (sc.next().equalsIgnoreCase("y")) {
                            player.getCards().add(Dealer.hit());
                            System.out.println("Now you have:");
                            showCardHand(player);
                            cont = true;
                        } else {
                            cont = false;
                        }
                    } while (player.getCards().getTotalValues() < 21 && cont);
                } else {
                    do {
                        player.getCards().add(Dealer.hit());
                    } while (player.getCards().getTotalValues() < 17);
                }
            }
        }
    }

    private void showAllPlayerCards() {
        System.out.println("\n\n");
        for (int i = 0; i < getPlayers().size(); i++) {
            Player player = getPlayers().get(i);
            System.out.println(player.getPlayerID() + " have:");
            showCardHand(player);
        }
    }

    private void getResult() {
        for (int i = 0; i < getPlayers().size(); i++) {
            int total = getPlayers().get(i).getCards().getTotalValues();
            int dealerTotal = dealer.dealerTotal();
            if (checkWin(i)) {
                if (getPlayers().get(i) instanceof GamePlayer) {
                    GamePlayer player = (GamePlayer) getPlayers().get(i);
                    player.win();
                    System.out.println("You win, now you have $" + player.getMoney().getAmount());
                }
            } else if (checkLose(i)) {
                if (getPlayers().get(i) instanceof GamePlayer) {
                    GamePlayer player = (GamePlayer) getPlayers().get(i);
                    player.lose();
                    System.out.println("You lose, now you have $" + player.getMoney().getAmount());
                }
            } else if (total == dealerTotal) {
                if (getPlayers().get(i) instanceof GamePlayer) {
                    GamePlayer player = (GamePlayer) getPlayers().get(i);
                    System.out.println("Draw. now you have $" + player.getMoney().getAmount());
                }
            }
        }
    }

    private boolean again() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Another round? (Y)");
        if (sc.next().equalsIgnoreCase("y") && checkBalance()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkBalance() {
        GamePlayer player = (GamePlayer) getPlayers().get(0);
        if (player.getMoney().getAmount() == 0) {
            System.out.println("You're broke you have no more money");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkWin(int i) {
        boolean win = false;
        int total = getPlayers().get(i).getCards().getTotalValues();
        int dealerTotal = dealer.dealerTotal();
        if (!(total > 21)) {
            if (dealerTotal > 21) {
                win = true;
            } else if (total == 21) {
                win = true;
            } else if (total > dealerTotal) {
                win = true;
            }
        }
        return win;
    }
    
    private boolean checkLose(int i) {
        boolean lose = false;
        int total = getPlayers().get(i).getCards().getTotalValues();
        int dealerTotal = dealer.dealerTotal();
        if (total < 21) {
            if (dealerTotal > total) {
                lose = true;
            }
        } else if (total > 21){
            lose = true;
        }
        return lose;
    }

    @Override
    public void declareWinner() {
    }

}
