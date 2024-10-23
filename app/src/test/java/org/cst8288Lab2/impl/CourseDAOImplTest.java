/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Course;
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

// CourseDAOImplTest class
class CourseDAOImplTest {
    // Declare the CourseDAOImpl and Connection objects
    private CourseDAOImpl courseDAO;

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

        courseDAO = new CourseDAOImpl(connection);
    }

    // Test the addCourse method
    @Test
    void addCourse() throws SQLException {
        Course course = new Course("CST1010", "Introduction to Computer Science");
        courseDAO.addCourse(course);

        Course retrievedCourse = courseDAO.getCourseById("CST1010");
        assertNotNull(retrievedCourse);
        assertEquals("CST1010", retrievedCourse.getCourseId());
        assertEquals("Introduction to Computer Science", retrievedCourse.getCourseName());
    }

    // Test the getCourseById method
    @Test
    void getCourseById() throws SQLException {
        Course course = new Course("CST1020", "Data Structures");
        courseDAO.addCourse(course);

        Course retrievedCourse = courseDAO.getCourseById("CST1020");
        assertNotNull(retrievedCourse);
        assertEquals("CST1020", retrievedCourse.getCourseId());
        assertEquals("Data Structures", retrievedCourse.getCourseName());
    }
}