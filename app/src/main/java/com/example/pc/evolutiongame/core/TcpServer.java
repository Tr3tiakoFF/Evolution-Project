package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class TcpServer {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 6666;

    private final Set<Socket> clients;
    private final Processable processable;
    private final Acceptable acceptable;

    public TcpServer(Processable processable, Acceptable acceptable) {
        this.processable = processable;
        this.acceptable = acceptable;
        this.clients = new HashSet<>();
    }

    public void start() {
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
                        clients.add(clientSocket);
                        acceptable.accept(TcpServer.this, clientSocket);

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

    public void sendMsg(Socket clientSocket, String msg) {
        if (msg == null) {
            System.out.println("Message is null. Nothing to send.");
            return;
        }
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.printf("Msg->%s will send to client->%s%n", msg, clientSocket.getRemoteSocketAddress());
            out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        for (Socket clientSocket : clients) {
            sendMsg(clientSocket, msg);
        }
    }

    public static void main(String[] args) {
        TcpServer server = new TcpServer(new ProcessableImpl(), new AcceptableImpl());
        server.start();
    }
}