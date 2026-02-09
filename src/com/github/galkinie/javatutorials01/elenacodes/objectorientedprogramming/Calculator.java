/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.objectorientedprogramming;


public class Calculator {
    public int add(int a, int b) {
        return a+b;
    }
    public int sub(int a, int b) {
        return a-b;
    }
    public int multiply(int a, int b) {
        return a*b;
    }
    public int divide(int a, int b) {
        if (b != 0) {
            return a/b;
        } else {
            System.out.println("ERROR = деление на ноль.");
            return 0;
        }
    }
}
