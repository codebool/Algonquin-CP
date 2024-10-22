/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.model;

// StudentCourse class
public class StudentCourse {
    private int studentId;
    private String courseId;
    private int term;
    private int year;

    // constructor with four parameters
    public StudentCourse(int studentId, String courseId, int term, int year) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.term = term;
        this.year = year;
    }

    // getter and setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    // override toString method
    public String toString() {
        return "StudentCourse [studentId: " + studentId + ", courseId: " + courseId + ", term: " + term + ", year: " + year + "]";
    }
}
