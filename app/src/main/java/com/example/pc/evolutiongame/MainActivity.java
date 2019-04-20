package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.evolutiongame.wifidirect.discovery.R;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;

public class MainActivity extends Activity {
    Button startServer;
    Button startClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);

        startServer = (Button) findViewById(R.id.serverButton);
        startClient = (Button) findViewById(R.id.clientButton);


        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServer();
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClient();
            }
        });
    }

    public void openServer() {
        Intent intent = new Intent(this, WiFiServiceDiscoveryActivity.class);
        startActivity(intent);
    }

    public void openClient() {
        Intent intent = new Intent(this, WiFiServiceDiscoveryActivity.class);
        startActivity(intent);
    }
}
