package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.model.Room;

public class ServerConnectingService implements Connectable {
    @Override
    public void started(Context context) {
        System.out.println("Server is started");

        context.setRoom(new Room());
    }
}
