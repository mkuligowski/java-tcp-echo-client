package com.mkuligowski.tcpclnt.managers;

import com.mkuligowski.tcpclnt.ClientConfiguration;

import java.net.Socket;

/**
 * Created by mkuligowski on 31.05.16.
 */
public abstract class ThreadManager {
    public static ThreadManager newThreadManager(int threadCount) {
        return new PooledThreadManager();
    }
    public abstract void runWorker(ClientConfiguration configuration, byte[] payload);
}
