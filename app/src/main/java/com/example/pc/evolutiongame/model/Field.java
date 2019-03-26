package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Player player) {
        animals.add(new Animal(player));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getAnimalsCount() {
        return getAnimals().size();
    }

    public void killAllMustDie() {
        for (int i = 0; i < getAnimalsCount(); i++) {
            if (getAnimals().get(i).mustDieCheck()) {
                getAnimals().remove(i);
                i--;
            }
        }
    }

    public void killAllMustNotDie() {
        for (int i = 0; i < getAnimalsCount(); i++) {
            if (!getAnimals().get(i).mustDieCheck()) {
                getAnimals().remove(i);
                i--;
            }
        }
    }

    public void killAll() {
        killAllMustDie();
        killAllMustNotDie();
    }
}
