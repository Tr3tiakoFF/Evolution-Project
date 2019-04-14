package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Processable;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

import static com.example.pc.evolutiongame.core.control.Action.REFRESH_STATE;

public class ServerReceiver implements Processable {

    private final Gson gson;

    public ServerReceiver(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void process(Context context, String msg) {
        System.out.printf("Received msg->%s%n", msg);
        if (msg == null) {
            return;
        }
        Game game = gson.fromJson(msg, Game.class);

        if (REFRESH_STATE == game.getAction()) {
            Room room = game.getRoom();
            if (room.allPlayersPass()) {
                System.out.println("All players pass");
                System.out.printf("All animals->%s%n", room.getAnimalsList());
                return;
            }

            room.setNextPlayer();

            context.setRoom(room);
            context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, room)));
        }

    }
}
