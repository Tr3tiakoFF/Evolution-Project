package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.AnimalProperty;
import com.example.pc.evolutiongame.model.Card;

import java.util.ArrayList;
import java.util.List;

import static com.example.pc.evolutiongame.model.AnimalProperty.*;

public class DeckShufler {

    public static List<Card> deckShuffle(List<Card> deck) {
        for (int i = deck.size() - 1; i >= 0; i--) {
            int localeRnd = (int) (Math.random() * i);

            Card localeNum = deck.get(i);

            deck.set(i, deck.get(localeRnd));
            deck.set(localeRnd, localeNum);
        }
        return deck;
    }

    public static List<Card> deckShuffle() {
        List<Card> deck = fill();

        deck = deckShuffle(deck);

        return deck;
    }

    private static List<Card> put (List<Card> deck, int сount, AnimalProperty property){
        for (int i = 0; i < сount; i++) {
            deck.add(new Card(property));
        }
        return deck;
    }

    private static List<Card> fill (){
        List<Card> deck = new ArrayList<Card>();
        try
        {
            deck = put(deck,4,CAMOUFLAGE);
            deck = put(deck,4,BURROWING);
            deck = put(deck,4,SHARP_VISION);
            deck = put(deck,4,SYMBIOSYS);
            deck = put(deck,4,PIRACY);
            deck = put(deck,4,GRAZING);
            deck = put(deck,4,TAIL_LOSS);
            deck = put(deck,4,HIBERNATION_ABILITY);
            deck = put(deck,4,POISONOUS);
            deck = put(deck,4,COMMUNICATION);
            deck = put(deck,4,SCAVENGER);
            deck = put(deck,4,RUNNING);
            deck = put(deck,4,MIMICRY);
            deck = put(deck,8,SWIMMING);
            deck = put(deck,4,PARASITE_AND_CARNIVOROUS);
            deck = put(deck,4,PARASITE_AND_FAT_TISSUE);
            deck = put(deck,4,COOPERATION_AND_CARNIVOROUS);
            deck = put(deck,4,COOPERATION_AND_FAT_TISSUE);
            deck = put(deck,4,HIGH_BODY_WEIGHT_AND_CARNIVOROUS);
            deck = put(deck,4,HIGH_BODY_WEIGHT_AND_FAT_TISSUE);
        }
        catch (Exception e){}

        return deck;
    }
}