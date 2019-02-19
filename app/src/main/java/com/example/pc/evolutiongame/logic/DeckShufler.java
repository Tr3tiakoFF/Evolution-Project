package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;

import java.util.ArrayList;
import java.util.List;

public class DeckShufler {
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