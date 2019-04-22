package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.pc.evolutiongame.wifidirect.discovery.R;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;

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
                openBotGame(GameMode.PLAYER);
            }
        });

        startBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBotGame(GameMode.BOT);
            }
        });

        startHyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openBotGame(GameMode.HYBRID);
            }
        });
    }

    public void openBotGame(GameMode gameMode) {
        Intent intent = new Intent(this, WiFiServiceDiscoveryActivity.class);
        intent.putExtra("gameMode", gameMode.toString());
        startActivity(intent);
    }
}
