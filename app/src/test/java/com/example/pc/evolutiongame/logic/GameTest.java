package com.example.pc.evolutiongame.logic;

import android.service.autofill.FillResponse;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Field;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void cardGiveTest (){
        List<Card> deck = DeckShufler.deckShuffle();
        Room room = new Room(deck);

        Assert.assertNotNull(room.getDeck());
        Assert.assertEquals(84,room.getDeck().size());

        for (int i = 0; i < 2; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertTrue(room.canStartGame());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());
        Assert.assertNotNull(cardsForPlayers);

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0,cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int cardCount = room.getCurrentPlayer().getCardsCount();

            int localRandomCardNumber = (int)(Math.random()* room.getCurrentPlayer().getCardsCount());

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playAnimal(room.getField(), localRandomCardNumber);

            if(room.getCurrentPlayer().getCardsCount() == 0){
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (room.allPlayersPass());





        cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0,cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int cardCount = room.getCurrentPlayer().getCardsCount();

            int localRandomCardNumber = (int)(Math.random()* room.getCurrentPlayer().getCardsCount());
            int localRandomAnimalNumber = (int)(Math.random()* room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playProperty(room.getField(), localRandomCardNumber, localRandomAnimalNumber);

            if(room.getCurrentPlayer().getCardsCount() == 0){
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (room.allPlayersPass());
    }
}