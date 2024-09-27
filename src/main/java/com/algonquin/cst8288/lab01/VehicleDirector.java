/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

// Director class for Vehicle
public class VehicleDirector {
    private VehicleBuilder builder;

    // Constructor
    public VehicleDirector(VehicleBuilder builder) {
        this.builder = builder;
    }

    // Construct a vehicle
    public void constructVehicle() {
        builder.setMake("Default Make")
                .setModel("Default Model")
                .setYear(2020)
                .setEngineType("V6 Engine")
                .setWheels("4 Wheels").setType("Car");
    }

    public Vehicle getVehicle() {
        return builder.build();
    }
}

