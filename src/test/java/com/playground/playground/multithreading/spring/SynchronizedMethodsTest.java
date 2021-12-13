package com.playground.playground.multithreading.spring;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.SneakyThrows;

public class SynchronizedMethodsTest {

    /*
     * synchronized keyword can be used on different levels: - Instance methods - Static methods - Code
     * blocks
     * 
     * When we use a synchronized block, Java internally uses a 'monitor', also known as monitor lock or
     * intrinsic lock, to provide synchronization. These monitors are bound to an object; therefore, all
     * synchronized blocks od the same object can have only one thread executing them at the same time.
     * 
     * What is a Monitor? ------------------ A monitor is a synchronization mechanism that allows
     * threads to have: - mutual exclusion - only one thread can execute the method at a certain point
     * in time, using locks - cooperation - the ability to make threads wait for certain condition to be
     * met, using met-set
     * 
     * It's called 'Monitor' since it monitor how threads access some resources.
     */

    @SneakyThrows
    @Test
    public void givenMultiThread_whenNonSyncMethod () {
        /*
         * We're using an ExecutorService with a 3-threads pool to execute the calculate() 1000 times. If we
         * executed this serially, the expected output would be 1000, but our multi-threaded execution fails
         * almost every time with an inconsistent actual output:
         * 
         * java.lang.AssertionError: expected:<1000> but was:<965> at org.junit.Assert.fail(Assert.java:88)
         * at org.junit.Assert.failNotEquals(Assert.java:834) ...
         */
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethods summation = new SynchronizedMethods();

        // IntStream.range(0, 1000).forEach(count -> service.submit(summation::synchronizedCalculate));
        IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getNum());
    }

    @Test
    public void givenMultiThread_whenStaticSyncMethod () throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, 1000).forEach(count -> service.submit(SynchronizedMethods::staticSum));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, SynchronizedMethods.staticSum);
    }
}