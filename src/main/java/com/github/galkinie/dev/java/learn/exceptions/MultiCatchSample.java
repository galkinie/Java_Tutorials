package com.github.galkinie.dev.java.learn.exceptions;

public class MultiCatchSample {
    public static void main(String[] args) {


        // Multi-catch example - handling multiple exception types with one handler
        System.out.println("=== Multi-Catch Example ===");
        String[] testData = {"10", "abc", "0", "5", "hello"};
        int[] divisors = {2, 2, 1, 0, 3};

        for (int i = 0; i < testData.length && i < divisors.length; i++) {
            try {
                String data = testData[i];
                int number = Integer.parseInt(data);
                int result = number / divisors[i];
                System.out.println(data + " / " + divisors[i] + " = " + result);
            } catch (NumberFormatException | ArithmeticException e) {
                String exceptionType = (
                        e instanceof NumberFormatException) ?
                        "NumberFormatException" : "ArithmeticException";
                System.out.println("Error processing '" +
                        testData[i] + "': " + exceptionType);
                System.out.println("  Message: " + e.getMessage());
            }
        }

// Compare with separate catch blocks for the same exceptions
        System.out.println("");
        System.out.println("=== Same Logic with Separate Catches ===");
        for (int i = 0; i < 2 && i < testData.length; i++) {
            try {
                String data = testData[i];
                int number = Integer.parseInt(data);
                int result = number / divisors[i];
                System.out.println("Success: " + data + " / " +
                        divisors[i] + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic error: " + e.getMessage());
            }
        }
        
        
    }
}
//=== Multi-Catch Example ===
//10 / 2 = 5
//Error processing 'abc': NumberFormatException
//  Message: For input string: "abc"
//0 / 1 = 0
//Error processing '5': ArithmeticException
//  Message: / by zero
//Error processing 'hello': NumberFormatException
//  Message: For input string: "hello"
//
//=== Same Logic with Separate Catches ===
//Success: 10 / 2 = 5
//NumberFormat error: For input string: "abc"
//
//Process finished with exit code 0
