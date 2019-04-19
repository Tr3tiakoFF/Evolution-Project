package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.nsd.NsdManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.TcpServer;

import java.util.HashMap;
import java.util.Map;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;
import static com.example.pc.evolutiongame.Configuration.getServerConfiguration;

public class MainActivity extends Activity {

    private final IntentFilter intentFilter = new IntentFilter();
    private TcpServer server;
    private TcpClient client;

    Button startServer;
    Button startClient;
    Button sendMassage;
    Button stopClient;
    Button stopServer;
    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_test_activity);

        // Indicates a change in the Wi-Fi P2P status.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);

        // Indicates a change in the list of available peers.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);

        // Indicates the state of Wi-Fi P2P connectivity has changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);

        // Indicates this device's details have changed.
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);


        final NsdManager nsdManager = (NsdManager) this.getSystemService(Context.NSD_SERVICE);
        wifiP2pManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        channel = wifiP2pManager.initialize(this, getMainLooper(), null);

        this.server = getServerConfiguration(nsdManager, wifiP2pManager, channel);
        this.client = getClientConfiguration(nsdManager, wifiP2pManager, null);

        startServer = (Button) findViewById(R.id.button_1);
        startClient = (Button) findViewById(R.id.button_2);
        sendMassage = (Button) findViewById(R.id.button_3);
        stopClient = (Button) findViewById(R.id.button_4);
        stopServer = (Button) findViewById(R.id.button_5);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String ip_ = editText2.getText().toString();
//                WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//                String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

                server.start();
            }
        });

        startClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    String ipAddr = editText.getText().toString();
//                    client.createConnection("192.168.1.40", 8988);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                discoverService();
            }
        });

        stopServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    client.stopConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        sendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String massage = editText.getText().toString();
//                try {
//                    client.sendMessage(massage);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                //192.168.43.147
                open();
            }
        });

//        final String serviceName = "Evolution";
//        final String SERVICE_TYPE = "_evolution._tcp";
//        nsdManager.discoverServices(SERVICE_TYPE, NsdManager.PROTOCOL_DNS_SD,
//                new NsdManager.DiscoveryListener() {
//
//                    // Called as soon as service discovery begins.
//                    @Override
//                    public void onDiscoveryStarted(String regType) {
//                        System.out.printf("Service discovery started");
//                    }
//
//                    @Override
//                    public void onServiceFound(NsdServiceInfo service) {
//                        // A service was found! Do something with it.
//                        System.out.printf("Service discovery success" + service);
//                        if (!service.getServiceType().equals(SERVICE_TYPE)) {
//                            // Service type is the string containing the protocol and
//                            // transport layer for this service.
//                            System.out.printf("Unknown Service Type: " + service.getServiceType());
//                        } else if (service.getServiceName().equals(serviceName)) {
//                            // The name of the service tells the user what they'd be
//                            // connecting to. It could be "Bob's Chat App".
//                            System.out.printf("Same machine: " + serviceName);
//                        } else if (service.getServiceName().contains("NsdChat")) {
////                                    nsdManager.resolveService(service, resolveListener);
//                        }
//                    }
//
//                    @Override
//                    public void onServiceLost(NsdServiceInfo service) {
//                        // When the network service is no longer available.
//                        // Internal bookkeeping code goes here.
//                        System.out.printf("service lost: " + service);
//                    }
//
//                    @Override
//                    public void onDiscoveryStopped(String serviceType) {
//                        System.out.printf("Discovery stopped: " + serviceType);
//                    }
//
//                    @Override
//                    public void onStartDiscoveryFailed(String serviceType, int errorCode) {
//                        System.out.printf("Discovery failed: Error code:" + errorCode);
//                        nsdManager.stopServiceDiscovery(this);
//                    }
//
//                    @Override
//                    public void onStopDiscoveryFailed(String serviceType, int errorCode) {
//                        System.out.printf("Discovery failed: Error code:" + errorCode);
//                        nsdManager.stopServiceDiscovery(this);
//                    }
//                });

