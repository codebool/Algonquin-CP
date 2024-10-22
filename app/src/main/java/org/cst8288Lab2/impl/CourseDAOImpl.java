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
import java.sql.*;

public class CourseDAOImpl implements CourseDAO {
    private Connection connection;

    public CourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Course (courseId, courseName) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.executeUpdate();
        }
    }

    @Override
    public Course getCourseById(String courseId) throws SQLException {
        String query = "SELECT * FROM Course WHERE courseId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(rs.getString("courseId"), rs.getString("courseName"));
            }
        }
        return null;
    }
}
