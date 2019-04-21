package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    int capacityFood = 0;

    boolean mustDie = false;

    Animal(Player player) {
        this.player = player;
    }

    Player player;

    List<Property> properties = new ArrayList<>();

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
        return capacityFood != 0;
    }

    @Override
    public String toString() {
        return player.toString();
    }

    public boolean got(LowLevelAnimalProperty animalProperty) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getValue() == animalProperty) {
                return true;
            }
        }
        return false;
    }

    public void getFood(int foodCount) {
        for (int i = 0; i < foodCount; i++) {
            getFood();
        }
    }

    public void removeTailLoss() {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getValue() == LowLevelAnimalProperty.TAIL_LOSS) {
                properties.remove(i);
            }
        }
    }

    public int getPropertyCount() {
        return this.properties.size();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Property> getProperties() {
        return this.properties;
    }
}
