/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleFactoryTest {

    @Test
    public void testCreateCar() {
        // Create a VehicleBuilder and set the fields
        VehicleBuilder builder = new VehicleBuilder();
        builder.setType("Car")
                .setMake("Toyota")
                .setModel("Corolla")
                .setYear(2020)
                .setEngineType("V6 Engine")
                .setWheels("4 Wheels");

        // Build the vehicle using VehicleFactory (indirectly via the builder)
        Vehicle car = builder.build();

        // Validate the properties from the builder
        assertEquals("Type should be 'Car'", "Car", builder.getType());
        assertEquals("Make should be 'Toyota'", "Toyota", builder.getMake());
        assertEquals("Model should be 'Corolla'", "Corolla", builder.getModel());
        assertEquals("Year should be 2020", 2020, builder.getYear());
        assertEquals("Engine type should be 'V6 Engine'", "V6 Engine", builder.getEngineType());
        assertEquals("Wheels should be '4 Wheels'", "4 Wheels", builder.getWheels());
    }

    @Test
    public void testCreateTruck() {
        // Create a VehicleBuilder and set the fields
        VehicleBuilder builder = new VehicleBuilder();
        builder.setType("Truck")
                .setMake("Ford")
                .setModel("F-150")
                .setYear(2021)
                .setEngineType("V8 Engine")
                .setWheels("4 Wheels");

        // Build the vehicle using VehicleFactory (indirectly via the builder)
        Vehicle truck = builder.build();

        // Validate the properties from the builder
        assertEquals("Type should be 'Truck'", "Truck", builder.getType());
        assertEquals("Make should be 'Ford'", "Ford", builder.getMake());
        assertEquals("Model should be 'F-150'", "F-150", builder.getModel());
        assertEquals("Year should be 2021", 2021, builder.getYear());
        assertEquals("Engine type should be 'V8 Engine'", "V8 Engine", builder.getEngineType());
        assertEquals("Wheels should be '4 Wheels'", "4 Wheels", builder.getWheels());
    }

    @Test
    public void testCreateMotorcycle() {
        // Create a VehicleBuilder and set the fields
        VehicleBuilder builder = new VehicleBuilder();
        builder.setType("Motorcycle")
                .setMake("Honda")
                .setModel("CBR500R")
                .setYear(2019)
                .setEngineType("500cc Engine")
                .setWheels("2 Wheels");

        // Build the vehicle using VehicleFactory (indirectly via the builder)
        Vehicle motorcycle = builder.build();

        // Validate the properties from the builder
        assertEquals("Type should be 'Motorcycle'", "Motorcycle", builder.getType());
        assertEquals("Make should be 'Honda'", "Honda", builder.getMake());
        assertEquals("Model should be 'CBR500R'", "CBR500R", builder.getModel());
        assertEquals("Year should be 2019", 2019, builder.getYear());
        assertEquals("Engine type should be '500cc Engine'", "500cc Engine", builder.getEngineType());
        assertEquals("Wheels should be '2 Wheels'", "2 Wheels", builder.getWheels());
    }

    @Test
    public void testCreateUnknownVehicle() {
        // Create a VehicleBuilder and set an unknown type
        VehicleBuilder builder = new VehicleBuilder();
        builder.setType("Bicycle")
                .setMake("Giant")
                .setModel("Escape 3")
                .setYear(2022)
                .setEngineType("No Engine")
                .setWheels("2 Wheels");

        // Attempt to build the vehicle using VehicleFactory (indirectly via the builder)
        Vehicle unknown = builder.build();

        // Validate that the VehicleFactory returned null for an unknown type
        assertNull("VehicleFactory should return null for unknown vehicle type", unknown);
    }
}
