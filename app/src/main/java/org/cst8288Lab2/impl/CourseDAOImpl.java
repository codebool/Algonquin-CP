/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Implementation of CourseDAO interface
public class CourseDAOImpl implements CourseDAO {
    private final Connection connection;
    // Set up constructor with the DB connection
    public CourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    // Add a course to the database using the course object
    public void addCourse(Course course) throws SQLException {
        // SQL query to insert a course into the database using the course object fields as parameters
        String query = "INSERT INTO Course (courseId, courseName) VALUES (?, ?)";
        // Try-with-resources to ensure the prepared statement is closed
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the course object fields as parameters for the prepared statement query
            preparedStatement.setString(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            // Execute the query
            preparedStatement.executeUpdate();
        }
    }

    @Override
    // Get a course by its ID from the database and return it
    public Course getCourseById(String courseId) throws SQLException {
        // SQL query to select a course by its ID
        String query = "SELECT * FROM Course WHERE courseId = ?";
        // Try-with-resources to ensure the prepared statement is closed
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, courseId);
            // Execute the query and store the result set in rs variable for processing the result set data later
            ResultSet rs = preparedStatement.executeQuery();
            // If the result set is not empty, return the course
            if (rs.next()) {
                // Return the course object with the course ID and course name from the result set
                return new Course(rs.getString("courseId"), rs.getString("courseName"));
            }
        }
        // If the result set is empty, return null
        return null;
    }
}
