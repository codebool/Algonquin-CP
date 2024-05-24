package Week03_Inclass.part02_graphics;

import java.util.Random;

/**
 * The Car class represents a car with attributes like model, year, color, top speed, and acceleration.
 * It includes methods to simulate the car's racing behavior.
 */
public class Car {
    private String model;
    private int year;
    private String color;
    private int topSpeed; // top speed in km/h
    private int acceleration; // acceleration in km/h per second
    private int distanceCovered; // distance covered in meters

    // Random number generator for top speed and acceleration
    private static final Random random = new Random();

    // Constructor
    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.topSpeed = random.nextInt(201) + 100; // Random top speed between 100 and 300 km/h
        this.acceleration = random.nextInt(11) + 5; // Random acceleration between 5 and 15 km/h per second
        this.distanceCovered = 0;
    }

    // Getter methods
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    // Method to simulate racing for a second
    public void raceForOneSecond() {
        distanceCovered += Math.min(topSpeed, acceleration);
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + ", color=" + color + ", topSpeed=" + topSpeed
                + " km/h, acceleration=" + acceleration + " km/h/s, distanceCovered=" + distanceCovered + " m]";
    }
}
