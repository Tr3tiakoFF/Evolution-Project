package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeckShuflerTest {
    @Test
    public void suffleExistDeck() {
        final DeckShufler deckShufler = new DeckShufler();

        final List<Card> deck = new LinkedList<>();
        for (int i = 0; i < 84; i++) {
            Card card = new Card();
            deck.add(card);
        }


        final List<Card> shufledDeck = deckShufler.deckShuffle(deck);

        Assert.assertNotNull(shufledDeck);
        Assert.assertNotEquals(0, shufledDeck.size());
        Assert.assertEquals(84, shufledDeck.size());

        Queue<Card> expectedDeck = new LinkedList<>();

        for (int i = 0; i < 84; i++) {
            Card card = new Card();
            expectedDeck.add(card);
        }

        Assert.assertNotEquals(expectedDeck, shufledDeck);
    }

    @Test
    public void shuffleNewDeck() {
        final DeckShufler deckShufler = new DeckShufler();

        final List<Card> shufledDeck = deckShufler.deckShuffle();

        Assert.assertNotNull(shufledDeck);
        Assert.assertNotEquals(0, shufledDeck.size());
        Assert.assertEquals(84, shufledDeck.size());

        Queue<Card> expectedDeck = new LinkedList<>();

        for (int i = 0; i < 84; i++) {
            Card card = new Card();
            expectedDeck.add(card);
        }

        Assert.assertNotEquals(expectedDeck, shufledDeck);
    }
}