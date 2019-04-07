package com.example.pc.evolutiongame.model;

import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.logic.DeckShufler;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AnimalFoodCapacityTest {
    @Test
    public void animalFoodCapacityTest() {
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

            if (room.getCurrentPlayer().getCardsCount() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
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


        Assert.assertTrue(room.getField().getAnimals().get(0).got(LowLevelAnimalProperty.CARNIVOROUS));
        Assert.assertFalse(room.getField().getAnimals().get(0).got(LowLevelAnimalProperty.POISONOUS));
        Assert.assertTrue(room.getField().canKill(room.getField().getAnimals().get(0), room.getField().getAnimals().get(0)));
        Assert.assertTrue(room.getField().canKill(room.getField().getAnimals().get(0), room.getField().getAnimals().get(1)));


        room.setAllNotPass();


        do {
            for (int i = 0; i < room.getField().getAnimalsCount(); i++) {
                room.getField().getAnimals().get(i).calculateFoodCapacity();
            }
            room.setAllPass();
        }
        while (!room.allPlayersPass());
    }
}