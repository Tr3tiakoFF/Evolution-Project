package com.example.pc.evolutiongame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CardGiverTest {
    @Test
    public void cardGiver() {
        final CardGiver cardGiver = new CardGiver();
        final List<Integer> deck = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            deck.add(i);
        }

        int expectedCard = deck.get(0);
        int givedCard = cardGiver.cardGiver(deck);

        Assert.assertEquals(expectedCard,givedCard);
    }
}
