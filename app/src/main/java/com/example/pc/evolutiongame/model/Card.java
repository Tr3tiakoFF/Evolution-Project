package com.example.pc.evolutiongame.model;

import com.example.pc.evolutiongame.logic.CardState;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<Property> properties = new ArrayList<Property>();
    CardState cardState;

    public Card(List<Property> values_) {
        this();
        this.properties = values_;
    }

    public Card() {
        this.cardState = CardState.UNUSED;
    }

    ;

    public List<Property> getProperties() {
        return properties;
    }

    public void setCardState(CardState cardState) {
        this.cardState = cardState;
    }

    public CardState getCardState() {
        return cardState;
    }
}
