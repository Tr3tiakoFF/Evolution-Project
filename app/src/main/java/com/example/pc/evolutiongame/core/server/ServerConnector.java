package com.example.pc.evolutiongame.core.server;

import android.os.Handler;

import com.example.pc.evolutiongame.GameMode;
import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.model.Room;

import static com.example.pc.evolutiongame.Configuration.getBotConfiguration;
import static com.example.pc.evolutiongame.Configuration.getHumanConfiguration;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 2;
    private Handler handler;

    public ServerConnector(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Server is started");

        context.setRoom(new Room(NUMBER_PLAYER));

        TcpClient player = getPlayer(context.getGameMode());
        player.start(context.getAddress().getHostAddress(), context.getPort());
    }

    private TcpClient getPlayer(String gameMode) {
        if (GameMode.valueOf(gameMode.toUpperCase()) == GameMode.PLAYER) {
            return getHumanConfiguration(handler);
        }
        if (GameMode.valueOf(gameMode.toUpperCase()) == GameMode.BOT) {
            return getBotConfiguration(handler);
        }
        return null;
    }
}