//
    }

    public void open() {
        Intent intent = new Intent(this, MainBoardActivity.class);
        startActivity(intent);
    }

//    public boolean setHotSpot(String SSID, String passWord) {
//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        Method[] mMethods = wifiManager.getClass().getDeclaredMethods();
//
//        for (Method mMethod : mMethods) {
//
//            if (mMethod.getName().equals("setWifiApEnabled")) {
//                WifiConfiguration wifiConfig = new WifiConfiguration();
//                if (passWord == "") {
//                    wifiConfig.SSID = SSID;
//                    wifiConfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
//                    wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                } else {
//                    wifiConfig.SSID = SSID;
//                    wifiConfig.preSharedKey = passWord;
//                    wifiConfig.hiddenSSID = true;
//                    wifiConfig.status = WifiConfiguration.Status.ENABLED;
//                    wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
//                    wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
//                    wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
//                    wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
//                    wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
//                    wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
//                }
//                try {
//                    mMethod.invoke(wifiManager, netConfig, true);
//                    wifiManager.saveConfiguration();
//                    return true;
//
//                } catch (Exception e) {
//
//                }
//            }
//            return false;
//        }


    @Override
    protected void onResume() {
        super.onResume();
//        receiver = new WiFiDirectBroadcastReceiver(manager, channel, this);
//        registerReceiver(receiver, intentFilter);
    }

    private void discoverService() {
        final Map<String, String> buddies = new HashMap<>();

        WifiP2pManager.DnsSdTxtRecordListener txtListener = new WifiP2pManager.DnsSdTxtRecordListener() {
            @Override
            /* Callback includes:
             * fullDomain: full domain name: e.g "printer._ipp._tcp.local."
             * record: TXT record dta as a map of key/value pairs.
             * device: The device running the advertised service.
             */

            public void onDnsSdTxtRecordAvailable(String fullDomain, Map<String, String> record, WifiP2pDevice device) {
                System.out.printf("DnsSdTxtRecord available -" + record.toString());
                buddies.put(device.deviceAddress, record.get("buddyname"));
            }
        };

        WifiP2pManager.DnsSdServiceResponseListener servListener = new WifiP2pManager.DnsSdServiceResponseListener() {
            @Override
            public void onDnsSdServiceAvailable(String instanceName, String registrationType, WifiP2pDevice resourceType) {

                // Update the device name with the human-friendly version from
                // the DnsTxtRecord, assuming one arrived.
                resourceType.deviceName = buddies
                        .containsKey(resourceType.deviceAddress) ? buddies
                        .get(resourceType.deviceAddress) : resourceType.deviceName;

                // Add to the custom adapter defined specifically for showing
                // wifi devices.
//                WiFiDirectServicesList fragment = (WiFiDirectServicesList) getFragmentManager()
//                        .findFragmentById(R.id.frag_peerlist);
//                WiFiDevicesAdapter adapter = ((WiFiDevicesAdapter) fragment
//                        .getListAdapter());

//                adapter.add(resourceType);
//                adapter.notifyDataSetChanged();
                System.out.printf("onBonjourServiceAvailable " + instanceName);
            }
        };


        WifiP2pDnsSdServiceRequest serviceRequest = WifiP2pDnsSdServiceRequest.newInstance();
        wifiP2pManager.addServiceRequest(channel,
                serviceRequest,
                new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {
                        System.out.printf("Success!");
                    }

                    @Override
                    public void onFailure(int code) {
                        // Command failed.  Check for P2P_UNSUPPORTED, ERROR, or BUSY
                        System.out.printf("Command failed->%d", code);
                    }
                });


        wifiP2pManager.discoverServices(channel, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                // Success!
                System.out.printf("Success!");
            }

            @Override
            public void onFailure(int code) {
                // Command failed.  Check for P2P_UNSUPPORTED, ERROR, or BUSY
                if (code == WifiP2pManager.P2P_UNSUPPORTED) {
                    System.out.printf("P2P isn't supported on this device.");
                }
            }
        });

        wifiP2pManager.setDnsSdResponseListeners(channel, servListener, txtListener);
    }


}
