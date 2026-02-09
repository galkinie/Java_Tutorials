/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.concurrencyvsparallelism;


public class SumUpExample {

    private long startRange;
    private long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public static void runTests() throws InterruptedException {
        oneThread();
        twoThreads();
    }

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    /**
     * Find sum of diapason (startRange, endRange)
     */
    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    public static void oneThread() {
        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("One thread has taken " +
                (end - start) + "ms, and the sum is: " + s.counter);
    }

    public static void twoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM/2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM/2), MAX_NUM);

        Thread t1 = new Thread(() -> s1.add());
        Thread t2 = new Thread(s2::add);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();

        System.out.println("Two threads have taken the sum: " + finalCount + "\n" +
                "And it has taken: " + (end - start) + "ms");
        }

}
//One thread has taken 4572ms, and the sum is: 2305843008139952128
//Two threads have taken the sum: 2305843008139952128
//And it has taken: 2301ms
