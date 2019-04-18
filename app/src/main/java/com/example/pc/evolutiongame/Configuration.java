package com.example.pc.evolutiongame;

import android.net.nsd.NsdManager;
import android.net.wifi.p2p.WifiP2pManager;

import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.client.ClientReceiver;
import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.AcceptableImpl;
import com.example.pc.evolutiongame.core.server.ServerConnector;
import com.example.pc.evolutiongame.core.server.ServerReceiver;
import com.example.pc.evolutiongame.core.server.TcpServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {

    public static TcpServer getServerConfiguration(NsdManager nsdManager, WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();
        context.setNsdManager(nsdManager);
        context.setWifiP2pManager(wifiP2pManager);
        context.setChannel(channel);

        return new TcpServer(context, new ServerReceiver(gson), new AcceptableImpl(gson), new ServerConnector());
    }

    public static TcpClient getClientConfiguration(NsdManager nsdManager, WifiP2pManager wifiP2pManager, MainBoardActivity mainBoardActivity) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();
        context.setNsdManager(nsdManager);
        context.setWifiP2pManager(wifiP2pManager);

        return new TcpClient(context, new ClientReceiver(mainBoardActivity, gson));
    }
}
