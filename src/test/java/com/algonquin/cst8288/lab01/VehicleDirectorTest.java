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
import static org.junit.Assert.*;

public class VehicleDirectorTest {

    private VehicleDirector director;
    private VehicleBuilder builder;

    @Before
    public void setUp() throws Exception {
        // Initialize VehicleBuilder instance
        builder = new VehicleBuilder();
        // Initialize VehicleDirector with builder instance
        director = new VehicleDirector(builder);
    }

    @Test
    public void constructVehicle() {
        // Call constructVehicle method
        director.constructVehicle();
        // Get the constructed vehicle
        Vehicle vehicle = director.getVehicle();

        // Check that vehicle is not null
        assertNotNull("Constructed vehicle should not be null", vehicle);

        // Verify that vehicle properties match expected values using builder getters
        assertEquals("Make should be 'Default Make'", "Default Make", builder.getMake());
        assertEquals("Model should be 'Default Model'", "Default Model", builder.getModel());
        assertEquals("Year should be 2020", 2020, builder.getYear());
        assertEquals("Engine type should be 'V6 Engine'", "V6 Engine", builder.getEngineType());
        assertEquals("Wheels should be '4 Wheels'", "4 Wheels", builder.getWheels());
    }

    @Test
    public void getVehicle() {
        // Perform construction
        director.constructVehicle();

        // After construction, getVehicle should return non-null
        Vehicle vehicleAfter = director.getVehicle();
        assertNotNull("Vehicle should not be null after construction", vehicleAfter);
    }
}
