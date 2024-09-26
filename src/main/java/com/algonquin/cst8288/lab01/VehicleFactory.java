/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

// Factory class for Vehicle
public class VehicleFactory {
    // Create a vehicle based on the type
    public static Vehicle createVehicle(String type, String make, String model, int year, String engineType, String wheels) {
        if(type.equals("Car")) {
            return new Car(make, model, year, engineType, wheels);
        } else if(type.equals("Truck")) {
            return new Truck(make, model, year, engineType, wheels);
        } else if(type.equals("Motorcycle")) {
            return new Motorcycle(make, model, year, engineType, wheels);
        } else {
            return null;
        }
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, String engineType, String wheels) {
        this.type = "Car";
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.wheels = wheels;
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, String engineType, String wheels) {
        this.type = "Truck";
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.wheels = wheels;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, String engineType, String wheels) {
        this.type = "Motorcycle";
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.wheels = wheels;
    }
}

