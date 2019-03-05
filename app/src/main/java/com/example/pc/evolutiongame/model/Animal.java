package com.example.pc.evolutiongame.model;

import java.util.ArrayList;
import java.util.List;

class Animal {
    Animal(){

    }
    Animal(Player player){
        this.playerConnect = player;
    }
    Player playerConnect;

    List<Property> properties = new ArrayList<Property>();

    @Override
    public String toString() {
        return (playerConnect.toString());
    }
}
