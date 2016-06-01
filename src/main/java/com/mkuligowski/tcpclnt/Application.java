package com.mkuligowski.tcpclnt;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by mkuligowski on 31.05.16.
 */
public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClientConfiguration configuration = ClientConfiguration.getDefaultConfiguration();
        Scanner reader = new Scanner(System.in);

        printMessage(MessageService.requestSizeMsg(configuration.getSize()));
        String answer = reader.nextLine();
        if(isInteger(answer))
            configuration.setSize(Integer.parseInt(answer));

        printMessage(MessageService.ipMsg(configuration.getIp()));
        answer = reader.nextLine();
        if(!answer.isEmpty())
            configuration.setIp(answer);

        printMessage(MessageService.portMsg(configuration.getPort()));
        answer = reader.nextLine();
        if(isInteger(answer))
            configuration.setPort(Integer.parseInt(answer));

        printMessage(MessageService.lifeTimeMsg(configuration.getLifeTime()));
        answer = reader.nextLine();
        if(isInteger(answer))
            configuration.setLifeTime(Integer.parseInt(answer));

        printMessage(MessageService.threadsMsg(configuration.getThreadCount()));
        answer = reader.nextLine();
        if(isInteger(answer))
            configuration.setThreadCount(Integer.parseInt(answer));


        new TCPEchoClient(configuration).start();

    }

    private static void printMessage(String message) {
        System.out.println(message);
    }


    private static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
