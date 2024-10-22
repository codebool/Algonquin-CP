/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-22
 * Modified: 2024-10-22
 * Description: Lab assignment 02
 */

package org.cst8288Lab2;

// Validator class is added to validate studentId, courseId, term, year
class Validator {
    static int ALGONQUIN_ESTABLISHED_YEAR = 1967;

    public static boolean validateStudentId(String studentId) {
        // studentId must be 9 digits
        return studentId.matches("\\d{9}");
    }

    public static boolean validateCourseId(String courseId) {
        // courseId must be 3 uppercase OR lowercase letters followed by 4 digits
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
