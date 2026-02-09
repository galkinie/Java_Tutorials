/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.concurrencyvsparallelism;


public class SumUpExampleApp {
    public static void main(String[] args) throws InterruptedException {

        SumUpExample.runTests();

    }
}
//One thread has taken 4572ms, and the sum is: 2305843008139952128
//Two threads have taken the sum: 2305843008139952128
//And it has taken: 2301ms
