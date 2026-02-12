/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.concurrencyvsparallelism;

/**
 * extends Thread or implements Runnable
 */
public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Hi, I am a method from thread, called: " +
                Thread.currentThread().getName());
    }
}
