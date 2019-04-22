package com.example.pc.evolutiongame.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player {
    private String id;
    private boolean isPass;
    private List<Card> cards;

    public Player() {
        this.cards = new CopyOnWriteArrayList<>();
    }

    public Player(String id) {
        this();
        this.id = id;
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card getCard(int cardNum) {
        return cards.get(cardNum);
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public int getCardsCount() {
        return this.cards.size();
    }

    public boolean canPlay() {
        return !this.cards.isEmpty();
    }


    public void playAnimal(Field field, int localRandomCardNumber) {
        field.addAnimal(this);
        cards.remove(localRandomCardNumber);
    }

    public void playProperty(Field field, int localRandomCardNumber, int localRandomAnimalNumber, int cardPropertyNum) {
        List<Animal> animals = field.getAnimals(this);
        List<Property> properties = animals.get(localRandomAnimalNumber).getProperty();
        Property property = cards.get(localRandomCardNumber).properties.get(cardPropertyNum);
        if (isValid(properties, property)) {
            properties.add(property);
        }
        cards.remove(localRandomCardNumber);
    }

    private boolean isValid(List<Property> properties, Property property) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i) == property) {
                return false;
            }
        }
        return true;
    }

    public void giveFood(Room room, int localRandomAnimalNumber) {
        if (room.getCapacityFood() != 0) {
            room.getField().getAnimals(this).get(localRandomAnimalNumber).getFood();
            room.loseFood();
        } else setPass(true);
    }

    public int calculateEndgameCounter(Field field) {
        int winnerCount = 0;
        return field.getAnimalsCount(this) + field.getAnimalsPropertyCount(this) + field.getAnimalsFoodCapacityCount(this);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                '}';
    }

    public List<Card> getCards() {
        return cards;
    }
}
