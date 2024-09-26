package com.algonquin.cst8288.week4_in_class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Abstract Product: Defines the common interface for all shapes.
// In the Factory Method pattern, this is the "Product" interface, which all concrete products must implement.
interface Shape {
    void draw(Graphics g); // Method to draw the shape.
    void move();           // Method to move the shape along the assembly line.
    boolean isOffScreen(); // Method to check if the shape has moved off the screen.
}

// Concrete Product: Implementation of the Shape interface for a circle.
// This is a specific type of product created by the factory.
class MovingCircle implements Shape {
    private int x = 0, y = 50;   // Initial position of the circle.
    private final int diameter = 50; // Size of the circle.
    private final Color color;   // Color of the circle.

    // Constructor: Takes a color to assign to the circle.
    public MovingCircle(Color color) {
        this.color = color;
    }

    // Draws the circle at its current position.
    @Override
    public void draw(Graphics g) {
        g.setColor(color);               // Set the color for the shape.
        g.fillOval(x, y, diameter, diameter); // Draw the circle.
    }

    // Moves the circle to the right.
    @Override
    public void move() {
        x += 5; // Increment the x-coordinate to simulate movement to the right.
    }

    // Determines if the circle has moved off the screen.
    @Override
    public boolean isOffScreen() {
        return x > 600; // If the circle's x-coordinate exceeds 600, it's considered off-screen.
    }
}

// Concrete Product: Implementation of the Shape interface for a square.
class MovingSquare implements Shape {
    private int x = 0, y = 100;  // Initial position of the square.
    private final int size = 50; // Size of the square.
    private final Color color;   // Color of the square.

    // Constructor: Takes a color to assign to the square.
    public MovingSquare(Color color) {
        this.color = color;
    }

    // Draws the square at its current position.
    @Override
    public void draw(Graphics g) {
        g.setColor(color);          // Set the color for the shape.
        g.fillRect(x, y, size, size); // Draw the square.
    }

    // Moves the square to the right.
    @Override
    public void move() {
        x += 5; // Increment the x-coordinate to simulate movement to the right.
    }

    // Determines if the square has moved off the screen.
    @Override
    public boolean isOffScreen() {
        return x > 600; // If the square's x-coordinate exceeds 600, it's considered off-screen.
    }
}

// Concrete Product: Implementation of the Shape interface for a rectangle.
class MovingRectangle implements Shape {
    private int x = 0, y = 150;  // Initial position of the rectangle.
    private final int width = 100, height = 50; // Size of the rectangle.
    private final Color color;  // Color of the rectangle.

    // Constructor: Takes a color to assign to the rectangle.
    public MovingRectangle(Color color) {
        this.color = color;
    }

    // Draws the rectangle at its current position.
    @Override
    public void draw(Graphics g) {
        g.setColor(color);                   // Set the color for the shape.
        g.fillRect(x, y, width, height);      // Draw the rectangle.
    }

    // Moves the rectangle to the right.
    @Override
    public void move() {
        x += 5; // Increment the x-coordinate to simulate movement to the right.
    }

    // Determines if the rectangle has moved off the screen.
    @Override
    public boolean isOffScreen() {
        return x > 600; // If the rectangle's x-coordinate exceeds 600, it's considered off-screen.
    }
}

// Concrete Product: Implementation of the Shape interface for a triangle.
class MovingTriangle implements Shape {
    private int x = 0, y = 200;  // Initial position of the triangle.
    private final Color color;  // Color of the triangle.

    // Constructor: Takes a color to assign to the triangle.
    public MovingTriangle(Color color) {
        this.color = color;
    }

    // Draws the triangle at its current position.
    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Set the color for the shape.
        // Create and draw a triangle using a polygon.
        Polygon triangle = new Polygon();
        triangle.addPoint(x, y + 50);
        triangle.addPoint(x + 25, y);
        triangle.addPoint(x + 50, y + 50);
        g.fillPolygon(triangle); // Fill the triangle with the color.
    }

    // Moves the triangle to the right.
    @Override
    public void move() {
        x += 5; // Increment the x-coordinate to simulate movement to the right.
    }

    // Determines if the triangle has moved off the screen.
    @Override
    public boolean isOffScreen() {
        return x > 600; // If the triangle's x-coordinate exceeds 600, it's considered off-screen.
    }
}

class MovingPentagon implements Shape {
    private int x = 0, y = 250;  // Initial position of the pentagon.
    private final Color color;  // Color of the pentagon.

