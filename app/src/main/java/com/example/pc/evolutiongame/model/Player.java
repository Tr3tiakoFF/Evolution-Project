package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private boolean isPass;

    List<Card> cards = new ArrayList<Card>();

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
        if (isValid(field.getAnimals().get(localRandomAnimalNumber).properties, cards.get(localRandomCardNumber).properties.get(cardPropertyNum))
        )
            field.getAnimals().get(localRandomAnimalNumber).properties.add(cards.get(localRandomCardNumber).properties.get(cardPropertyNum));
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
        if (room.getCapacityFood() == 0) {
            room.getField().getAnimals().get(localRandomAnimalNumber).getFood();
            room.loseFood();
        } else setPass(true);
    }

    public int calculateEndgameCounter(Field field) {
        int winnerCount = 0;
        return field.getAnimalsCount(this) + field.getAnimalsPropertyCount(this) + field.getAnimalsFoodCapacityCount(this);
    }
}
