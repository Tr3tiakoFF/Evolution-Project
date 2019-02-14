package com.example.pc.evolutiongame;

import java.util.List;

public class CardRemover {
    public List<Integer> cardGiver (List<Integer> deck){
        deck.remove(0);
        return deck;
    }
}
