package com.company;

/**
 * Created by Danny on 1/23/2017.
 */


public class Card {
    private int value;
    private Suit suit;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        String rank;
        if (value == 1) {
            rank = "ACE";
        } else if (value == 11) {
            rank = "JACK";
        } else if (value == 12) {
            rank = "QUEEN";
        } else if (value == 13) {
            rank = "KING";
        } else {
            rank = String.valueOf(value);
        }
        return rank + " of " + suit;
    }
}

