package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.StudentCourseDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

// StudentCourseDAOImplTest class
class StudentCourseDAOImplTest {
    // Declare the StudentCourseDAOImpl and Connection objects
    private StudentCourseDAO studentCourseDAO;
    private Connection connection;

    // Set up the database connection
    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
        studentCourseDAO = new StudentCourseDAOImpl(connection);
    }

    // Test the enrollStudentInCourse method
    @Test
    void enrollStudentInCourse() throws SQLException {
        // Enroll a student in a course
        int studentId = 121212121;
        String courseId = "CST1010";
        int term = 1;
        int year = 2023;
        // Enroll the student in the course
        studentCourseDAO.enrollStudentInCourse(studentId, courseId, term, year);
        // Retrieve the student course from the database
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM StudentCourse WHERE studentId = 121212121 AND courseId = 'CST1010' AND term = 1 AND year = 2023");
        assertTrue(rs.next());
        assertEquals(studentId, rs.getInt("studentId"));
        assertEquals(courseId, rs.getString("courseId"));
        assertEquals(term, rs.getInt("term"));
        assertEquals(year, rs.getInt("year"));
    }
}