package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardGiver {
    public static List<Card> getCardsForPlayer(List<Card> deck, int cardsCount) {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < cardsCount; i++) {
            if (!deck.isEmpty()) {
                cards.add(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
        }
        return cards;
    }

    public static List<List<Card>> getCardsForPlayers(int numberPlayers, List<Card> deck) {
        List<List<Card>> listOfCards = new ArrayList<List<Card>>() {};
        for (int i = 0; i < numberPlayers; i++) {
            List<Card> localeList = getCardsForPlayer(deck, 6);
            listOfCards.add(localeList);
        }
        return listOfCards;
    }

//    public static List<List<Card>> getCardsForPlayersForUnits(int numberPlayers, List<Card> deck, Room room) {
//        List<List<Card>> listOfCards = new ArrayList<List<Card>>() {
//        };
//        for (int i = 0; i < numberPlayers; i++) {
//            if (room.getPlayers().get(i).getAnimalsCount(room.getField()) == 0) {
//
//                List<Card> localList = getCardsForPlayer(deck, 6);
//                listOfCards.add(localList);
//            } else {
//                List<Card> localList = getCardsForPlayer(deck, room.getPlayers().get(i).getAnimalsCount(room.getField()) + 1);
//                listOfCards.add(localList);
//            }
//        }
//        return listOfCards;
//    }
}
