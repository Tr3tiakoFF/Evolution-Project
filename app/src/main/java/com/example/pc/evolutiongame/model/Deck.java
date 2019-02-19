package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<Card>();

    public List<Card> deckShuffle (List<Card> deck){
        for (int i = deck.size() -1; i >= 0; i--) {

            int localeRnd = (int)(Math.random()*i);

            Card localeNum = deck.get(i);

            deck.set(i,deck.get(localeRnd));
            deck.set(localeRnd,localeNum);
        }
        return deck;
    }
}