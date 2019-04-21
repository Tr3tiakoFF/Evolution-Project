package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.evolutiongame.wifidirect.discovery.R;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;

import static android.os.SystemClock.sleep;

public class MainActivity extends Activity {
    Button startServer;
    Button startClient;
    Button startHyb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);


        startServer = (Button) findViewById(R.id.onlineButton);
        startClient = (Button) findViewById(R.id.offlineButton);
        startHyb = (Button) findViewById(R.id.hybridButton);


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

        startHyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHyb();
            }
        });

        sleep(750);
    }

    public void openServer() {
        Intent intent = new Intent(this, WiFiServiceDiscoveryActivity.class);
        startActivity(intent);
    }

    public void openClient() {
        Toast.makeText(this, "In dev :)", Toast.LENGTH_SHORT).show();
    }

    public void openHyb() {
        Toast.makeText(this, "In dev :)", Toast.LENGTH_SHORT).show();
    }
}
