package com.cleo;

public class Main {
    public static void main(String[] args) throws InterruptedException{
       Thread t =  Thread.ofVirtual().start(()->
                System.out.println("My first virtual thread "));

        System.out.println("Hello world!");
        Thread t1 = new Thread("Physical");
        t1.start();
        System.out.print(t1.getName()+" ");
        t.join();
        t1.join();
    }
}