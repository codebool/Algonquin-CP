/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2.model;

public class StudentCourse {
    private int studentId;
    private String courseId;
    private int term;
    private int year;

    public StudentCourse(int studnetId, String courseId, int term, int year) {
        this.studentId = studnetId;
        this.courseId = courseId;
        this.term = term;
        this.year = year;
    }

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
    public String toString() {
        return "StudentCourse [studentId: " + studentId + ", courseId: " + courseId + ", term: " + term + ", year: " + year + "]";
    }
}
