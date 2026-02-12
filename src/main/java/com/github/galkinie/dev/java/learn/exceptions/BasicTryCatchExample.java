package com.github.galkinie.dev.java.learn.exceptions;

public class BasicTryCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing valid index: " + numbers[1]);
            System.out.println("Accessing invalid index: " + numbers[5]);
            // This will throw an exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Array access was out of bounds!");
        }
        System.out.println("Program continues after exception...");

// Multiple catch blocks example
        System.out.println("");
        String[] words = {"123", "abc", "0"};
        for (int i = 0; i < words.length; i++) {
            try {
                String word = words[i];
                int number = Integer.parseInt(word);
                int result = 100 / number;
                System.out.println("Result for '" + word + "': " + result);
            } catch (NumberFormatException e) {
                System.out.println("'" + words[i] + "' is not a valid number!");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        }
    }
}
//Accessing valid index: 2
//Caught exception: Index 5 out of bounds for length 3
//Array access was out of bounds!
//Program continues after exception...
//
//Result for '123': 0
//'abc' is not a valid number!
//Cannot divide by zero!
//
//Process finished with exit code 0