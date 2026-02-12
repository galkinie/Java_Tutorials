/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.methodreferences;


public class SomeClass {
    private String name;

    void set(String t){
        this.name = t;
    }

    void show() {
        System.out.println("Name: " + name);
    }

}