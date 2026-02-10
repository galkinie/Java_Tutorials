package com.github.galkinie.dev.java.learn.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListOfNumbersTryCatchFinallyExample {

    private static List<Integer> list;
    private static final int SIZE = 10;

    public static void main(String[] args) {
        writeList();
    }

    /**
     * this method's try block has three different exit possibilities;
     * here are two of them.
     *
     * Code in the try statement fails and throws an exception. This could
     * be an IOException caused by the new FileWriter statement or an
     * IndexOutOfBoundsException caused by a wrong index value in the for loop.
     * Everything succeeds and the try statement exits normally.
     * Let's look at what happens in the writeList() method during
     * these two exit possibilities.
     *
     * Scenario 1: An Exception Occurs
     * The statement that creates a FileWriter can fail for a number of
     * reasons. For example, the constructor for the FileWriter throws
     * an IOException if the program cannot create or write to the file
     *
     * When FileWriter throws an IOException,
     * the runtime system immediately stops executing the try block;
     *
     * method calls being executed are not completed.
     * The runtime system then starts searching at the top of the
     * method call stack for an appropriate exception handler.
     *
     * In this example, when the IOException occurs,
     * the FileWriter constructor is at the top of the call stack.
     *
     * However, the FileWriter constructor doesn't
     * have an appropriate exception handler, so
     * the runtime system checks the next method
     * — the writeList() method — in the method call stack.
     *
     * The writeList() method has two exception handlers:
     * one for IOException and one for IndexOutOfBoundsException.
     *
     * The runtime system checks writeList()'s handlers
     * in the order in which they appear after the try statement.
     *
     * The argument to the first exception handler
     * is IndexOutOfBoundsException. This does not match the type
     * of exception thrown, so the runtime system checks
     * the next exception handler — IOException.
     * This matches the type of exception that was thrown,
     * so the runtime system ends its search
     * for an appropriate exception handler.
     *
     * Now that the runtime has found an appropriate handler,
     * the code in that catch block is executed.
     *
     * After the exception handler executes,
     * the runtime system passes control to the finally block.
     *
     * Code in the finally block executes regardless
     * of the exception caught above it.
     * In this scenario, the FileWriter was never opened
     * and doesn't need to be closed.
     * After the finally block finishes executing,
     * the program continues with the first statement
     * after the finally block.
     *
     * Here's the complete output from the ListOfNumbers program
     * that appears when an IOException is thrown.
     *
     * Entering try statement
     * Caught IOException: OutFile.txt
     * PrintWriter not open
     *
     * Scenario 2: The try Block Exits Normally
     * In this scenario, all the statements within the scope
     * of the try block execute successfully and throw no exceptions.
     * Execution falls off the end of the try block,
     * and the runtime system passes control to the finally block.
     *
     * Because everything was successful, the PrintWriter is open
     * when control reaches the finally block, which closes the PrintWriter.
     *
     * Again, after the finally block finishes executing,
     * the program continues with the first statement
     * after the finally block.
     *
     * Here is the output from the ListOfNumbers program
     * when no exceptions are thrown.
     * //Entering try statement
     * //Closing PrintWriter
     *
     */
    public static void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering" + " try statement");

            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: "
                    +  e.getMessage());

        } catch (IOException e) {
            System.err.println("Caught IOException: " +  e.getMessage());

        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}
//Entering try statement
//Closing PrintWriter
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.List.get(int)" because "com.github.galkinie.dev.java.learn.exceptions.TryCatchFinallyExample.list" is null
//	at com.github.galkinie.dev.java.learn.exceptions.TryCatchFinallyExample.writeList(TryCatchFinallyExample.java:25)
//	at com.github.galkinie.dev.java.learn.exceptions.TryCatchFinallyExample.main(TryCatchFinallyExample.java:14)
