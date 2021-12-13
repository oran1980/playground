package com.playground.playground.multithreading.spring.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncApp {
    // The method must be public so that it can be proxied. Self-invocation (calling the async method
    // from within same class) won't work, since it bypass the proxy and call the underlying method
    // directly

    // @Async("asyncExecutor")
    // public <T> Future<T> execute (Supplier<T> supplier) {
    // return new AsyncResult<>(supplier.get());
    // }

     @Async
    public Future<String> asyncMethodWithStringReturnType () throws ExecutionException, InterruptedException {

//         ExecutorService service = Executors.newCachedThreadPool();

             System.out.println("Execute method asynchronously." + Thread.currentThread().getName());
             try {
                 Thread.sleep(5000);
                 return new AsyncResult<>("Hello world");
             }
             catch (InterruptedException e) {
                 e.printStackTrace();
             }
             return null;


//         System.out.println("Finished: " + future.get() + "-" + Thread.currentThread().getName());
         // System.out.println("Execute method asynchronously." + Thread.currentThread().getName());
         // try {
         // Thread.sleep(5000);
         // return new AsyncResult<>("Hello world");
         // }
         // catch (InterruptedException e) {
         // e.printStackTrace();
         // }
         // return null;
//         return future;

//        ExecutorService service = Executors.newCachedThreadPool();
//        Future<String> future = service.submit( () -> {
//            System.out.println("Execute method asynchronously." + Thread.currentThread().getName());
//            try {
//                Thread.sleep(5000);
//                return "Hello world";
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        });
//        service.shutdown();
//        System.out.println("Finished: " + future.get() + "-" + Thread.currentThread().getName());
//        // System.out.println("Execute method asynchronously." + Thread.currentThread().getName());
//        // try {
//        // Thread.sleep(5000);
//        // return new AsyncResult<>("Hello world");
//        // }
//        // catch (InterruptedException e) {
//        // e.printStackTrace();
//        // }
//        // return null;
//        return future;
    }
}
