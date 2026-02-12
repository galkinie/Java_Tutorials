/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.methodreferences;


public class RemoteControl {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.turnOn();
        Runnable turnOnMethod = myTV::turnOn;
        turnOnMethod.run();


    }
}
