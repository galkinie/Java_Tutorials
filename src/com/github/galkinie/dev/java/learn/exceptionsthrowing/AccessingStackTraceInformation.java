package com.github.galkinie.dev.java.learn.exceptionsthrowing;

public class AccessingStackTraceInformation {

    public static void main(String[] args) {

        /**
         * Accessing Stack Trace Information
         * A stack trace provides information on the execution history
         * of the current thread and lists the names of the classes
         * and methods that were called at the point when
         * the exception occurred.
         * A stack trace is a useful debugging tool that you'll
         * normally take advantage of when an exception has been thrown.
         *
         * call the getStackTrace() method on the exception object
         */
//        catch (Exception cause) {
//            StackTraceElement elements[] = cause.getStackTrace();
//            for (int i = 0, n = elements.length; i < n; i++) {
//                System.err.println(elements[i].getFileName()
//                        + ":" + elements[i].getLineNumber()
//                        + ">> "
//                        + elements[i].getMethodName() + "()");
//            }
//        }

        /**
         * Logging API
         *
         * The next code snippet logs where an exception occurred
         * from within the catch block.
         * However, rather than manually parsing the stack trace
         * and sending the output to java.util.logging,
         * it sends the output to a file using the
         * logging facility in the java.util.logging package.
         */
//        try {
//            Handler handler = new FileHandler("OutFile.log");
//            Logger.getLogger("").addHandler(handler);
//
//        } catch (IOException e) {
//            Logger logger = Logger.getLogger("package.name");
//            StackTraceElement elements[] = e.getStackTrace();
//            for (int i = 0, n = elements.length; i < n; i++) {
//                logger.log(Level.WARNING, elements[i].getMethodName());
//            }
//        }
    }

}
