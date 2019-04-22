package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Acceptable;
import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.Processor;
import com.example.pc.evolutiongame.core.Sendable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashSet;
import java.util.Set;

import static com.example.pc.evolutiongame.Configuration.getServerConfiguration;

public class TcpServer implements Sendable {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 6666;

    private final Set<Socket> clients;
    private final Processor processor;
    private final Acceptable acceptable;
    private final Connectable connectable;
    private final EvolutionContext context;

    public TcpServer(EvolutionContext context, Processor processor, Acceptable acceptable, Connectable connectable) {
        this.processor = processor;
        this.acceptable = acceptable;
        this.connectable = connectable;

        this.clients = new HashSet<>();
        this.context = context;
    }

    public void start() {
        this.start(null, 0);
    }

    public void start(int port) {
        this.start(null, port);
    }

    public void start(final String host, final int port) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Trying to start tcp server");
                    ServerSocket serverSocket = new ServerSocket(port);
                    SocketAddress inetSocketAddress = serverSocket.getLocalSocketAddress();
                    System.out.printf("Server is binded to -> %s%n", inetSocketAddress);

                    context.setAddress(serverSocket.getInetAddress());
                    context.setPort(serverSocket.getLocalPort());
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
                                        processor.process(context, msg);
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
            System.out.printf("Message->%s will send to client->%s%n", msg, clientSocket.getRemoteSocketAddress());
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
        TcpServer server = getServerConfiguration(null, null);
        server.start(SERVER_HOST, SERVER_PORT);
    }
}