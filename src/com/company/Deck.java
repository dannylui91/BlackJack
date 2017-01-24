package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Danny on 1/24/2017.
 */

public class Deck {
    private final static int TOTAL_NUM_OF_SUITS = 4;
    private final static int TOTAL_NUM_OF_RANKS = 13;
    private final static int TOTAL_NUM_OF_CARDS = TOTAL_NUM_OF_SUITS * TOTAL_NUM_OF_RANKS;
    private List<Card> deck = new ArrayList<>();

    public Deck() {
        makeDeck();
    }

    private void makeDeck() {
        List<Card> newDeck = new ArrayList<>();
        for (int i = 1; i <= TOTAL_NUM_OF_SUITS; i++) {
            for (int j = 1; j <= TOTAL_NUM_OF_RANKS; j++) {
                Suit suit = null;
                if (i == 1) {
                    suit = Suit.DIAMOND;
                } else if (i == 2) {
                    suit = Suit.CLUB;
                } else  if (i == 3) {
                    suit = Suit.HEART;
                } else if (i == 4) {
                    suit = Suit.SPADE;
                }
                newDeck.add(new Card(suit, j));
            }
        }
        deck = newDeck;
    }

    public void shuffle() {
        List<Card> shuffledDeck = new ArrayList<>();
        int remainingCards = deck.size();
        while (!deck.isEmpty()) {
            Random random = new Random();
            int randNum = random.nextInt(remainingCards);
            shuffledDeck.add(deck.get(randNum));
            deck.remove(randNum);
            remainingCards--;
        }
        deck = shuffledDeck;
    }

    public Card deal() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public Card peek() {
        return deck.get(0);
    }

    public void reshuffle() {
        makeDeck();
        shuffle();
    }

    public void print() {
        for (int i = 0; i < TOTAL_NUM_OF_CARDS; i++) {
            System.out.println(deck.get(i));
        }
    }

    public int getSize() {
        return deck.size();
    }
}
