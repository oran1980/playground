package com.playground.playground.multithreading.callableandfuture;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import com.google.common.collect.Lists;

import lombok.SneakyThrows;

public class CallableAndFuture {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        Future<Integer> future = executorService.submit( () -> {
//            Random random = new Random();
//            int duration = random.nextInt(4000);
//            if (duration > 2000) {
//                throw new IOException("Sleeping for too long");
//            }
//            System.out.println("starting...");
//            try {
//                Thread.sleep(duration);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Finished.");
//            return duration;
//        });
//        executorService.shutdown();
//        System.out.println("Result is: " + future.get());
//
//        List<Integer> values = new LinkedList<>();
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            int num = random.nextInt(1000);
//            values.add(num);
//            System.out.println("Generated num: " + num);
//        }
//        Lists.partition(values, 50).forEach(bulk -> executorService.submit( () -> printBulk(bulk)));

        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        List<Callable<Object>> myList = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
            myList.add(Executors.callable(new CallableTask(new DummyObject(i))));
        }

        List<Future<Object>> futures = executorService1.invokeAll(myList);
        executorService1.awaitTermination(50,TimeUnit.MILLISECONDS);
        futures.forEach(f-> System.out.println(f.isDone()));

    }

    static class DummyObject {
        int id;

        public DummyObject (int id) {
            this.id = id;
        }

        public int getId () {
            return id;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public void printObjectId () throws InterruptedException {
            System.out.println("I'm object "+id+"and I'm going to sleep now ("+dateFormat.format(new Date()) +") ...");
            Thread.sleep(1000);
            System.out.println("I'm object "+id+" and I'm a wake now! ("+dateFormat.format(new Date())+") Bye...");
        }
    }

    static class CallableTask implements Runnable {
        DummyObject object;

        public CallableTask (DummyObject o) {
            this.object = o;
        }

        @SneakyThrows
        public void run () {
            object.printObjectId();
        }
    }

    public static synchronized void printBulk (List<Integer> bulk) {
        System.out.println("Starting new bulk:");
        bulk.forEach(System.out::println);
        System.out.println("");
    }
}
