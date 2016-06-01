package com.mkuligowski.tcpclnt;

import com.mkuligowski.tcpclnt.managers.ThreadManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TCPEchoClient {


    public static final int PAUSE_MILIS = 150;
    private static final int ITERATIONS_DELAY = 100;

    private final ClientConfiguration clientConfiguration;
    private byte[] payload;

    public TCPEchoClient(ClientConfiguration clientConfiguration){
        this.clientConfiguration = clientConfiguration;
        generateRandomPayload();
    }
    public void start() throws ExecutionException, InterruptedException {
        ThreadManager threadManager = ThreadManager.newThreadManager(clientConfiguration.getThreadCount());

        int counter = 0;
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(clientConfiguration.getLifeTime()); stop>System.nanoTime();) {

            threadManager.runWorker(clientConfiguration, payload);
            if(counter>ITERATIONS_DELAY){
                pause();
                counter = 0;
            }
            counter++;
        }

        try {
            createReportFile(threadManager.getReports());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createReportFile(List<Report> reports) throws IOException {
        FileWriter writer = new FileWriter("report.csv");
        writer.append("latency");
        writer.append(',');
        writer.append("bytesReceived");
        writer.append('\n');


        for(Report r : reports)
            writer.append(String.format("%s,%s%n",r.getLatency(),r.getBytesReceived()));
        writer.flush();
        writer.close();



    }

    private void pause() {
        try {
            Thread.currentThread().sleep(PAUSE_MILIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateRandomPayload() {
        this.payload = new byte[clientConfiguration.getSize()];
        new Random().nextBytes(payload);
    }
}
