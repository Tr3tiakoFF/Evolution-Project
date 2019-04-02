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

    private void killAnimal(int killerNum, int killerPlayerNum, int prayNum, int prayPlayerNum, Room room) {
        prayNum = room.calculateAnimalNum(prayNum, prayPlayerNum);
        killerNum = room.calculateAnimalNum(killerNum, killerPlayerNum);
        if (canKill(killerNum, prayNum)) {
            getAnimals().remove(prayNum);
            getAnimals().get(killerNum).getFood(2);
        }
    }

    private void stillFood(int stillerNum, int stillerPlayerNum, int prayNum, int prayPlayerNum, Room room) {
        prayNum = room.calculateAnimalNum(prayNum, prayPlayerNum);
        stillerNum = room.calculateAnimalNum(stillerNum, prayPlayerNum);
        if (getAnimals().get(prayNum).capacityFood >= 1) {
            getAnimals().get(prayNum).getFood(-1);
            getAnimals().get(stillerNum).getFood(1);
        }
    }

    private boolean canKill(int killerNum, int prayNum) {
        Animal killer = getAnimals().get(killerNum);
        Animal pray = getAnimals().get(prayNum);
        if (pray.got(LowLevelAnimalProperty.SWIMMING)) {
            if (killer.got(LowLevelAnimalProperty.SWIMMING)) {
            } else {
                return false;
            }
        }
        if (killer.got(LowLevelAnimalProperty.SWIMMING)) {
            if (pray.got(LowLevelAnimalProperty.SWIMMING)) {
            } else {
                return false;
            }
        }
        if (pray.got(LowLevelAnimalProperty.CAMOUFLAGE)) {
            if (killer.got(LowLevelAnimalProperty.SHARP_VISION)) {
            } else {
                return false;
            }
        }
        if (pray.got(LowLevelAnimalProperty.HIGH_BODY_WEIGHT)) {
            if (killer.got(LowLevelAnimalProperty.HIGH_BODY_WEIGHT)) {
            } else {
                return false;
            }
        }
        if (killer.got(LowLevelAnimalProperty.HIGH_BODY_WEIGHT)) {
            if (pray.got(LowLevelAnimalProperty.HIGH_BODY_WEIGHT)) {
            } else {
                return false;
            }
        }
        if (pray.got(LowLevelAnimalProperty.POISONOUS)) {
            getAnimals().get(killerNum).mustDie = true;
        }
        return true;
    }
}
