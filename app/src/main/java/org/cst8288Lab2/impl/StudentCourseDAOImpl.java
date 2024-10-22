/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.StudentCourseDAO;
import java.sql.*;

public class StudentCourseDAOImpl implements StudentCourseDAO {
    private Connection connection;

    public StudentCourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enrollStudentInCourse(int studentId, String courseId, int term, int year) throws SQLException {
        String query = "INSERT INTO StudentCourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, courseId);
            stmt.setInt(3, term);
            stmt.setInt(4, year);
            stmt.executeUpdate();
        }
    }
}

