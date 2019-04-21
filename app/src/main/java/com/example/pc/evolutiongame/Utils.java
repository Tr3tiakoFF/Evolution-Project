package com.example.pc.evolutiongame;

import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

import java.util.Random;

public class Utils {
    private static Random rand = new Random(System.currentTimeMillis());

    public static String getNewId() {
        return String.format("%04X", rand.nextInt());
    }

    public static Player getPlayer(String playerId, Room room) {
        for (Player player : room.getPlayers()) {
            if (playerId.equals(player.getId())) {
                return player;
            }
        }
        return null;
    }
}
