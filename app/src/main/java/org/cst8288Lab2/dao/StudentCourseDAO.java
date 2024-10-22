/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.dao;

import java.sql.SQLException;

// Interface for StudentCourseDAO
public interface StudentCourseDAO {
    void enrollStudentInCourse(int studentId, String courseId, int term, int year) throws SQLException;
}

