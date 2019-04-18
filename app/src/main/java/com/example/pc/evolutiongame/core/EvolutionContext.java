package com.example.pc.evolutiongame.core;

import android.net.nsd.NsdManager;
import android.net.wifi.p2p.WifiP2pManager;

import com.example.pc.evolutiongame.model.Room;

public class EvolutionContext {
    private String id;
    private Room room;
    private Sendable sender;
    private int port;
    private NsdManager nsdManager;
    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return this.room;
    }

    public Sendable getSender() {
        return sender;
    }

    public void setSender(Sendable sender) {
        this.sender = sender;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setNsdManager(NsdManager nsdManager) {
        this.nsdManager = nsdManager;
    }

    public NsdManager getNsdManager() {
        return nsdManager;
    }

    public void setWifiP2pManager(WifiP2pManager wifiP2pManager) {

        this.wifiP2pManager = wifiP2pManager;
    }

    public WifiP2pManager getWifiP2pManager() {
        return wifiP2pManager;
    }

    public void setChannel(WifiP2pManager.Channel channel) {
        this.channel = channel;
    }

    public WifiP2pManager.Channel getChannel() {
        return channel;
    }
}
