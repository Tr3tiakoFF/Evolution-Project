package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.model.Room;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;
import static com.example.pc.evolutiongame.core.server.TcpServer.SERVER_PORT;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 2;

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Server is started");

        context.setRoom(new Room(NUMBER_PLAYER));

        String hostAddress = context.getAddress().getHostAddress();
        getClientConfiguration(null).createConnection(hostAddress, SERVER_PORT);
    }
}
