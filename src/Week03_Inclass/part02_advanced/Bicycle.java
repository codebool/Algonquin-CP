package Week03_Inclass.part02_advanced;

import java.util.Random;

/**
 * The Bicycle class represents a bicycle with attributes like brand, type, gears, top speed, and acceleration.
 * It includes methods to simulate the bicycle's racing behavior.
 */
public class Bicycle {
    private String brand;
    private String type;
    private int gears;
    private int topSpeed; // top speed in km/h
    private int acceleration; // acceleration in km/h per second
    private int distanceCovered; // distance covered in meters

    // Random number generator for top speed and acceleration
    private static final Random random = new Random();

    // Constructor
    public Bicycle(String brand, String type, int gears) {
        this.brand = brand;
        this.type = type;
        this.gears = gears;
        this.topSpeed = random.nextInt(41) + 20; // Random top speed between 20 and 60 km/h
        this.acceleration = random.nextInt(6) + 2; // Random acceleration between 2 and 7 km/h per second
        this.distanceCovered = 0;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getGears() {
        return gears;
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
        return "Bicycle [brand=" + brand + ", type=" + type + ", gears=" + gears + ", topSpeed=" + topSpeed
                + " km/h, acceleration=" + acceleration + " km/h/s, distanceCovered=" + distanceCovered + " m]";
    }
}
