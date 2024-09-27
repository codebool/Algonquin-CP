/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    // Singleton instance
    private static VehicleManager instance;

    // List of managed vehicles
    private List<Vehicle> vehicleList;

    // Private constructor to prevent instantiation
    private VehicleManager() {
        vehicleList = new ArrayList<>();
    }

    // provide a static method to get the singleton instance
    public static VehicleManager getInstance() {
        if (instance == null) {
            instance = new VehicleManager();
        }
        return instance;
    }

    // Add a vehicle to the list
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        System.out.println(vehicle.type + ": " + vehicle.make + " " + vehicle.model + ", made in " + vehicle.year + " has been added to the vehicle management system.");
    }

    // Display all vehicles in the list
    public void displayVehicles() {
        System.out.println("Vehicles list: ");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }

    public List getVehicleList() {
        return vehicleList;
    }
}
