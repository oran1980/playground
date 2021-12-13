package com.playground.playground.multithreading.executorservice.submitrunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> asynchronous_task = executorService.submit( () -> System.out.println("Asynchronous task"));
        boolean finish;
        while (finish = asynchronous_task.isDone() && asynchronous_task.get() == null) {
            System.out.println("Waiting for asynchronous task to end...");
            Thread.sleep(500);
        }
        Thread.sleep(100);
//        if (finish) {
            System.out.println("Asynchronous task ended successfully, bye...");
//        }
        executorService.shutdown();
    }
}
