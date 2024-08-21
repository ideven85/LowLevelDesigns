package com.cleo.socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerVirtualThread {
    private static final int PORT = 999;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server Started listening on  " + PORT);
            while(true){
                Socket client = serverSocket.accept();
                // Accept incoming connections
                // Start a service thread
                Thread.ofVirtual().start(() -> {
                    try(PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                        String input;
                        while((input=reader.readLine())!=null){
                            System.out.println(" Received: " + input);
                            out.println("Echo Server: " + input);
                            out.flush();
                        }

                    }catch (IOException ie){
                        System.out.print("Exception: " + ie.getMessage());
                    }finally {
                        try{
                            client.close();
                        }catch (IOException ie){
                            ie.printStackTrace();
                        }
                    }
                });
            }

        }catch (IOException ie){
            System.out.print("OOPS some error " + ie.getMessage());
        }
    }
}
