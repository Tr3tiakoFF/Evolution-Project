package com.example.pc.evolutiongame.core.control;

import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

public class Game {
    private Action action;
    private Player player;
    private Room room;

    public Game(Action action, Player player) {
        this.action = action;
        this.player = player;
    }

    public Game(Action action, Room room) {
        this.action = action;
        this.room = room;
    }

    public Action getAction() {
        return action;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getRoom() {
        return room;
    }
}
