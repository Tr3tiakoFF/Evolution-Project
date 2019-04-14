package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayersRoomJoiningTest {
    private int numberPlayers=2;

    @Test
    public void roomJoinedPlayers() {
        Room room = new Room(numberPlayers);

        for (int i = 0; i < 4; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertNotNull(room.getPlayers());
        Assert.assertTrue(room.getPlayers().size() >= 2);
        Assert.assertTrue(room.getPlayers().size() <= 6);
    }

    @Test
    public void roomCanJoinedPlayersTest() {
        Room room = new Room(numberPlayers);

        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());

        Assert.assertTrue(room.canAddPlayer());

        room.addPlayer(new Player());

        Assert.assertFalse(room.canAddPlayer());

        room.addPlayer(new Player());
        room.addPlayer(new Player());

        Assert.assertFalse(room.canAddPlayer());
    }
}
