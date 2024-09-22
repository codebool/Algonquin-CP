/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;

public class EmployeeController {

    // Method to process and validate an Employee object, then save it to a file
    public String processEmployee(Employee employee) throws IOException {
        // Create an instance of EmployeeProcessor and process the employee
        EmployeeProcessor processor = new EmployeeProcessor();
        processor.process(employee);

        // Create an instance of EmployeeValidator and validate the employee
        EmployeeValidator validator = new EmployeeValidator();
        if (!validator.isValid(employee)) {
            return "FAILED"; // Return "FAILED" if validation fails
        }

        // Create an instance of PersistenceService with a JSONFormatter and save the employee data
        PersistenceService saver = new PersistenceService(new JSONFormatter());
        saver.save(employee, "employee_data.txt");

        return "SUCCESS"; // Return "SUCCESS" if everything is processed correctly
    }

    // Private nested class for processing Employee objects
    private class EmployeeProcessor {
        public void process(Employee employee) {
            // Process data (currently no implementation)
        }
    }

    // Private nested class for validating Employee objects
    private class EmployeeValidator {
        // Method to validate an Employee object
        private boolean isValid(Employee employee) {
            // Check if the name is present and valid
            if (!isPresent(employee.getName())) {
                return false;
            }
            employee.setName(employee.getName().trim());

            // Check if the name is alphanumeric
            if (!isValidAlphaNumeric(employee.getName())) {
                return false;
            }

            // Check if the email is present and valid
            if (employee.getEmail() == null || employee.getEmail().trim().length() == 0) {
                return false;
            }
            employee.setEmail(employee.getEmail().trim());
            if (!isValidEmail(employee.getEmail())) {
                return false;
            }

            // Check if the salary is greater than zero
            if (!isNoSalary(employee.getSalary())) {
                return false;
            }

            // Check if the total compensation is greater than zero
            if (!isNoCompensation(employee.getTotalCompensation())) {
                return false;
            }

            // Check if the number of service years is greater than zero
            if (!isNoServiceYear(employee.getNumberOfServiceYear())) {
                return false;
            }

            return true; // Return true if all validations pass
        }

        // Helper method to check if a string is present
        private boolean isPresent(String value) {
            return value != null && value.trim().length() > 0;
        }

        // Helper method to check if a string is alphanumeric
        private boolean isValidAlphaNumeric(String value) {
            Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
            Matcher matcher = pattern.matcher(value);
            return !matcher.find();
        }

        // Helper method to check if an email is valid
        private boolean isValidEmail(String value) {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(value);
            return matcher.find();
        }

        // Helper method to check if the salary is greater than zero
        private boolean isNoSalary(double salary) {
            return salary > 0;
        }

        // Helper method to check if the total compensation is greater than zero
        private boolean isNoCompensation(double compensation) {
            return compensation > 0;
        }

        // Helper method to check if the number of service years is greater than zero
        private boolean isNoServiceYear(int serviceYear) {
            return serviceYear > 0;
        }
    }
}