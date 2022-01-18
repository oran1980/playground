package com.playground.playground.multithreading.executorservice.submitcallable;

import java.util.concurrent.*;

public class ExecutorServiceExample
{
    public static void main (String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> asynchronous_task = executorService.submit(() -> {
            System.out.println("Asynchronous callable");
            return "Callable Result";
        });

        System.out.println("future.get(): "+asynchronous_task.get());
    }
}
