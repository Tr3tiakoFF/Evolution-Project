package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<Property> properties = new ArrayList<Property>();

    public Card(List<Property> values_) {
        this.properties = values_;
    }
    public Card(){};

    public List<Property> getProperties() {
        return properties;
    }
}
