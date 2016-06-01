package com.mkuligowski.tcpclnt.managers;

import com.mkuligowski.tcpclnt.ClientConfiguration;

import java.net.Socket;

/**
 * Created by mkuligowski on 31.05.16.
 */
public class PooledThreadManager extends ThreadManager {

    @Override
    public void runWorker(ClientConfiguration configuration, byte[] payload) {

    }
}
