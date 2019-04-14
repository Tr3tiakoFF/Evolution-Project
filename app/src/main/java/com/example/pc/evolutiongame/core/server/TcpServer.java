package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Acceptable;
import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Processable;
import com.example.pc.evolutiongame.core.Sendable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import static com.example.pc.evolutiongame.Configuration.getServerConfiguration;

public class TcpServer implements Sendable {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 6666;

    private final Set<Socket> clients;
    private final Processable processable;
    private final Acceptable acceptable;
    private final Connectable connectable;
    private final Context context;

    public TcpServer(Context context, Processable processable, Acceptable acceptable, Connectable connectable) {
        this.processable = processable;
        this.acceptable = acceptable;
        this.connectable = connectable;

        this.clients = new HashSet<>();
        this.context = context;
    }

    public void start(final String host, final int port) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Trying to start tcp server");
                    ServerSocket serverSocket = new ServerSocket();
                    InetSocketAddress inetSocketAddress;
                    if (host == null) {
                        inetSocketAddress = new InetSocketAddress(port);
                    } else {
                        inetSocketAddress = new InetSocketAddress(host, port);

                    }

                    System.out.printf("Server is trying to bind to -> %s%n", inetSocketAddress);
                    serverSocket.bind(inetSocketAddress);
                    System.out.printf("Server is binded to -> %s%n", inetSocketAddress);

                    context.setSender(TcpServer.this);
                    connectable.started(context);

                    while (!Thread.interrupted()) {
                        final Socket clientSocket = serverSocket.accept();
                        System.out.printf("Accepted new connection->%s%n", clientSocket.getRemoteSocketAddress());
                        clients.add(clientSocket);
                        acceptable.accept(clientSocket, context);
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
                                        processable.process(context, msg);
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

    public void stop() {
        System.out.println("GreetServerStoped");
    }

    public void sendMessage(Socket clientSocket, String msg) {
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

    @Override
    public void sendMessage(String msg) {
        for (Socket clientSocket : clients) {
            sendMessage(clientSocket, msg);
        }
    }

    public static void main(String[] args) {
        TcpServer server = getServerConfiguration();
        server.start(SERVER_HOST, SERVER_PORT);
    }

    public void start(int port) {
        this.start(null, port);
    }
}