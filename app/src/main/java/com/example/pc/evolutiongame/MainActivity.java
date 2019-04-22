package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.pc.evolutiongame.wifidirect.discovery.R;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;

import static android.os.SystemClock.sleep;

public class MainActivity extends Activity {
    Button startPlayer;
    Button startBot;
    Button startHyb;
    Button faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_start_activity);


        startPlayer = (Button) findViewById(R.id.onlineButton);
        startBot = (Button) findViewById(R.id.offlineButton);
        startHyb = (Button) findViewById(R.id.hybridButton);
        faq = (Button) findViewById(R.id.faq);

        startPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOnlineGame();
            }
        });

        startBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBotGame();
            }
        });

        startHyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHyb();
            }
        });
    }

    public void openOnlineGame() {
        Toast.makeText(this, "In dev :)", Toast.LENGTH_SHORT).show();
    }

    public void openBotGame() {
        Intent intent = new Intent(this, WiFiServiceDiscoveryActivity.class);
        startActivity(intent);
    }

    public void openHyb() {
        Toast.makeText(this, "In dev :)", Toast.LENGTH_SHORT).show();
    }
}
