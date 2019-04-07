package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
//    private ServerSocket serverSocket;
//    private Socket clientSocket;
//    private PrintWriter out;
//    private BufferedReader in;
//    private InputStream inputStream;

    public void start(final int port) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Trying to start tcp server");
                    ServerSocket serverSocket = new ServerSocket(port);
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
                                        if (msg != null) {
                                            System.out.printf("Received msg%s from->%s%n", msg, clientSocket.getRemoteSocketAddress());
                                        }
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

//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        String greeting = in.readLine();
//        if ("hello server".equals(greeting)) {
//            out.println("hello client");
//        }
//        else {
//            out.println("unrecognised greeting");
//        }
//        System.out.println(greeting);
    }

    public void stop() throws IOException {
        System.out.println("GreetServerStoped");
//        in.close();
//        out.close();
//        clientSocket.close();
//        serverSocket.close();
    }

    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        server.start(6666);
    }
}