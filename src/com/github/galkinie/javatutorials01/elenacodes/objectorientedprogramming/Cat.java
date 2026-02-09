/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.objectorientedprogramming;


public class Cat extends Animal{
    public Cat(String name) {
        super(name); //вызов конструктора родительского класса
    }

    @Override
    void makeSound() {
        super.makeSound();
        System.out.println(name + " мяукает");
    }
}
