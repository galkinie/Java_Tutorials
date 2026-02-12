/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.methodreferences;


public class Launcher {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();

        //interface variables delta and links to method set
        /**
         * тип, количество аргументов, тип результата
         */
        Delta delta = someClass::set; // String(t) -> myClass.set(t);

        Zulu zulu = someClass::show; // () -> myClass.show();

        delta.apply("Red");
        someClass.show();
        //Name: Red

        someClass.set("Yellow");
        zulu.display();
        //Name: Yellow

        someClass = new SomeClass();
        someClass.set("Green");
        zulu.display();
        //Name: Yellow

        delta.apply("Blue");
        someClass.show();
        //Name: Green
        zulu.display();
        //Name: Blue



    }
}
