package com.playground.playground.multithreading.executorservice.invokeAny;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(()-> "Task 1");
        callables.add(()-> "Task 2");
        callables.add(()-> "Task 3");

        String result = executorService.invokeAny(callables);
        System.out.println("result ="+result);
        executorService.shutdown();
    }
}
