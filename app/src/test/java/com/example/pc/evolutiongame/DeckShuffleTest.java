package com.example.pc.evolutiongame;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class DeckShuffleTest {
    @Test
    public void deckShuffle() {
        final DeckShuffle deckShuffle = new DeckShuffle();

        final List<Integer> deck = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            deck.add(i);
        }


        final List<Integer> shufledDeck = deckShuffle.deckShuffle(deck);

        Queue<Integer> expectedDeck = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
            expectedDeck.add(i);
        }

        Assert.assertNotEquals(expectedDeck,shufledDeck);
    }
}