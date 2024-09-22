/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// PersistenceService class to save the
public class PersistenceService {
    private Formatter formatter;

    // Constructor of PersistenceService
    public PersistenceService(Formatter formatter) {
        this.formatter = formatter;
    }

    // Save the employee object to the file
    public void save(Employee employee, String filename) throws IOException {
        // Use the formatter to format the employee object
        Formatter formatter = new JSONFormatter();
        // Write the formatted employee object to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            // Write the formatted employee object to the file
            writer.println(formatter.format(employee));
            // Flush the writer
            writer.flush();
        }
    }
}
