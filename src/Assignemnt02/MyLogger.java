/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-02
 * Modified: 2024-05-27
 * Description: Assignment 02
 */

package Assignemnt02;

import java.time.format.DateTimeFormatter;

public class MyLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eee, MMM d, yyyy 'at' HH:mm:ss:SSS z");

    private void printPrefix() {
        System.out.print(formatter.format(java.time.ZonedDateTime.now()).replace(".", "") + ": ");
    }

    public void print(int i) {
        printPrefix();
        System.out.println("printing a integer: " + i);
    }

    public void print(boolean b) {
        printPrefix();
        System.out.println("printing a boolean: " + b);
    }

    public void print(char c) {
        printPrefix();
        System.out.println("printing a character: " + c);
    }

    public void print(char[] s) {
        printPrefix();
        System.out.println("printing an array of characters: " + new String(s));
    }

    public void print(double d) {
        printPrefix();
        System.out.println("printing a double: " + d);
    }

    public void print(float f) {
        printPrefix();
        System.out.println("printing a float: " + f);
    }

    public void print(long l) {
        printPrefix();
        System.out.println("printing a long: " + l);
    }

    public void print(Object obj) {
        printPrefix();
        System.out.println("printing a String: " + obj);
    }

    public void print(String s) {
        printPrefix();
        System.out.println("printing a String: " + s);
    }
}
