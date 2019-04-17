package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.BURROWING;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.CARNIVOROUS;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.COMMOUFLAGE;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.COMMUNICATION;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.COOPERATION;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.FAT_TISSUE;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.GRAZING;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.HIBERNATION_ABILITY;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.HIGH_BODY_WEIGHT;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.MIMICRY;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.PARASITE;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.PIRACY;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.POISONOUS;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.RUNNING;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.SCAVENGER;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.SHARP_VISION;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.SWIMMING;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.SYMBIOSYS;
import static com.example.pc.evolutiongame.model.LowLevelAnimalProperty.TAIL_LOSS;

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

    private static List<Card> put(List<Card> deck, int сount, List<Property> properties) {
        for (int i = 0; i < сount; i++) {
            deck.add(new Card(properties));
        }
        return deck;
    }

    private static List<Card> fill (){
        List<Card> deck = new ArrayList<Card>();
        try {
            deck = put(deck, 4, Arrays.asList(new Property(COMMOUFLAGE), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(BURROWING), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(SHARP_VISION), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(SYMBIOSYS)));
            deck = put(deck, 4, Arrays.asList(new Property(PIRACY)));
            deck = put(deck, 4, Arrays.asList(new Property(GRAZING), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(TAIL_LOSS)));
            deck = put(deck, 4, Arrays.asList(new Property(HIBERNATION_ABILITY), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(POISONOUS), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(COMMUNICATION), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(SCAVENGER)));
            deck = put(deck, 4, Arrays.asList(new Property(RUNNING)));
            deck = put(deck, 4, Arrays.asList(new Property(MIMICRY)));
            deck = put(deck, 8, Arrays.asList(new Property(SWIMMING)));
            deck = put(deck, 4, Arrays.asList(new Property(PARASITE), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(PARASITE), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(COOPERATION), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(COOPERATION), new Property(FAT_TISSUE)));
            deck = put(deck, 4, Arrays.asList(new Property(HIGH_BODY_WEIGHT), new Property(CARNIVOROUS)));
            deck = put(deck, 4, Arrays.asList(new Property(HIGH_BODY_WEIGHT), new Property(FAT_TISSUE)));
        } catch (Exception e){}

        return deck;
    }

    private static List<Card> fillForFood() {
        List<Card> deck = new ArrayList<Card>();
        try {
            deck = put(deck, 84, Arrays.asList(new Property(CARNIVOROUS)));
        } catch (Exception e) {
        }

        return deck;
    }

    public static List<Card> deckShuffleForFoodTest() {
        List<Card> deck = fillForFood();

        deck = deckShuffle(deck);

        return deck;
    }
}