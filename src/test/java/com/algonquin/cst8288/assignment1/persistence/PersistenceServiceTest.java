/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

// PersistenceServiceTest class to test the save method
public class PersistenceServiceTest {
    private Employee employee;
    private PersistenceService persistenceService;

    @Before
    // Set up the test environment
    public void setUp() {
        employee = new Employee();
        employee.setName("Test Employee");
        employee.setEmail("test.employee@example.com");
        employee.setSalary(70000);
        employee.setNumberOfServiceYear(6);

        persistenceService = new PersistenceService(new JSONFormatter());
    }

    @Test
    // save method to test the save method
    public void save() throws IOException {
        String filename = "test_employee_data.txt";
        persistenceService.save(employee, filename);
        assertTrue(Files.exists(Paths.get(filename)));
        Files.deleteIfExists(Paths.get(filename));
    }
}