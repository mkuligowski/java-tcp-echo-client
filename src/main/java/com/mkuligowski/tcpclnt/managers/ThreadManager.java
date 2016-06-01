package com.mkuligowski.tcpclnt.managers;

import com.mkuligowski.tcpclnt.ClientConfiguration;
import com.mkuligowski.tcpclnt.Report;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mkuligowski on 31.05.16.
 */
public abstract class ThreadManager {
    public static ThreadManager newThreadManager(int threadCount) {

        return threadCount > 0 ?
                new PooledThreadManager(threadCount):
                new NonPooledThreadManager();


    }
    public abstract void runWorker(ClientConfiguration configuration, byte[] payload);
    public abstract List<Report> getReports() throws ExecutionException, InterruptedException;
}
