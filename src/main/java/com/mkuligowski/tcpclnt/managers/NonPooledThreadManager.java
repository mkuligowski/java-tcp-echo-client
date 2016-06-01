package com.mkuligowski.tcpclnt.managers;

import com.mkuligowski.tcpclnt.ClientConfiguration;
import com.mkuligowski.tcpclnt.ClientWorker;
import com.mkuligowski.tcpclnt.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NonPooledThreadManager extends ThreadManager {


    private List<FutureTask<Report>> tasks = new ArrayList<>();

    @Override
    public void runWorker(ClientConfiguration configuration, byte[] payload) {

        FutureTask<Report> task = new FutureTask<>(new ClientWorker(configuration,payload));
        Thread thread = new Thread(task);
        tasks.add(task);
        thread.start();

    }

    @Override
    public List<Report> getReports() throws ExecutionException, InterruptedException {
        List<Report> reports = new ArrayList<>();
        for(FutureTask<Report> task: tasks){
            reports.add(task.get());
        }
        return reports;
    }
}
