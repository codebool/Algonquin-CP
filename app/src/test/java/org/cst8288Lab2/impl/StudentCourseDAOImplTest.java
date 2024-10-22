package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.StudentCourseDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentCourseDAOImplTest {

    private StudentCourseDAO studentCourseDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
        studentCourseDAO = new StudentCourseDAOImpl(connection);
    }

    @Test
    void enrollStudentInCourse() throws SQLException {
        int studentId = 1;
        String courseId = "CS101";
        int term = 1;
        int year = 2024;

        studentCourseDAO.enrollStudentInCourse(studentId, courseId, term, year);

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM StudentCourse WHERE studentId = 1 AND courseId = 'CS101' AND term = 1 AND year = 2024");
        assertTrue(rs.next());
        assertEquals(studentId, rs.getInt("studentId"));
        assertEquals(courseId, rs.getString("courseId"));
        assertEquals(term, rs.getInt("term"));
        assertEquals(year, rs.getInt("year"));
    }
}