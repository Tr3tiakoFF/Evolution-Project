package com.example.pc.evolutiongame.model;

import com.example.pc.evolutiongame.logic.FoodGenerator;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final Field field;
    private final List<Player> players;
    private List<Card> deck;
    private int capacityFood;
    private int playerControlCount;
    private int numberPlayers;

    public Room() {
        this.numberPlayers = 2;
        this.field = new Field();
        this.players = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.capacityFood = 0;
        this.playerControlCount = 0;
    }

    public Room(int numberPlayers) {
        this();
        this.numberPlayers = numberPlayers;
    }

//    public static Room getTestRoom() {
//        Room room = new Room();
//
//        room.addPlayer(new Player());
//        room.addPlayer(new Player());
//
//        room.addDeck(DeckShufler.deckShuffle());
//
//        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());
//
//        for (int i = 0; i < room.numberPlayers(); i++) {
//            room.addCardsToPlayer(i, cardsForPlayers.get(i));
//        }
//
//        room.setAllNotPass();
//
//        do {
//            Player currentPlayer = room.getCurrentPlayer();
//
//            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
//
//            Card currentCard = currentPlayer.getCard(localRandomCardNumber);
//
//            room.getCurrentPlayer().playAnimal(room.getField(), localRandomCardNumber);
//
//            room.getCurrentPlayer().setPass(true);
//            room.setNextPlayer();
//        }
//        while (!room.allPlayersPass());
//
//
//        return room;
//    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addDeck(List<Card> deck) {
        this.deck.addAll(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public boolean canAddPlayer() {
        return this.players.size() < 6;
    }

    public boolean canStartGame() {
        return this.players.size() >= numberPlayers;
    }

    public int numberPlayers() {
        return players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(this.playerControlCount % this.numberPlayers());
    }

    public boolean allPlayersPass() {
        int localeNum = 0;
        for (int i = 0; i < this.players.size(); i++) {
            if (!this.getPlayers().get(i).isPass())
                localeNum++;
        }
        return localeNum == 0;
    }

    public void setAllNotPass() {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setPass(false);
        }
    }

    public void setNextPlayer() {
        this.playerControlCount++;
    }

    public Field getField() {
        return field;
    }

    public void outAnimalsList() {
        for (int i = 0; i < this.field.getAnimalsCount(); i++) {
            System.out.println(field.getAnimals().get(i).toString());
        }
    }

    public int getCurrentPlayerAnimalsCount(Player player) {
        int animalCount = 0;
        for (int i = 0; i < this.field.getAnimalsCount(); i++) {
            if (field.getAnimals().get(i).player == player) {
                animalCount++;
            }
        }
        return animalCount;
    }

    public void setAllPass() {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setPass(true);
        }
    }

    public void setCapacityFood(int countPlayers) {
        this.capacityFood = FoodGenerator.generateFood(countPlayers);
    }

    public int getCapacityFood() {
        return capacityFood;
    }

    public void loseFood() {
        this.capacityFood--;
    }

    public int calculateAnimalNum(int animalNum, int playerNum) {
        int plusCount = 0;
        for (int i = 0; i < playerNum - 1; i++) {
            plusCount += getCurrentPlayerAnimalsCount(getPlayers().get(i));
        }
        return plusCount + animalNum - 1;
    }

    public void addCardsToPlayer(int i, List<Card> cards) {
        players.get(i).addCards(cards);
    }

    public String getWinner() {
        int[] countArr = new int[this.players.size()];
        for (int i = 0; i < this.players.size(); i++) {
            countArr[i] = this.players.get(i).calculateEndgameCounter(this.field);
        }
        int winnerNum = this.getWiner(countArr);
        switch (winnerNum) {
            case 1:
                return "Winner is player  number 1 CONGRATULATIONS!!!!";
            case 2:
                return "Winner is player  number 2 CONGRATULATIONS!!!!";
            case 3:
                return "Winner is player  number 3 CONGRATULATIONS!!!!";
            case 4:
                return "Winner is player  number 4 CONGRATULATIONS!!!!";
            case 5:
                return "Winner is player  number 5 CONGRATULATIONS!!!!";
            case 6:
                return "Winner is player  number 6 CONGRATULATIONS!!!!";
        }
        return "There are no winners";
    }

    private int getWiner(int[] countArr) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (max < countArr[i]) {
                max = countArr[i];
                counter = i;
            }
        }
        return counter;
    }

    public List<Animal> getAnimals() {
        return this.field.getAnimals();
    }

    public void calculateAnimalsFoodCapacity() {
        field.calculateAnimalsFoodCapacity();
    }
}
