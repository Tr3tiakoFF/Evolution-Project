package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.model.Room;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 5;

    @Override
    public void started(Context context) {
        System.out.println("Server is started");

        context.setRoom(new Room(NUMBER_PLAYER));
    }
}
