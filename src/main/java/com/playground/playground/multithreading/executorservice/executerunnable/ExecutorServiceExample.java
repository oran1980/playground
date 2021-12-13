package com.playground.playground.multithreading.executorservice.executerunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main (String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute( () -> {
            System.out.println("Asynchronous task");
        });

        executorService.shutdown();
    }
}
