/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment
 */

package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceService {
    private Formatter formatter;

    public PersistenceService(Formatter formatter) {
        this.formatter = formatter;
    }

    public void save(Employee employee, String filename) throws IOException {
        Formatter formatter = new JSONFormatter();
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(formatter.format(employee));
            writer.flush();
        }
    }
}
