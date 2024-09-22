/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.emoloyee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Test class for PermanentEmployeeImpl
public class PermanentEmployeeImplTest {
    private PermanentEmployeeImpl permanentEmployeeService;
    private Employee employee;

    @Before
    // Set up the test environment
    public void setUp() {
        permanentEmployeeService = new PermanentEmployeeImpl();
        employee = new Employee();
        employee.setSalary(80000);
        employee.setNumberOfServiceYear(10);
    }

    @Test
    // Test the pensionContribution method
    public void pensionContribution() {
        double expectedContribution = 800; // 1% of salary
        double actualContribution = permanentEmployeeService.pensionContribution(employee);
        assertEquals(expectedContribution, actualContribution, 0.01);
    }

    @Test
    // Test the calculateBonus method
    public void calculateBonus() {
        double expectedBonus = 20000; // 2.5% of salary * years of service
        double actualBonus = permanentEmployeeService.calculateBonus(employee);
        assertEquals(expectedBonus, actualBonus, 0.01);
    }

    @Test
    // Test the calculateTotalCompensation method
    public void calculateTotalCompensation() {
        double expectedCompensation = 100000; // Salary + Bonus
        double actualCompensation = permanentEmployeeService.calculateTotalCompensation(employee);
        assertEquals(expectedCompensation, actualCompensation, 0.01);
    }

    @Test
    // Test the getSalary method
    public void getSalary() {
        double expectedSalary = 80000;
        double actualSalary = permanentEmployeeService.getSalary(employee);
        assertEquals(expectedSalary, actualSalary, 0.01);
    }
}