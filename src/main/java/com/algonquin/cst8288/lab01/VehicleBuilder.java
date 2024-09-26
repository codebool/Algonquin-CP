/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

// Builder class for Vehicle
public class VehicleBuilder {
    private String type;
    private String make;
    private String model;
    private int year;
    private String engineType;
    private String wheels;

    // Setters
    public VehicleBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public VehicleBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VehicleBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public VehicleBuilder setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public VehicleBuilder setWheels(String wheels) {
        this.wheels = wheels;
        return this;
    }

    // Build method
    public Vehicle build() {
        return VehicleFactory.createVehicle(type, make, model, year, engineType, wheels);
    }
}
