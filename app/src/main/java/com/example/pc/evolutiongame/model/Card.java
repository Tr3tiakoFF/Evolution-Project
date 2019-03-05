package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    Property property;

    public Card(AnimalProperty value_){
        this.property = new Property(value_);
    }
    public Card(){};
}
