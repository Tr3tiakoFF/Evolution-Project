package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 6666;
    private final Processable processable;

    public TcpServer(Processable processable) {
        this.processable = processable;
    }

    public void start(final int port) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Trying to start tcp server");
                    ServerSocket serverSocket = new ServerSocket();
                    serverSocket.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
                    while (!Thread.interrupted()) {
                        final Socket clientSocket = serverSocket.accept();
                        System.out.printf("Accepted new connection->%s%n", clientSocket.getRemoteSocketAddress());

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                    while (!Thread.interrupted()) {
                                        String msg = in.readLine();
                                        if (msg == null) {
                                            System.out.printf("Client is disconnected->%s%n", clientSocket.getRemoteSocketAddress());
                                            break;
                                        }
                                        System.out.printf("Received msg from->%s%n", clientSocket.getRemoteSocketAddress());
                                        processable.process(msg);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop() throws IOException {
        System.out.println("GreetServerStoped");
    }

    public static void main(String[] args) {
        TcpServer server = new TcpServer(new ProcessableImpl());
        server.start(SERVER_PORT);
    }
}