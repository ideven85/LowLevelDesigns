package com.cleo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnderstandingVirtualThreads {
    public static void main(String[] args) {

        try {
            Thread.Builder builder = Thread.ofVirtual().name("Deven");
            Runnable r = () -> {
                System.out.println("Inside Runnable ");
            };
            //ExecutorService service = Executors.newFixedThreadPool(5);

            Thread t = builder.start(r);
            t.join();
            System.out.print(t.getName() + " ");

        }catch (InterruptedException ie){
            System.err.println("Resource was not available before being called "+ie.getMessage());
        }
    }
}
