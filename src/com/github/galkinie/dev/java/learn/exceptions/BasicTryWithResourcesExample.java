package com.github.galkinie.dev.java.learn.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class BasicTryWithResourcesExample {

    /**
     * try-with-resources statement is a try statement that declares
     * one or more resources.
     * A resource is an object that must be closed
     * after the program is finished with it.
     */

    public static void main(String[] args) {




    }

    /**
     * reads the first line from a file. It uses an instance of
     * BufferedReader to read data from the file. BufferedReader
     * is a resource that must be closed after the program is finished with it
     */

    /**
     * the resource declared in the try-with-resources statement
     * is a BufferedReader. The declaration statement appears within
     * parentheses immediately after the try keyword
     *
     * Because the BufferedReader instance is declared
     * in a try-with-resource statement, it will be closed
     * regardless of whether the try statement completes
     * normally or abruptly (as a result of the method
     * BufferedReader.readLine() throwing an IOException.
     *
     * In a try-with-resources statement, any catch or
     * finally block is run after the resources declared have been closed.
     */
    public static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }


    /**
     * uses a finally block instead of a try-with-resources statement
     *
     * In a try-with-resources statement, any catch or
     * finally block is run after the resources declared have been closed.
     */
    static String readFirstLineFromFileWithFinallyBlock(String path)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }


    /**
     * retrieves the names of the files packaged in the zip file
     * zipFileName and creates a text file that contains the names of these files
     */
    public static void writeToFileZipFileContents(String zipFileName,
                                                  String outputFileName)
            throws java.io.IOException {

        Charset charset =
                StandardCharsets.US_ASCII;
        Path outputFilePath =
                Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement
        /**
         * the try-with-resources statement contains two declarations
         * that are separated by a semicolon: ZipFile and BufferedWriter.
         *
         * When the block of code that directly follows it terminates,
         * either normally or because of an exception, the close() methods
         * of the BufferedWriter and ZipFile objects are automatically
         * called in this order.
         *
         * Note that the close methods of resources are called in the
         * opposite order of their creation
         *
         */
        try (
                ZipFile zf =
                        new ZipFile(zipFileName); //notice how declarations are separated
                BufferedWriter writer =
                        Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (Enumeration entries =
                 zf.entries(); entries.hasMoreElements(); ) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((ZipEntry) entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
            /**
             * an exception can be thrown from the try block,
             * and up to two exceptions can be thrown from the
             * try-with-resources statement when it tries to close
             * the ZipFile and BufferedWriter objects.
             */
        }
    }


    /**
     * uses a try-with-resources statement
     * to automatically close a java.sql.Statement object
     */
    public static void viewTable(Connection con) throws SQLException {

        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " +
                        price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
            // do something with the exception
        }
    }





}
