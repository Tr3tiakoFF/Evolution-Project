package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.TcpClient;
import com.example.pc.evolutiongame.core.TcpServer;

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
        this.client = getClientConfiguration();
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

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

                try {
                    server.start(6666);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    client.createConnection("localhost", 6666);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//                String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
//                Toast.makeText(getApplicationContext(),ip,Toast.LENGTH_LONG).show();
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
                String massage = editText.getText().toString();
                try {
                    client.sendMessage(massage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void open() {
        Intent intent = new Intent(this, MainBoardActivity.class);
        startActivity(intent);
    }
}
