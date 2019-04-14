package com.example.pc.evolutiongame.core.control;

import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

public class Game {
    private Action action;
    private Player player;
    private Room data;

    public Game(Action action, Player player) {
        this.action = action;
        this.player = player;
    }

    public Action getAction() {
        return action;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setData(Room data) {
        this.data = data;
    }
}
