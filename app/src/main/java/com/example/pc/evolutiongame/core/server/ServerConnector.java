package com.example.pc.evolutiongame.core.server;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.model.Room;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 5;

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Server is started");

        registerService(context.getPort(), context.getNsdManager());

        context.setRoom(new Room(NUMBER_PLAYER));
    }

    public void registerService(int port, NsdManager nsdManager) {
        NsdServiceInfo serviceInfo = new NsdServiceInfo();
        serviceInfo.setServiceName("Evolution");
        serviceInfo.setServiceType("_evolution._tcp");
        serviceInfo.setPort(port);

        nsdManager.registerService(serviceInfo, NsdManager.PROTOCOL_DNS_SD,
                new NsdManager.RegistrationListener() {
                    @Override
                    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                        // Save the service name. Android may have changed it in order to
                        // resolve a conflict, so update the name you initially requested
                        // with the name Android actually used.
                        System.out.printf("Service is registered->%s", nsdServiceInfo);
                    }

                    @Override
                    public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                        // Registration failed! Put debugging code here to determine why.
                        System.out.printf("Registration failed with errorCode->%d", errorCode);
                    }

                    @Override
                    public void onServiceUnregistered(NsdServiceInfo arg0) {
                        // Service has been unregistered. This only happens when you call
                        // NsdManager.unregisterService() and pass in this listener.
                    }

                    @Override
                    public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                        // Unregistration failed. Put debugging code here to determine why.
                    }
                });
    }
}
