/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.concurrencyvsparallelism;


public class ThreadDemoUnsafeCounter {
    private int count = 0;

    public void increment(){
        count++;
    }
    public void decrement(){
        count--;
    }

    public void printFinalCounterValue() {
        System.out.println("counter = " + count);
    }

}
