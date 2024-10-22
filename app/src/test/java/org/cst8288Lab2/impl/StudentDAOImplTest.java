package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

// StudentDAOImplTest class
class StudentDAOImplTest {
    // Declare the StudentDAOImpl and Connection objects
    private StudentDAOImpl studentDAO;
    private Connection connection;

    // Set up the database connection
    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
        studentDAO = new StudentDAOImpl(connection);
    }

    // Test the addStudent method
    @Test
    void addStudent() throws SQLException {
        Student student = new Student(1, "Bill", "Gate");
        studentDAO.addStudent(student);
        // Retrieve the student from the database
        Student retrievedStudent = studentDAO.getStudentById(1);
        assertNotNull(retrievedStudent);
        assertEquals("Bill", retrievedStudent.getFirstName());
        assertEquals("Gate", retrievedStudent.getLastName());
    }

    // Test the getStudentById method
    @Test
    void getStudentById() throws SQLException {
        Student student = new Student(2, "Super", "Man");
        studentDAO.addStudent(student);

        // Retrieve the student from the database
        Student retrievedStudent = studentDAO.getStudentById(2);
        assertNotNull(retrievedStudent);
        assertEquals("Super", retrievedStudent.getFirstName());
        assertEquals("Man", retrievedStudent.getLastName());
    }
}