/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-16
 * Modified: 2024-07-16
 * Description: Lab assignment
 */

import java.util.*;

// define the StudentManagementSystem class
public class StudentManagementSystem {
    // Use an arraylist to store our students records
    private List<Student> students = new ArrayList<>();

    // Define a method to add a student to the system
    public void addStudent(Student student) {
        students.add(student); // add the student to the list
    }

    // remove a student from the system
    public void removeStudent(int id) {
        // remove the student with the given id
        students.removeIf(student -> student.getId() == id);
    }

    // update student info by their given id
    public void updateStudent(int id, String name, String email, String course) {
        for (Student student : students) {
            if (student.getId() == id) {
                // update the student details
                student.setName(name);
                student.setEmail(email);
                student.setCourse(course);
            }
        }
    }

    public void listStudents() {
        // Use a TreeSet to sort the students by name to store the students
        TreeSet<Student> sortedStudents = new TreeSet<>(Comparator.comparing(Student::getName));
        sortedStudents.addAll(students);
        // print the students in the sorted order by name
        sortedStudents.forEach(System.out::println);
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        sms.addStudent(new Student(1, "Alice Johnson", "alice@school.com", "Computer Science"));
        sms.addStudent(new Student(2, "Bob Bee", "bob@school.com", "Mathematics"));
        sms.addStudent(new Student(3, "Charlie Brown", "charlie@school.com", "Physics"));
        sms.addStudent(new Student(4, "David Smith", "david@school.com", "Chemistry"));
        sms.addStudent(new Student(5, "Eve Williams", "eve@school.com", "Biology"));

        System.out.println("Student List: ");
        sms.listStudents();

        sms.updateStudent(3, "Charlie Charlie", "charlie@school.com", "Mathematics");
        System.out.println("\nUpdated Student List: ");
        sms.listStudents();

        sms.removeStudent(3);
        System.out.println("\nRemoved Student List: ");
        sms.listStudents();
    }

}
