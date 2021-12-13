package com.playground.playground.multithreading.spring.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringConfig.class)
public class AsyncAppTest
{

    @Autowired
    public AsyncApp asyncApp = new AsyncApp();

    @Test
    public void testAsyncAnnotationForMethodWithReturnType () throws ExecutionException, InterruptedException {
        System.out.println("Invoking an asynchronous method." + Thread.currentThread().getName());
        Future<String> future = asyncApp.asyncMethodWithStringReturnType();

        while (true) {
            if (future.isDone()) {
                System.out.println("Result from asynchronous process - " + future.get());
                break;
            }
        }
        System.out.println("Continue doing something else. ");
        Thread.sleep(1000);
    }
}