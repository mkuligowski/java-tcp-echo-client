package com.mkuligowski.tcpclnt;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

public class ClientWorker implements Callable<Report> {


    private final ClientConfiguration configuration;
    private final byte[] payload;

    public ClientWorker(ClientConfiguration configuration, byte[] payload) {
        this.configuration = configuration;
        this.payload = payload;
    }

    @Override
    public Report call() throws Exception {
        long startTime = System.currentTimeMillis();
        Report report = null;
        try (Socket echoSocket = new Socket(configuration.getIp(), configuration.getPort());
             OutputStream out = echoSocket.getOutputStream();
             InputStream socketINStream = echoSocket.getInputStream();
        ){
            out.write(payload);
            echoSocket.shutdownOutput();

            byte[] bytes= IOUtils.toByteArray(socketINStream);
            report = new Report(System.currentTimeMillis() - startTime, bytes.length);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return report;
    }
}
