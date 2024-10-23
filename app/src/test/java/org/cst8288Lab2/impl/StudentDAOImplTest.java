/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// StudentDAOImplTest class
class StudentDAOImplTest {
    // Declare the StudentDAOImpl and Connection objects
    private StudentDAOImpl studentDAO;

    // Set up the database connection
    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        Properties dbConnection = new Properties();
        Connection connection = null;

        try (InputStream dbConfig = new FileInputStream("../app/data/database.properties")) {
            // Load database properties
            dbConnection.load(dbConfig);
            // Establish connection
            String url = dbConnection.getProperty("url");
            String user = dbConnection.getProperty("user");
            String password = dbConnection.getProperty("pass");
            // Get connection
            connection = DriverManager.getConnection(url, user, password);
            // Print connection successful
            System.out.println("Connection Successful");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        studentDAO = new StudentDAOImpl(connection);
    }

    // Test the addStudent method
    @Test
    void addStudent() throws SQLException {
        Student student = new Student(1, "Bo", "Qu");
        studentDAO.addStudent(student);
        // Retrieve the student from the database
        Student retrievedStudent = studentDAO.getStudentById(1);
        assertNotNull(retrievedStudent);
        assertEquals("Bo", retrievedStudent.getFirstName());
        assertEquals("Qu", retrievedStudent.getLastName());
    }

    // Test the getStudentById method
    @Test
    void getStudentById() throws SQLException {
        Student student = new Student(2, "Super", "Man");
        studentDAO.addStudent(student);

        // Retrieve the student from the database
        Student retrievedStudent = studentDAO.getStudentById(2);
        assertNotNull(retrievedStudent);
        assertEquals("Super", retrievedStudent.getFirstName());
        assertEquals("Man", retrievedStudent.getLastName());
    }
}