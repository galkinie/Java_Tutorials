package com.github.galkinie.dev.java.learn.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BasicTryCatchFinallyExample {

    /**
     * try-with-resources statement in these situations automatically
     * releases system resources when no longer needed
     */

    public static void main(String[] args) {
        // Basic try-catch-finally
        System.out.println("=== Try-Catch-Finally Example ===");
        List<String> items = new ArrayList<>();
        items.add("first");
        items.add("second");

        try {
            System.out.println("In try block - accessing valid index: " + items.get(0));
            System.out.println("In try block - accessing invalid index: " + items.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException!");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes!");
            System.out.println("List size is: " + items.size());
            System.out.println("Cleaning up resources here...");
        }

// Finally executes even without exception
        System.out.println("");
        System.out.println("=== Finally Without Exception ===");
        try {
            System.out.println("Normal operation - no exceptions thrown");
            int result = 10 + 20;
            System.out.println("Result: " + result);
        } finally {
            System.out.println("Finally block runs even when no exception occurs!");
        }

        System.out.println("");
        System.out.println("Program execution completed.");
    }

}
//=== Try-Catch-Finally Example ===
//In try block - accessing valid index: first
//Caught IndexOutOfBoundsException!
//Exception message: Index 10 out of bounds for length 2
//Finally block always executes!
//List size is: 2
//Cleaning up resources here...
//
//=== Finally Without Exception ===
//Normal operation - no exceptions thrown
//Result: 30
//Finally block runs even when no exception occurs!
//
//Program execution completed.
//
//Process finished with exit code 0
