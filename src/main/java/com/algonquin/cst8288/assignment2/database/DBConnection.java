/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;

public class DBConnection {
	// Singleton pattern
	private static DBConnection instance;
	// Database connection
	private Connection connection;
	
//	private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String serverUrl = "jdbc:mysql://localhost:3306/fwrp";
	private String userString = "codebool";
	private String passwordString = "123456";
	private String driverString = "com.mysql.cj.jdbc.Driver";

	public DBConnection() {
		try {
			Class.forName(driverString); // Load the driver
			connection = java.sql.DriverManager.getConnection(serverUrl, userString, passwordString);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect to the database");
		}
	}

	// Get the connection object
	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	// Get the connection object
	public Connection getConnection() {
		return connection;
	}
}
