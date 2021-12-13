package com.playground.playground.multithreading.volatiekeyword;

import java.util.Scanner;

class Processor extends Thread {
    //TODO the 'volatile' keyword prevents threads of caching variables where they are not changed within that thread
    private volatile  boolean running = true;

    public void run () {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown () {
        running = false;

    }
}

public class VolatileKeyword
{
    public static void main (String[] args) {
        Processor proc1 = new Processor();
        proc1.start();
        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();





    }
}
