/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.StudentCourseDAO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

// Implementation of StudentCourseDAO interface
public class StudentCourseDAOImpl implements StudentCourseDAO {
    // Set up constructor with the DB connection
    private final Connection connection;
    // Set up constructor with the DB connection
    public StudentCourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    // Enroll a student in a course
    public void enrollStudentInCourse(int studentId, String courseId, int term, int year) throws SQLException {
        // SQL query to insert a student into a course
        String query = "INSERT INTO StudentCourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        // Try-with-resources to ensure the prepared statement is closed
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // set up parameters for the prepared statement
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, courseId);
            preparedStatement.setInt(3, term);
            preparedStatement.setInt(4, year);
            // Execute the query to enroll the student in the course
            preparedStatement.executeUpdate();
        }
    }
}

