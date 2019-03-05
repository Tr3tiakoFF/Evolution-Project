package com.example.pc.evolutiongame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.evolutiongame.core.GreetClient;
import com.example.pc.evolutiongame.core.GreetServer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startServer = (Button) findViewById(R.id.button_1);
        Button startClient = (Button) findViewById(R.id.button_2);

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    GreetServer greetServer = new GreetServer();
                    greetServer.start(6666);
                }
                catch (Exception e){};
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    GreetClient greetClient = new GreetClient();
                    greetClient.startConnection("localhost", 6666);
                    for (int i = 0; i < 100; i++) {
                        greetClient.sendMessage("Hi from all of us");
                    }
                    greetClient.stopConnection();
                }
                catch (Exception e){};
            }
        });
    }
}
