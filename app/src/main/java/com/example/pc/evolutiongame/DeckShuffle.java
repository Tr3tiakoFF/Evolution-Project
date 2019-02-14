package com.example.pc.evolutiongame;

import java.util.List;

public class DeckShuffle {
    public List<Integer> deckShuffle (List<Integer> deck){
        for (int i = deck.size() -1; i >= 0; i--) {

            int localeRnd = (int)(Math.random()*i);

            int localeNum = deck.get(i);

            deck.set(i,deck.get(localeRnd));
            deck.set(localeRnd,localeNum);
        }
        return deck;
    }
}
