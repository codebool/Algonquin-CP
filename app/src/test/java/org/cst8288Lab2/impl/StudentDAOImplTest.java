package org.cst8288Lab2.impl;

import org.cst8288Lab2.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {

    private StudentDAOImpl studentDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2", "username", "password");
        studentDAO = new StudentDAOImpl(connection);
    }

    @Test
    void addStudent() throws SQLException {
        Student student = new Student(1, "John", "Doe");
        studentDAO.addStudent(student);

        Student retrievedStudent = studentDAO.getStudentById(1);
        assertNotNull(retrievedStudent);
        assertEquals("John", retrievedStudent.getFirstName());
        assertEquals("Doe", retrievedStudent.getLastName());
    }

    @Test
    void getStudentById() throws SQLException {
        Student student = new Student(2, "Jane", "Smith");
        studentDAO.addStudent(student);

        Student retrievedStudent = studentDAO.getStudentById(2);
        assertNotNull(retrievedStudent);
        assertEquals("Jane", retrievedStudent.getFirstName());
        assertEquals("Smith", retrievedStudent.getLastName());
    }
}