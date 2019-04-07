package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardGiverTest {

    @Test
    public void getCardsForPlayer (){
        DeckShufler deckShufler = new DeckShufler();
        List<Card> deck = deckShufler.deckShuffle();

        CardGiver cardGiver = new CardGiver();

        List<Card> cardsForPlayer = cardGiver.getCardsForPlayer(deck, 6);

        Assert.assertNotNull(cardsForPlayer);
        Assert.assertNotEquals(0 ,cardsForPlayer.size());
        Assert.assertEquals(6 ,cardsForPlayer.size());
    }

    @Test
    public void getCardsForSeveralPlayers (){
        DeckShufler deckShufler = new DeckShufler();
        List<Card> deck = deckShufler.deckShuffle();

        CardGiver cardGiver = new CardGiver();

        List<List<Card>> cardsForPlayer = cardGiver.getCardsForPlayers(6,deck);

        Assert.assertNotNull(cardsForPlayer);
        Assert.assertNotEquals(0 ,cardsForPlayer.size());
        Assert.assertEquals(6 ,cardsForPlayer.size());
        for (List<Card> cards : cardsForPlayer) {
            Assert.assertEquals(6 ,cards.size());
        }
    }

    @Test
    public void cardsShouldNotBeSameOnPlayers(){

    }
}