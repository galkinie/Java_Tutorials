/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.concurrencyvsparallelism;


public class ThreadDemo {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.incrementCounter();

    }
    private int counter;

    public void incrementCounter() {
        counter++;
    }

}
