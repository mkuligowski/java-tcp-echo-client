package com.mkuligowski.tcpclnt;

import com.mkuligowski.tcpclnt.managers.ThreadManager;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkuligowski on 31.05.16.
 */
public class TCPEchoClient {


    private final ClientConfiguration clientConfiguration;
    private byte[] payload;

    public TCPEchoClient(ClientConfiguration clientConfiguration){
        this.clientConfiguration = clientConfiguration;
        this.payload = new byte[clientConfiguration.getSize()];
        new Random().nextBytes(payload);
    }

    public void start(){
        ThreadManager threadManager = ThreadManager.newThreadManager(clientConfiguration.getThreadCount());


        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(clientConfiguration.getLifeTime()); stop>System.nanoTime();) {
            threadManager.runWorker(clientConfiguration, payload);
        }

    }

}
