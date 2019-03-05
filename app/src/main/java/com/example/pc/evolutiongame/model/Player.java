package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private boolean isPass;

    List<Card> cards = new ArrayList<Card>();

    public void addCards(List<Card> cards) {
        this.cards = cards;
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


    public void playAnimal(Field field ,int localRandomCardNumber) {
        field.addAnimal(this);
        cards.remove(localRandomCardNumber);
    }
}
