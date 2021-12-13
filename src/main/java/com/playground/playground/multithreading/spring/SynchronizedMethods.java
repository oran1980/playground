package com.playground.playground.multithreading.spring;

public class SynchronizedMethods {
    private int sum = 0;

    static int staticSum = 0;
    private final Object lock = new Object();

    private static final Object staticLock = new Object();

    public void setSum (int num) {
        this.sum = num;
    }

    public int getNum () {
        return sum;
    }

    public static /* synchronized */ void staticSum () {
        synchronized (staticLock) {
            staticSum = staticSum + 1;
        }

    }

    public void calculate () {
        synchronized (lock) {
            setSum(getNum() + 1);
        }
    }

    public synchronized void synchronizedCalculate () {
        setSum(getNum() + 1);
    }
}
