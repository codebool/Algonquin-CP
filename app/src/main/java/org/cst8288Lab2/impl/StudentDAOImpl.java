/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.impl;

import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Implementation of StudentDAO interface
public class StudentDAOImpl implements StudentDAO {
    // Connection object to the database to be used in the class
    private final Connection connection;
    // Constructor to set the connection object
    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    // Add a student to the database using the Student object
    public void addStudent(Student student) throws SQLException {
        // SQL query to insert a student into the database
        String query = "INSERT INTO Student (StudentId, FirstName, LastName) VALUES (?, ?, ?)";
        // Try-with-resources block to ensure the PreparedStatement is closed after use
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the values of the PreparedStatement
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            // Execute the query to insert the student into the database
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    // Get a student by their ID from the database
    public Student getStudentById(int studentId) throws SQLException {
        // SQL query to select a student from the database by their ID
        String query = "SELECT * FROM Student WHERE StudentId = ?";
        // Try-with-resources block to ensure the PreparedStatement is closed after use
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the value of the PreparedStatement
            preparedStatement.setInt(1, studentId);
            // Execute the query to select the student from the database
            ResultSet rs = preparedStatement.executeQuery();
            // If the ResultSet has a row, return a new Student object with the values from the ResultSet
            if (rs.next()) {
                // Return a new Student object with the values from the ResultSet
                return new Student(rs.getInt("studentId"), rs.getString("firstName"), rs.getString("lastName"));
            } else {
                // If the ResultSet is empty, return null
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return null if the ResultSet is empty
        return null;
    }
}