    // Constructor: Takes a color to assign to the pentagon.
    public MovingPentagon(Color color) {
        this.color = color;
    }

    // Draws the pentagon at its current position.
    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Set the color for the shape.
        // Create and draw a pentagon using a polygon.
        Polygon pentagon = new Polygon();
        pentagon.addPoint(x + 25, y);
        pentagon.addPoint(x + 50, y + 20);
        pentagon.addPoint(x + 40, y + 50);
        pentagon.addPoint(x + 10, y + 50);
        pentagon.addPoint(x, y + 20);
        g.fillPolygon(pentagon); // Fill the pentagon with the color.
    }

    // Moves the pentagon to the right.
    @Override
    public void move() {
        x += 5; // Increment the x-coordinate to simulate movement to the right.
    }

    // Determines if the pentagon has moved off the screen.
    @Override
    public boolean isOffScreen() {
        return x > 800; // If the pentagon's x-coordinate exceeds 800, it's considered off-screen.
    }
}

// Factory Method (Abstract Factory): Declares the factory method that subclasses will override to create objects.
// This is the "Creator" in the Factory Method pattern.
abstract class ShapeFactory {
    abstract Shape createShape(); // Factory method for creating shapes.
}

// Concrete Factory: Implements the factory method to create specific shape objects.
// This factory creates a random shape with a random color.
class RandomShapeFactory extends ShapeFactory {
    private final Random random = new Random();

    // Overrides the factory method to create a random shape with a random color.
    @Override
    public Shape createShape() {
        // Generate a random color.
        Color randomColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        // Randomly select a shape type (circle, square, rectangle, triangle).
        int shapeType = random.nextInt(5);
        switch (shapeType) {
            case 0: return new MovingCircle(randomColor);    // Create a circle.
            case 1: return new MovingSquare(randomColor);    // Create a square.
            case 2: return new MovingRectangle(randomColor); // Create a rectangle.
            case 3: return new MovingTriangle(randomColor);  // Create a triangle.
            case 4: return new MovingPentagon(randomColor); // New shape.
            default: throw new IllegalArgumentException("Unknown shape type.");
        }
    }
}

// Assembly Line Class: Manages the display and movement of shapes along the assembly line.
class AssemblyLine extends JPanel {
    private final List<Shape> shapes = new ArrayList<>(); // Stores the shapes on the assembly line.
    private final ShapeFactory shapeFactory = new RandomShapeFactory(); // Factory for creating shapes.
    private final Random random = new Random();

    // Constructor: Sets up the timers for shape spawning and animation.
    public AssemblyLine() {
        // Timer to add new shapes at random intervals.
        Timer shapeSpawner = new Timer(random.nextInt(1000) + 500, e -> {
            shapes.add(shapeFactory.createShape()); // Create a new shape using the factory method.
        });
        shapeSpawner.start();

        // Timer to update the shape positions and refresh the screen.
        Timer animationTimer = new Timer(100, e -> {
            updateShapes(); // Move and remove shapes that are off the screen.
            repaint();      // Repaint the assembly line to reflect changes.
        });
        animationTimer.start();
    }

    // Updates the position of each shape and removes any that have moved off the screen.
    private void updateShapes() {
        List<Shape> shapesToRemove = new ArrayList<>();
        for (Shape shape : shapes) {
            shape.move(); // Move the shape along the assembly line.
            if (shape.isOffScreen()) {
                shapesToRemove.add(shape); // Mark the shape for removal if it's off the screen.
            }
        }
        shapes.removeAll(shapesToRemove); // Remove off-screen shapes (despawn them).
    }

    // Overrides the paintComponent method to draw the shapes and the assembly line.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the conveyor belt (a gray rectangle).
        g.setColor(Color.GRAY);
        g.fillRect(0, 50, 600, 250);
        // Draw the box where shapes are despawned (a dark gray rectangle).
        g.setColor(Color.DARK_GRAY);
        g.fillRect(600, 50, 50, 250);
        // Draw all the shapes on the assembly line.
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

// Main Application: Starts the assembly line simulation.
public class AssemblyLineSimulation {
    public static void main(String[] args) {
        // Create the frame for the simulation window.
        JFrame frame = new JFrame("Assembly Line Animation");
        frame.setSize(900, 400); // Set the size of the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed.

        // Create an instance of the AssemblyLine and add it to the frame.
        AssemblyLine assemblyLine = new AssemblyLine();
        frame.add(assemblyLine);

        // Make the window visible.
        frame.setVisible(true);
    }
}
