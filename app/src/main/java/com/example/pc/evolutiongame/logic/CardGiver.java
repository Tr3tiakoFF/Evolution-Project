package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class CardGiver {
    public static List<Card> getCardsForPlayer(List<Card> deck){
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 6; i++) {
            cards.add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        return cards;
    }

    public static List<List<Card>> getCardsForPlayers(int playerCount, List<Card> deck) {
        List<List<Card>> listOfCards = new ArrayList<List<Card>>() {};
        for (int i = 0; i < 6; i++) {
            List<Card> localeList = getCardsForPlayer(deck);
            listOfCards.add(localeList);
        }
        return listOfCards;
    }
}
