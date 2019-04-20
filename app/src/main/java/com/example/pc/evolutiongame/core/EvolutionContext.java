package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.model.Room;

public class EvolutionContext {
    private String id;
    private Room room;
    private Sendable sender;
    private int port;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return this.room;
    }

    public Sendable getSender() {
        return sender;
    }

    public void setSender(Sendable sender) {
        this.sender = sender;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
