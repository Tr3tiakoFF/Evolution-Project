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

//        faq.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                {
//                    File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/brouchure.pdf");
//                    if (file.exists()) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        Uri uri = Uri.fromFile(file);
//                        intent.setDataAndType(uri, "application/pdf");
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                        try {
//                            startActivity(intent);
//                        } catch (ActivityNotFoundException e) {
//                            Toast.makeText(MainActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//            }
//        });

        startPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOnlineGame();
            }
        });

        startBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOnlineGame();
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
