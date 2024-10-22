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
            dbConnection.load(dbConfig);
            String url = dbConnection.getProperty("url");
            String user = dbConnection.getProperty("user");
            String password = dbConnection.getProperty("pass");
            connection = DriverManager.getConnection(url, user, password);
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
            int failureCount = 0;
            int successCount = 0;
            StringBuilder errorReport = new StringBuilder();

            // Read the file using BufferedReader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                int lineNum = 0;
                String line;

                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    lineNum++;
                    // Split the line by comma and space
                    String[] values = line.split(", ");
                    if (values.length != 7) {
                        errorReport.append("Line ").append(lineNum).append(": ").append("Invalid number of fields\n");
                        failureCount++;
                        continue;
                    }

                    // Extract values from the line
                    String studentIdStr = values[0];
                    String firstName = values[1];
                    String lastName = values[2];
                    String courseId = values[3];
                    String courseName = values[4];
                    String termStr = values[5];
                    String yearStr = values[6];

                    try {
                        // Validate each field
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

                        // Convert string to integer
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
                        errorReport.append("Line ").append(lineNum).append(": Invalid data type\n");
                        failureCount++;
                    } catch (IllegalArgumentException e) {
                        errorReport.append("Line ").append(lineNum).append(": ").append(e.getMessage()).append("\n");
                        failureCount++;
                    } catch (SQLException e) {
                        errorReport.append("Line ").append(lineNum).append(": SQL Exception\n");
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
                    // Close connection
                    if (connection != null) connection.close();
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
            successWriter.write("#Success Report\n");
            successWriter.write("Date and Time: " + LocalDateTime.now() + "\n");
            successWriter.write("Records Successfully Added: " + successCount + "\n");
        }
    }

    // Generate error report
    private static void generateErrorReport(String errorReportContent, int failureCount) throws IOException {
        // Write error report to error-report.md
        try (BufferedWriter errorWriter = new BufferedWriter(new FileWriter("./app/data/error-report.md"))) {
            errorWriter.write("# Error Report\n");
            errorWriter.write("Date and Time: " + LocalDateTime.now() + "\n");
            errorWriter.write(errorReportContent);
            errorWriter.write("Records Failure Number: " + failureCount + "\n");
        }
    }
}

// Validator class is added to validate studentId, courseId, term, year
class Validator {
    static int ALGONQUIN_ESTABLISHED_YEAR = 1967;

    public static boolean validateStudentId(String studentId) {
        // studentId must be 9 digits
        return studentId.matches("\\d{9}");
    }

    public static boolean validateCourseId(String courseId) {
        // courseId must be 3 uppercase letters followed by 4 digits
        return courseId.matches("(?i)[a-z]{3}\\d{4}");
    }

    public static boolean validateTerm(String term) {
        // term must be one of WINTER, SUMMER, FALL
        return term.equalsIgnoreCase("WINTER") ||
                term.equalsIgnoreCase("SUMMER") ||
                term.equalsIgnoreCase("FALL");
    }

    // convert term to integer
    public static int convertTerm(String term) {
        switch (term.toUpperCase()) {
            case "WINTER": return 1;
            case "SUMMER": return 2;
            case "FALL": return 3;
            default: throw new IllegalArgumentException("Invalid term: " + term);
        }
    }

    // year must be between 1967 and current year
    public static boolean validateYear(int year) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return year >= ALGONQUIN_ESTABLISHED_YEAR && year <= currentYear;
    }
}


