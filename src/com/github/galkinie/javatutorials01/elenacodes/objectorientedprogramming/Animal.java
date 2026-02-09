/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.objectorientedprogramming;


public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    void makeSound() {
        System.out.println(name + " издаёт звук.");
    }
    void move() {
        System.out.println(name + " moves.");
    }
}
