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

    public Room() {
        this.field = new Field();
        this.players = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.capacityFood = 0;
        this.playerControlCount = 0;
    }

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
        return this.players.size() >= 2;
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
            if (this.getPlayers().get(i).isPass() == false)
                localeNum++;
        }
        if (localeNum == 0)
            return true;
        else
            return false;
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

    public void getAnimalsList() {
        for (int i = 0; i < this.field.getAnimalsCount(); i++) {
            System.out.println(field.getAnimals().get(i).toString());
        }
    }

    public int getCurrentPlayerAnimalsCount(Player player) {
        int animalCount = 0;
        for (int i = 0; i < this.field.getAnimalsCount(); i++) {
            if (field.getAnimals().get(i).playerConnect == player) {
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
}
