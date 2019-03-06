package com.example.pc.evolutiongame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.GreetClient;
import com.example.pc.evolutiongame.core.GreetServer;

public class MainActivity extends Activity {

    GreetServer greetServer = new GreetServer();
    GreetClient greetClient = new GreetClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startServer = (Button) findViewById(R.id.button_1);
        Button startClient = (Button) findViewById(R.id.button_2);
        Button sendMassage = (Button) findViewById(R.id.button_3);
        Button stopClient = (Button) findViewById(R.id.button_4);
        Button stopServer = (Button) findViewById(R.id.button_5);

        final EditText editText = (EditText) findViewById(R.id.editText);

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    greetServer.start(6666);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    greetClient.startConnection("localhost", 6666);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
            }
        });

        stopServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    greetServer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    greetClient.stopConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        sendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String massage = editText.toString();
                try {
                    greetClient.sendMessage(massage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
