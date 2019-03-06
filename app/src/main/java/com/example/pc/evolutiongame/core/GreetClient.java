package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(final String ip, final int port) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket = new Socket(ip, port);
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(final String msg) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                out.println(msg);
            }
        }).start();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        GreetClient client= new GreetClient();
        client.startConnection("localhost", 6666);
        for (int i = 0; i < 100; i++) {
            client.sendMessage("Hi from all of us");
        }
        client.stopConnection();
    }
}
