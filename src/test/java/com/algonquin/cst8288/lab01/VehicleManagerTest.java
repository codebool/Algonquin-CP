/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-26
 * Modified: 2024-09-26
 * Description: Lab assignment 01
 */

package com.algonquin.cst8288.lab01;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

// VehicleManagerTest class to test the
public class VehicleManagerTest {
    private VehicleManager vehicleManager;

    // Set up the test environment
    @Before
    public void setUp() {
        vehicleManager = VehicleManager.getInstance();
        vehicleManager.getVehicleList().clear();
    }

    // Test the addVehicle method
    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Car("Toyota", "Cemary", 2020, "V4", "4");
        vehicleManager.addVehicle(vehicle);
        assertEquals(1, vehicleManager.getVehicleList().size());
        assertEquals(vehicle, vehicleManager.getVehicleList().get(0));
    }

    // Test the displayVehicles method
    @Test
    public void testDisplayVehicles() {
        Vehicle vehicle1 = new Car("Toyota", "RAV4", 2020, "V4", "4");
        Vehicle vehicle2 = new Truck("Ford", "F250", 2019, "V6", "6");
        vehicleManager.addVehicle(vehicle1);
        vehicleManager.addVehicle(vehicle2);
        List<Vehicle> vehicles = vehicleManager.getVehicleList();
        assertEquals(2, vehicles.size());
        assertEquals(vehicle1, vehicles.get(0));
        assertEquals(vehicle2, vehicles.get(1));
    }
}