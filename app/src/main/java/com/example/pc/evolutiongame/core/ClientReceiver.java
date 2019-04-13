package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

public class ClientReceiver implements Processable {

    private Gson gson;

    public ClientReceiver(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void process(String msg) {
        System.out.printf("Received msg->%s%n", msg);

        Room room = gson.fromJson(msg, Room.class);
    }
}
