package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

// CourseDAOImplTest class
class CourseDAOImplTest {
    // Declare the CourseDAOImpl and Connection objects
    private CourseDAOImpl courseDAO;
    private Connection connection;

    // Set up the database connection
    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
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