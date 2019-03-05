package com.example.pc.evolutiongame.model;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class Field {
    static List<Animal> animals = new ArrayList<Animal>();

    public static void addAnimal(Player player) {
        animals.add(new Animal(player));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getAnimalsCount() {
        return getAnimals().size();
    }
}
