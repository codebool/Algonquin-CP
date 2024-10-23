/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.dao.StudentCourseDAO;
import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.impl.CourseDAOImpl;
import org.cst8288Lab2.impl.StudentCourseDAOImpl;
import org.cst8288Lab2.impl.StudentDAOImpl;
import org.cst8288Lab2.model.Course;
import org.cst8288Lab2.model.Student;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * App
 */
public class App {
    /**
     * Parses the file: bulk-import.csv
     * Validates each item in each row and updates the database accordingly.
     *
     * @param args -
     */
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println("**** Current dir using System: " + currentDir);
        //Ensure that you use the Properties class to load values from the database.properties file
        Properties dbConnection = new Properties();
        Connection connection = null;

        // Load database properties and establish connection
        try (InputStream dbConfig = new FileInputStream("./app/data/database.properties")) {
            // Load database properties
            dbConnection.load(dbConfig);
            // Establish connection
            String url = dbConnection.getProperty("url");
            String user = dbConnection.getProperty("user");
            String password = dbConnection.getProperty("pass");
            // Get connection
            connection = DriverManager.getConnection(url, user, password);
            // Print connection successful
            System.out.println("Connection Successful");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        // Create DAO objects
        StudentDAO studentDAO = new StudentDAOImpl(connection);
        CourseDAO courseDAO = new CourseDAOImpl(connection);
        StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl(connection);

        //Preserve this input path
        try (InputStream in = new FileInputStream("./app/data/bulk-import.csv")) {
            // Initialize variables for success and failure counts and error report string builder
            int failureCount = 0;
            int successCount = 0;
            StringBuilder errorReport = new StringBuilder();

            // Read the file using BufferedReader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                // Initialize line number and line variables
                int lineNum = 0;
                String line = "";

                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    lineNum++;
                    // Split the line by comma and space
                    String[] values = line.split(", ");
                    // Check if the line has 7 fields (studentId, firstName, lastName, courseId, courseName, term, year)
                    if (values.length != 7) {
                        // Append error message to error report and increment failure count
                        errorReport.append("Line #").append(lineNum).append(": ").append("Invalid number of fields\n");
                        failureCount++;
                        continue;
                    }

                    // Extract values from the line
                    String studentIdStr = values[0], firstName = values[1], lastName = values[2];
                    String courseId = values[3], courseName = values[4], termStr = values[5], yearStr = values[6];

                    // Try to add student and course to the database
                    try {
                        // Validate each field using Validator class methods and throw exception if invalid
                        if (!Validator.validateStudentId(studentIdStr)) {
                            throw new IllegalArgumentException("Invalid studentId");
                        }
                        if (!Validator.validateCourseId(courseId)) {
                            throw new IllegalArgumentException("Invalid courseId");
                        }
                        if (!Validator.validateTerm(termStr)) {
                            throw new IllegalArgumentException("Invalid term");
                        }
                        if (!Validator.validateYear(Integer.parseInt(yearStr))) {
                            throw new IllegalArgumentException("Invalid year");
                        }

                        // Convert string to integer and enroll student in course
                        int studentId = Integer.parseInt(studentIdStr);
                        int term = Validator.convertTerm(termStr);
                        int year = Integer.parseInt(yearStr);

                        // Add student if it doesn't exist
                        Student student = studentDAO.getStudentById(studentId);
                        if (student == null) {
                            student = new Student(studentId, firstName, lastName);
                            studentDAO.addStudent(student);
                        }

                        // Add course if it doesn't exist
                        Course course = courseDAO.getCourseById(courseId);
                        if (course == null) {
                            course = new Course(courseId, courseName);
                            courseDAO.addCourse(course);
                        }

                        // Enroll student in course
                        studentCourseDAO.enrollStudentInCourse(studentId, courseId, term, year);
                        successCount++;
                    } catch (NumberFormatException e) {
                        errorReport.append("Line #").append(lineNum).append(": Invalid data type\n");
                        failureCount++;
                    } catch (IllegalArgumentException e) {
                        errorReport.append("Line #").append(lineNum).append(": ").append(e.getMessage()).append("\n");
                        failureCount++;
                    } catch (SQLException e) {
                        errorReport.append("Line #").append(lineNum).append(": SQL Exception\n");
                        failureCount++;
                    }
                }
            }

            try {
                // Generate reports
                generateSuccessReport(successCount);
                generateErrorReport(errorReport.toString(), failureCount);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close connection if not null
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generate success report
    private static void generateSuccessReport(int successCount) throws IOException {
        // Write success report to import-report.md
        try (BufferedWriter successWriter = new BufferedWriter(new FileWriter("./app/data/import-report.md"))) {
            successWriter.write("# Success Report\n");
            successWriter.write("Date and Time: " + LocalDateTime.now() + "\n");
            successWriter.write("Records Successfully Added Total Number: " + successCount + "\n");
        }
    }

    // Generate error report
    private static void generateErrorReport(String errorReportContent, int failureCount) throws IOException {
        // Write error report to error-report.md
        try (BufferedWriter errorWriter = new BufferedWriter(new FileWriter("./app/data/error-report.md"))) {
            errorWriter.write("# Error Report\n");
            errorWriter.write("Date and Time: " + LocalDateTime.now() + "\n");
            errorWriter.write(errorReportContent);
            errorWriter.write("Records Failure Total Number: " + failureCount + "\n");
        }
    }
}




