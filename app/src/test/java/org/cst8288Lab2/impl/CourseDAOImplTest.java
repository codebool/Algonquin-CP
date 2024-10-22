package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOImplTest {

    private CourseDAOImpl courseDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
        courseDAO = new CourseDAOImpl(connection);
    }

    @Test
    void addCourse() throws SQLException {
        Course course = new Course("CS101", "Introduction to Computer Science");
        courseDAO.addCourse(course);

        Course retrievedCourse = courseDAO.getCourseById("CS101");
        assertNotNull(retrievedCourse);
        assertEquals("CS101", retrievedCourse.getCourseId());
        assertEquals("Introduction to Computer Science", retrievedCourse.getCourseName());
    }

    @Test
    void getCourseById() throws SQLException {
        Course course = new Course("CS102", "Data Structures");
        courseDAO.addCourse(course);

        Course retrievedCourse = courseDAO.getCourseById("CS102");
        assertNotNull(retrievedCourse);
        assertEquals("CS102", retrievedCourse.getCourseId());
        assertEquals("Data Structures", retrievedCourse.getCourseName());
    }
}