package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GameTest {

    private Room room;
    private Player currentPlayer;

    @Test
    public void createRoomWhenServerIsRun() {
        room = new Room();
    }

    @Test(priority = 1)
    public void waitMinimalNumberPlayersForGameAndAddThemToRoom() {
        int numberOfPlayers = 2;

        for (int i = 0; i < numberOfPlayers; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertTrue(room.canStartGame());
    }

    @Test(priority = 2)
    public void deckShuffle() {
        Assert.assertNotNull(room.getDeck());
        Assert.assertTrue(room.getDeck().isEmpty());

        room.addDeck(DeckShufler.deckShuffle());

        Assert.assertEquals(84, room.getDeck().size());
    }

    @Test(priority = 3)
    public void giveCardsForPlayers() {
        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());
        Assert.assertNotNull(cardsForPlayers);

        for (int i = 0; i < room.numberPlayers(); i++) {
            room.addCardsToPlayer(i, cardsForPlayers.get(i));
        }

        for (int i = 0; i < room.getPlayers().size(); i++) {
            Assert.assertNotEquals(0, cardsForPlayers.get(i).size());
        }
    }

    @Test(priority = 4)
    public void selectPlayerWhoShouldPlay() {
        currentPlayer = room.getCurrentPlayer();
        Assert.assertNotNull(currentPlayer);
    }

    @Test(priority = 5)
    public void checkWhetherCurrentPlayerCanPlay() {
        Assert.assertTrue(currentPlayer.canPlay());

//        if (currentPlayer.canPlay()) {
//            currentPlayer.setPass(true);
//        }
    }

    @Test(priority = 6)
    public void firstPlayerSelectCardAndPlayIt() {
        int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());

        currentPlayer.playAnimal(room.getField(), localRandomCardNumber);
    }

    @Test(priority = 7)
    public void selectNextPlayer() {
        room.setNextPlayer();

        currentPlayer = room.getCurrentPlayer();
        Assert.assertNotNull(currentPlayer);
    }

    @Test(priority = 8)
    public void checkWhetherSecondPlayerCanPlay() {
        Assert.assertTrue(currentPlayer.canPlay());

//        if (currentPlayer.canPlay()) {
//            currentPlayer.setPass(true);
//        }
    }



    @Test(priority = 7)
    public void secondPlayerSelectCardAndPlayIt() {
        int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());

        currentPlayer.playAnimal(room.getField(), localRandomCardNumber);
    }

    //TODO logic change
    @Test
    public void cardPlayTest() {
//        room.setAllNotPass();

        do {
//            Player currentPlayer = room.getCurrentPlayer();
//            Assert.assertNotNull(currentPlayer);

//            int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());

//            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
//            Assert.assertNotNull(currentCard);

//            currentPlayer.playAnimal(room.getField(), localRandomCardNumber);

//            if (currentPlayer.getCardsCount() == 0) {
//                currentPlayer.setPass(true);
//            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());


        for (int i = 0; i < room.getPlayers().size(); i++) {
            Assert.assertEquals(0, room.getPlayers().get(i).getCardsCount());

        }


        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

        for (int i = 0; i < room.numberPlayers(); i++) {
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
        Room room = new Room();

        Assert.assertNotNull(room.getDeck());
        Assert.assertEquals(84, room.getDeck().size());

        for (int i = 0; i < 2; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertTrue(room.canStartGame());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());
        Assert.assertNotNull(cardsForPlayers);

        for (int i = 0; i < room.numberPlayers(); i++) {
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


        cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

        for (int i = 0; i < room.numberPlayers(); i++) {
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

        room.setCapacityFood(room.numberPlayers());


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
}