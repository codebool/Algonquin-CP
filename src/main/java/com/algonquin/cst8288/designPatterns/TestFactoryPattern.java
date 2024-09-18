/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-18
 * Modified: 2024-09-18
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

// Define the Shape interface
interface Shape {
    void draw();
}

// Implement Circle class that implements Shape interface
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Implement Square class that implements Shape interface
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Implement Rectangle class that implements Shape interface
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// ShapeFactory class that contains the logic to create shapes based on input
class ShapeFactory {
    // Method to get the appropriate shape object based on the input
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;  // Return null if no matching shape is found
    }
}

// Demonstrating the Factory Pattern
public class TestFactoryPattern {
    public static void main(String[] args) {
        // Create a factory object
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();  // Output: Drawing a Circle

        // Get an object of Square and call its draw method
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();  // Output: Drawing a Square

        // Get an object of Rectangle and call its draw method
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();  // Output: Drawing a Rectangle
    }
}

