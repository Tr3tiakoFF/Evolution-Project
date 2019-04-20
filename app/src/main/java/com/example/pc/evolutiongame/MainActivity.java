package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.nsd.NsdManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.TcpServer;

import java.util.HashMap;
import java.util.Map;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;
import static com.example.pc.evolutiongame.Configuration.getServerConfiguration;

public class MainActivity extends Activity {

    private final IntentFilter intentFilter = new IntentFilter();
    private TcpServer server;
    private TcpClient client;

    Button startServer;
    Button startClient;
    Button sendMassage;
    Button stopClient;
    Button stopServer;
    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_test_activity);

        // Indicates a change in the Wi-Fi P2P status.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);

        // Indicates a change in the list of available peers.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);

        // Indicates the state of Wi-Fi P2P connectivity has changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);

        // Indicates this device's details have changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);


        final NsdManager nsdManager = (NsdManager) this.getSystemService(Context.NSD_SERVICE);
        wifiP2pManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        channel = wifiP2pManager.initialize(this, getMainLooper(), null);

        this.server = getServerConfiguration(nsdManager, wifiP2pManager, channel);
        this.client = getClientConfiguration(nsdManager, wifiP2pManager, null);

        startServer = (Button) findViewById(R.id.button_1);
        startClient = (Button) findViewById(R.id.button_2);
        sendMassage = (Button) findViewById(R.id.button_3);
        stopClient = (Button) findViewById(R.id.button_4);
        stopServer = (Button) findViewById(R.id.button_5);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server.start();
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        stopServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    client.stopConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        sendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });

    }

    public void open() {
        Intent intent = new Intent(this, MainBoardActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
