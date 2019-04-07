package com.example.pc.evolutiongame.model;

import com.example.pc.evolutiongame.logic.FoodGenerator;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int playerControlCount = 0;

    private Field field = new Field();

    private List<Player> players = new ArrayList<Player>();

    private List<Card> deck;

    private int capacityFood = 0;


    public Room(List<Card> deck) {
        this.deck = deck;
    }

    public Room() {
    }


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setField(Field field) {
        this.field = field;
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

    public int countPlayers() {
        return players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(this.playerControlCount % this.countPlayers());
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
}
