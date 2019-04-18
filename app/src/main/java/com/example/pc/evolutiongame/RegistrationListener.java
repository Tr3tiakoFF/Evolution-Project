package com.example.pc.evolutiongame;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

public class RegistrationListener implements NsdManager.RegistrationListener {
    @Override
    public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
        // Save the service name. Android may have changed it in order to
        // resolve a conflict, so update the name you initially requested
        // with the name Android actually used.
        String serviceName = NsdServiceInfo.getServiceName();
    }

    @Override
    public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
        // Registration failed! Put debugging code here to determine why.
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
}
