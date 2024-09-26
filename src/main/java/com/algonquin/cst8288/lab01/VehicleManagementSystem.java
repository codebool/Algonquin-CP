/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

// Main class to demonstrate the Vehicle Management System
public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Singleton demonstration
        VehicleManager manager1 = VehicleManager.getInstance();
        VehicleManager manager2 = VehicleManager.getInstance();

        // Prove that both references point to the same instance
        if (manager1 == manager2) {
            System.out.println("VehicleManager is a singleton!");
        }

        // Builder pattern demonstration
        VehicleBuilder carBuilder = new VehicleBuilder()
                .setType("Car")
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .setEngineType("V4 Engine")
                .setWheels("4 Wheels");

        VehicleDirector director = new VehicleDirector(carBuilder);
        director.constructVehicle();
        Vehicle car = director.getVehicle();
        car.start();

        // Add the car to the vehicle manager
        manager1.addVehicle(car);

        // Create a Truck using the builder and factory
        VehicleBuilder truckBuilder = new VehicleBuilder()
                .setType("Truck")
                .setMake("Ford")
                .setModel("F-150")
                .setYear(2023)
                .setEngineType("V8 Engine")
                .setWheels("4 Wheels");

        Vehicle truck = truckBuilder.build();
        truck.start();
        manager1.addVehicle(truck);

        // Display all vehicles managed by VehicleManager
        manager1.displayVehicles();

        // Create another vehicle using the factory and builder
        VehicleBuilder motorcycleBuilder = new VehicleBuilder()
                .setType("Motorcycle")
                .setMake("Harley-Davidson")
                .setModel("Street 750")
                .setYear(2021)
                .setEngineType("750cc")
                .setWheels("2 Wheels");

        Vehicle motorcycle = motorcycleBuilder.build();
        motorcycle.start();
        manager1.addVehicle(motorcycle);

        // Display all vehicles managed by VehicleManager
        manager1.displayVehicles();

        car.stop();
        truck.stop();
        motorcycle.stop();
    }
}
