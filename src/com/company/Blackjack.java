package com.company;

import java.util.Scanner;

/**
 * Created by Danny on 1/24/2017.
 */
public class Blackjack {
    private Deck deck;
    private boolean isGameOver;
    private Player player;

    public Blackjack() {
        deck = new Deck();
        player = new Player("Erick");
        isGameOver = false;
    }

    public void startGame() {
        System.out.println("GAME START!");
        deck.shuffle();
        Scanner scanner = new Scanner(System.in);

        // Deal
        System.out.println("Dealt: " + deck.peek());
        player.hand.add(deck.deal());

        while (!isGameOver) {
            System.out.println("Hit me? 0 = yes, 1 = no");
            int input = scanner.nextInt();
            if (input == 0) {
                System.out.println("Dealt: " + deck.peek());
                player.hand.add(deck.deal());
                calculateOutcome(player);
            } else {
                System.out.println("GAME ENDING");
                isGameOver = true;
            }
        }
    }

    private void calculateOutcome(Player player) {
        int sum = getPlayerHandValue(player);
        System.out.println(player.name + "'s hand value is " + sum);
        if (sum == 21) {
            System.out.println(player.name + " got 21!");
            isGameOver = true;
        } else if (sum > 21) {
            System.out.println(player.name + " busted!");
            isGameOver = true;
        }
    }

    public int getPlayerHandValue(Player player) {
        int handValue = 0;
        int aceCounter = 0;
        for (int i = 0; i < player.hand.size(); i++) {
            if (player.hand.get(i).getValue() > 10 && player.hand.get(i).getValue() <= 13)
                handValue += 10;
            else if (player.hand.get(i).getValue() == 1) {
                handValue += 1;
                aceCounter++;
            }
            else
                handValue += player.hand.get(i).getValue();
        }

        for (int i = 0; i < aceCounter; i++) {
            if (handValue + 10 <= 21)
                handValue += 10;
        }
        return handValue;
    }
}
