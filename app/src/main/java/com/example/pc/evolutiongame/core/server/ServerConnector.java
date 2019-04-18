package com.example.pc.evolutiongame.core.server;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.model.Room;

import java.util.HashMap;
import java.util.Map;

import static com.example.pc.evolutiongame.core.server.TcpServer.SERVER_PORT;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 5;

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Server is started");

//        registerService(context.getPort(), context.getNsdManager());
        startRegistration(context.getPort(), context.getWifiP2pManager(), context.getChannel());

        context.setRoom(new Room(NUMBER_PLAYER));
    }

    private void startRegistration(int port, WifiP2pManager manager, WifiP2pManager.Channel channel) {
        //  Create a string map containing information about your service.
        Map record = new HashMap();
        record.put("listenport", String.valueOf(port));
        record.put("buddyname", "John Doe" + (int) (Math.random() * 1000));
        record.put("available", "visible");

        // Service information.  Pass it an instance name, service type
        // _protocol._transportlayer , and the map containing
        // information other devices will want once they connect to this one.
        final WifiP2pDnsSdServiceInfo serviceInfo = WifiP2pDnsSdServiceInfo.newInstance("_evolution", "_evolution._tcp", record);

        // Add the local service, sending the service info, network channel,
        // and listener that will be used to indicate success or failure of
        // the request.
        manager.addLocalService(channel, serviceInfo, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                // Command successful! Code isn't necessarily needed here,
                // Unless you want to update the UI or add logging statements.
                System.out.printf("Command successful");
            }

            @Override
            public void onFailure(int arg0) {
                // Command failed.  Check for P2P_UNSUPPORTED, ERROR, or BUSY
                System.out.printf("Command failed.  Check for P2P_UNSUPPORTED, ERROR, or BUSY");
            }
        });
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
