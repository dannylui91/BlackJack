package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 1/24/2017.
 */
public class Player {
    public String name;
    public List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void add(Card card) {
        hand.add(card);
    }
}
