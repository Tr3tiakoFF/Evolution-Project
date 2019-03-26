package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(final String ip, final int port) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("ConnectionStarted");
                    ;
                    clientSocket = new Socket(ip, port);
//                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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
                if (!clientSocket.isClosed()) {
                    try {
                        out = new PrintWriter(clientSocket.getOutputStream(), true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out.write(msg);
                    System.out.println("MsgSent " + msg);
                }
            }
        }).start();
    }

    public void stopConnection() throws IOException {
        System.out.println("ConnectionStopped");
//        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GreetClient client= new GreetClient();
        client.startConnection("localhost", 6666);
        sleep(1000);
        for (int i = 0; i < 10; i++) {
            client.sendMessage("Hi from all of us " + i);
            sleep(1000);
        }
        sleep(1000);
        client.stopConnection();
    }
}
