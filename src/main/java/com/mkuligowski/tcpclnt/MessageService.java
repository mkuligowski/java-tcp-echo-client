package com.mkuligowski.tcpclnt;


/**
 * Created by mkuligowski on 31.05.16.
 */
public class MessageService {
    private static String PROVIDE_TEXT = "Provide new value or hit enter... \n";

    public static String requestSizeMsg(int size){
        return String.format("Default size of request message is %s bytes. %s",size,PROVIDE_TEXT);
    }
    public static String portMsg(int port){
        return String.format("Default port is %s. %s",port, PROVIDE_TEXT);
    }
    public static String ipMsg(String ip){
        return String.format("Default IP is %s. %s",ip, PROVIDE_TEXT);
    }
    public static String threadsMsg(int size){
        return String.format("Default size of thread pool is %s. " +
                "When value less or equal to zero is provided then new thread is created each time. %s",size,PROVIDE_TEXT);
    }
    public static String lifeTimeMsg(int lifeTime){
        return String.format("Default lifetime of client is %s seconds. %s", lifeTime, PROVIDE_TEXT);
    }



}
