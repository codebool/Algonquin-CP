/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// StudentCourseDAOImplTest class
class StudentCourseDAOImplTest {
    // Declare the StudentCourseDAOImpl and Connection objects
    Connection connection = null;

    // Set up the database connection
    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        Properties dbConnection = new Properties();
        // Load database properties and establish connection
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
    }

    // Test the enrollStudentInCourse method
    @Test
    void enrollStudentInCourse() throws SQLException {
        // make sure the student is not already enrolled in the course
        int studentId = 123546851;
        String courseId = "cst8288";
        int term = 1;
        int year = 2024;

        // Verify the enrollment
        ResultSet rs = connection.createStatement().executeQuery(
                "SELECT * FROM StudentCourse WHERE studentId = " + studentId + " AND courseId = '" + courseId + "' AND term = " + term + " AND year = " + year
        );
        // If the student is already enrolled, delete the record
        assertTrue(rs.next());
        assertEquals(studentId, rs.getInt("studentId"));
        assertEquals(courseId, rs.getString("courseId"));
        assertEquals(term, rs.getInt("term"));
        assertEquals(year, rs.getInt("year"));
    }
}