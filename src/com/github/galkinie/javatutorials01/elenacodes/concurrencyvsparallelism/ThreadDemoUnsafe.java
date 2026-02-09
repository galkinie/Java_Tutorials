/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.concurrencyvsparallelism;


import java.util.Random;

public class ThreadDemoUnsafe {
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        ThreadDemoUnsafeCounter badCounter = new ThreadDemoUnsafeCounter();
        //Create counter, that will increment the value of (count)
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    badCounter.increment();
                    sleepRandomlyLessThan10Seconds();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    badCounter.decrement();
                    sleepRandomlyLessThan10Seconds();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        badCounter.printFinalCounterValue();

    }

    public static void sleepRandomlyLessThan10Seconds(){
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException("An error in method sleepRandomlyLessThan10Seconds(): " + e);
        }
    }

}
//counter = 0
//counter = 0
//counter = 0
//counter = 0
//counter = -1
//counter = 1
//counter = 0
