package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.TcpServer;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;
import static com.example.pc.evolutiongame.Configuration.getServerConfiguration;

public class MainActivity extends Activity {

    private final TcpServer server;
    TcpClient client;

    Button startServer;
    Button startClient;
    Button sendMassage;
    Button stopClient;
    Button stopServer;

    public MainActivity() {
        this.server = getServerConfiguration();
        this.client = getClientConfiguration(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_test_activity);

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

                String ip_ = editText2.getText().toString();
                WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

                try {
                    server.start("192.168.1.40", 8988);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String ipAddr = editText.getText().toString();
                    client.createConnection("192.168.1.40", 8988);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                100.120.184.236
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
//                String massage = editText.getText().toString();
//                try {
//                    client.sendMessage(massage);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                //192.168.43.147
                open();
            }
        });
    }

    public void open() {
        Intent intent = new Intent(this, MainHandActivity.class);
        startActivity(intent);
    }

//    public boolean setHotSpot(String SSID, String passWord) {
//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        Method[] mMethods = wifiManager.getClass().getDeclaredMethods();
//
//        for (Method mMethod : mMethods) {
//
//            if (mMethod.getName().equals("setWifiApEnabled")) {
//                WifiConfiguration wifiConfig = new WifiConfiguration();
//                if (passWord == "") {
//                    wifiConfig.SSID = SSID;
//                    wifiConfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
//                    wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                } else {
//                    wifiConfig.SSID = SSID;
//                    wifiConfig.preSharedKey = passWord;
//                    wifiConfig.hiddenSSID = true;
//                    wifiConfig.status = WifiConfiguration.Status.ENABLED;
//                    wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
//                    wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
//                    wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
//                    wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
//                    wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
//                }
//                try {
//                    mMethod.invoke(wifiManager, netConfig, true);
//                    wifiManager.saveConfiguration();
//                    return true;
//
//                } catch (Exception e) {
//
//                }
//            }
//            return false;
//        }
}
