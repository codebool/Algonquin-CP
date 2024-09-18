/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-18
 * Modified: 2024-09-18
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

class DatabaseConnection {
    // Static variable to hold the single instance of the class
    private static DatabaseConnection instance;

    // Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        // Initialize your database connection here
        System.out.println("Database connection established.");
    }

    // Static method to provide the global access point
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Example method to simulate database operations
    public void connect() {
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        System.out.println("Disconnecting from the database...");
    }
}


public class TestDBConnection {
    public static void main(String[] args) {
        // Attempt to get the single instance of the DatabaseConnection
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.connect();

        // Attempt to get another instance (it will return the same instance)
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        connection2.disconnect();

        // Verify both references point to the same instance
        System.out.println("Are both connections the same instance? " + (connection1 == connection2));
    }
}