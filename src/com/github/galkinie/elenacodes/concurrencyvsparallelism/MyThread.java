/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.concurrencyvsparallelism;

/**
 * extends Thread or implements Runnable
 */
public class MyThread extends Thread {

    public static void main() {
        new MyThread().start();
        //Hello! Я из thread: Thread-0

    }

    @Override
    public void run() {
        System.out.println("Hello! Я из thread: " + Thread.currentThread().getName());
    }
}
