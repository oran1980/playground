package com.playground.playground.multithreading.executorservice.invokeall;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceExample
{
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(()-> "Task 1");
        callables.add(()-> "Task 2");
        callables.add(()-> "Task 3");

        List<Future<String>> results = executorService.invokeAll(callables);
        results.forEach(f-> {
            try
            {
                System.out.println("result: "+f.get());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
