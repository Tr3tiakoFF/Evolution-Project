package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.TcpClient;
import com.example.pc.evolutiongame.core.TcpServer;

public class MainActivity extends Activity {

    TcpServer tcpServer = new TcpServer();
    TcpClient tcpClient = new TcpClient();

    Button startServer;
    Button startClient;
    Button sendMassage;
    Button stopClient;
    Button stopServer;

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
                try
                {
                    tcpServer.start(6666);
                    open();
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
                    tcpClient.startConnection("localhost", 6666);
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
                    tcpServer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tcpClient.stopConnection();
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
                    tcpClient.sendMessage(massage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void open() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
