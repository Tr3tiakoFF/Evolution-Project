package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

class Animal {
    int capacityFood = 1;

    Animal(){

    }
    Animal(Player player){
        this.playerConnect = player;
    }
    Player playerConnect;

    List<Property> properties = new ArrayList<Property>();

//    public int calculateFoodCapacity(){
//        for (int i = 0; i < properties.size(); i++) {
//            Property localProperty = properties.get(i);
//        }
//    }

    @Override
    public String toString() {
        return (playerConnect.toString());
    }
}
