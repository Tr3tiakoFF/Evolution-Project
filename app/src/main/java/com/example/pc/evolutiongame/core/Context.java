package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.model.Room;

public class Context {
    private Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return this.room;
    }
}
