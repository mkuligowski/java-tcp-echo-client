package com.mkuligowski.tcpclnt;

/**
 * Created by mkuligowski on 01.06.16.
 */
public class Report {
    private long latency;
    private int bytesReceived;

    public Report(long latency, int bytesReceived) {
        this.latency = latency;
        this.bytesReceived = bytesReceived;
    }

    public long getLatency() {
        return latency;
    }

    public int getBytesReceived() {
        return bytesReceived;
    }

    @Override
    public String toString() {
        return "Report{" +
                "latency=" + latency +
                '}';
    }
}
