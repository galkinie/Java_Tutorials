/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.concurrencyvsparallelism;


public class ConcurrencyVsParallelismApp {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

//        thread1.setDaemon();

        thread1.run();
        thread2.start();
        thread3.start();
        //Hi, I am a method from thread, called: main
        //Hi, I am a method from thread, called: Thread-1
        //Hi, I am a method from thread, called: Thread-2


    }
}
