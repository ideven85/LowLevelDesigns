package com.cleo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Executors.newVirtualThreadPerTaskExecutor() function is used in the example below to build
 * the ExecutorService. To complete the work,
 * a new virtual thread is generated and launched when you use ExecutorService.submit(Runnable).
 * A Future instance is returned by this method.
 * It’s important to note that the Future.get() function waits for the thread to complete its task.
 */
public class VirtualThreadExecutors {

    public static void main(String[] args) {

        try(ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()){
            Future<?> future = service.submit(() -> System.out.println("Running First Virtual Executor Service "));
            Thread.Builder builder = Thread.ofVirtual().name("Builder Thread");
            builder.start(() -> System.out.println("Inside builder start "));
            System.out.println("\nCleaning Up");
            future.get();
            System.out.println("Done! ");
        }catch (InterruptedException  | ExecutionException e){
            System.err.println("Oops Something went wrong");
        }
    }
}
