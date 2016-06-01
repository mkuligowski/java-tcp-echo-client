package com.mkuligowski.tcpclnt.managers;

import com.mkuligowski.tcpclnt.ClientConfiguration;
import com.mkuligowski.tcpclnt.ClientWorker;
import com.mkuligowski.tcpclnt.Report;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PooledThreadManager extends ThreadManager {

    private ExecutorService executorService;
    private List<Future<Report>> reports;
    public PooledThreadManager(int threadCount) {
        this.executorService = Executors.newFixedThreadPool(threadCount);
        this.reports = new ArrayList<>();
    }

    @Override
    public void runWorker(ClientConfiguration configuration, byte[] payload) {
        Future<Report> currentReport =  executorService.submit(new ClientWorker(configuration, payload));
        reports.add(currentReport);
    }

    public List<Report> getReports() throws ExecutionException, InterruptedException {
        List<Report> report = new ArrayList<>();
        for(Future<Report> r : reports) {
            report.add(r.get());
        }
        return report;

    }
}
