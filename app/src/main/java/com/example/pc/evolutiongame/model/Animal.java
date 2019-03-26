package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

class Animal {
    int capacityFood = 0;

    boolean mustDie = false;

    Animal() {
    }
    Animal(Player player){
        this.playerConnect = player;
    }

    Player playerConnect;

    List<Property> properties = new ArrayList<Property>();

    public void calculateFoodCapacity() {
        int foodCapacity = 1;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).equals(LowLevelAnimalProperty.PARASITE))
                foodCapacity += 2;
            if (properties.get(i).equals(LowLevelAnimalProperty.CARNIVOROUS))
                foodCapacity += 1;
            if (properties.get(i).equals(LowLevelAnimalProperty.HIGH_BODY_WEIGHT))
                foodCapacity += 1;
        }
        this.capacityFood = foodCapacity;
    }

    public void getFood() {
        this.capacityFood--;
    }

    public boolean mustDieCheck() {
        if (capacityFood != 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return (playerConnect.toString());
    }
}
