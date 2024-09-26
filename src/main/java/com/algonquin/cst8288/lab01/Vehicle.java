/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

// Abstract class for Vehicle
abstract class Vehicle {
    protected String type;
    protected String make;
    protected String model;
    protected int year;
    protected String engineType;
    protected String wheels;

    // Abstract methods
    public void start() {
        System.out.println(this.type + "is starting...");
    }

    // Abstract methods
    public void stop() {
        System.out.println(this.type + "is stopping...");
    }

    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year;
    }
}

