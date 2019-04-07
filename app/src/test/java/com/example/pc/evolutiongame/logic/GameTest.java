package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GameTest {
    @Test
    public void cardPlayTest() {
        List<Card> deck = DeckShufler.deckShuffle();
        Room room = new Room(deck);

        Assert.assertNotNull(room.getDeck());
        Assert.assertEquals(84, room.getDeck().size());

        for (int i = 0; i < 2; i++) {
            room.addPlayer(new Player());
        }
        Assert.assertTrue(room.canStartGame());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());
        Assert.assertNotNull(cardsForPlayers);

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0, cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playAnimal(room.getField(), localRandomCardNumber);

            if (room.getCurrentPlayer().getCardsCount() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());

        for (int i = 0; i < room.getPlayers().size(); i++) {
            Assert.assertEquals(0, room.getPlayers().get(i).getCardsCount());

        }


        cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0, cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
            int localRandomAnimalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playProperty(room.getField(), localRandomCardNumber, localRandomAnimalNumber, 0);

            if (room.getCurrentPlayer().getCardsCount() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());

        for (int i = 0; i < room.getPlayers().size(); i++) {
            Assert.assertEquals(0, room.getPlayers().get(i).getCardsCount());

        }


        room.getAnimalsList();
    }


    @Test
    public void foodTest() {
        List<Card> deck = DeckShufler.deckShuffleForFoodTest();
        Room room = new Room(deck);

        Assert.assertNotNull(room.getDeck());
        Assert.assertEquals(84, room.getDeck().size());

        for (int i = 0; i < 2; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertTrue(room.canStartGame());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());
        Assert.assertNotNull(cardsForPlayers);

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0, cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playAnimal(room.getField(), localRandomCardNumber);

            room.getCurrentPlayer().setPass(true);
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());


        cardsForPlayers = CardGiver.getCardsForPlayers(room.countPlayers(), room.getDeck());

        for (int i = 0; i < room.countPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }
        Assert.assertNotEquals(0, cardsForPlayers.get(0).size());

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
            int localRandomAnimalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
            Assert.assertNotNull(currentCard);

            room.getCurrentPlayer().playProperty(room.getField(), localRandomCardNumber, localRandomAnimalNumber, 0);

            if (room.getCurrentPlayer().getCardsCount() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());


        room.setAllNotPass();

        room.setCapacityFood(room.countPlayers());


        do {
            Player currentPlayer = room.getCurrentPlayer();
            Assert.assertNotNull(currentPlayer);

            room.getCurrentPlayer().giveFood(room, 0);

            if (room.getCapacityFood() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());

        room.getAnimalsList();

        room.getField().killAllMustDie();

        room.getAnimalsList();

        room.getField().killAllMustNotDie();

        room.getAnimalsList();

        room.getField().killAll();

        room.getAnimalsList();

        Gson gson = new GsonBuilder().create();
        String roomAsJson = gson.toJson(room);

        Assert.assertEquals(roomAsJson, "");
    }

    /*
     * room.getPlayer().playAnimal();
     *
     * class field
     * {
     *   List<Animal>
     * }
     *
     * class Player{
     * List<Animal>
     * }
     *
     * player.list.add(field.list.get(int));
     *
     * */

}