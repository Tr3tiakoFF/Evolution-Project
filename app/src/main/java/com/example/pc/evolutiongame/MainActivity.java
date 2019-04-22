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
    Button startServer;
    Button startClient;
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


        startServer = (Button) findViewById(R.id.onlineButton);
        startClient = (Button) findViewById(R.id.offlineButton);
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
