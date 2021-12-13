package com.playground.playground.multithreading.spring.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App2 {
    @Autowired
    AsyncApp app;

    public void runApp () throws ExecutionException, InterruptedException {
        Future<String> future = app.asyncMethodWithStringReturnType();
        if (future.isDone()) {
            System.out.println(future.get());
        }
    }
}
