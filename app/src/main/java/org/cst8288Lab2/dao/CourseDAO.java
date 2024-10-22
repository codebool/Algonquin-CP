/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.dao;

import java.sql.SQLException;
import org.cst8288Lab2.model.Course;

// Interface for CourseDAO
public interface CourseDAO {
    // Add a course to the database using the course object
    void addCourse(Course course) throws SQLException;
    // Get a course by its courseId
    Course getCourseById(String courseId) throws SQLException;
}
