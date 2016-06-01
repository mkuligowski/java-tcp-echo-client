package com.mkuligowski.tcpclnt;


/**
 * Created by mkuligowski on 31.05.16.
 */
public class ClientConfiguration {

    private int size;
    private String ip;
    private int port;
    private int lifeTime;
    private int threadCount;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static ClientConfiguration getDefaultConfiguration() {
        ClientConfiguration configuration = new ClientConfiguration();
        configuration.setSize(1 * 1024 * 1024);
        configuration.setIp("127.0.0.1");
        configuration.setPort(9000);
        configuration.setThreadCount(10);
        configuration.setLifeTime(6);
        return configuration;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    @Override
    public String toString() {
        return "ClientConfiguration{" +
                "size=" + size +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", lifeTime=" + lifeTime +
                ", threadCount=" + threadCount +
                '}';
    }
}
