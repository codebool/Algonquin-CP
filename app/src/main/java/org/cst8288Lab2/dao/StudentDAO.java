/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.dao;

import java.sql.SQLException;
import org.cst8288Lab2.model.Student;

// Interface for StudentDAO
public interface StudentDAO {
    // Add a student to the database
    void addStudent(Student student) throws SQLException;
    // Get a student by their ID
    Student getStudentById(int studentId) throws SQLException;
}
