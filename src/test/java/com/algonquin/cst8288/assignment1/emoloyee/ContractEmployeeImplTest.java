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

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

// ContractEmployeeImplTest class to test the ContractEmployeeImpl class
public class ContractEmployeeImplTest {
    private ContractEmployeeImpl contractEmployeeService;
    private Employee employee;

    @Before
    // setUp method to initialize the contractEmployeeService and employee objects
    public void setUp() {
        contractEmployeeService = new ContractEmployeeImpl();
        employee = new Employee();
        employee.setSalary(60000);
    }

    @Test
    // calculateTotalCompensation method to test the calculateTotalCompensation method
    public void calculateTotalCompensation() {
        double expectedCompensation = 60000; // Since it's a contract employee, total compensation is just the salary
        double actualCompensation = contractEmployeeService.calculateTotalCompensation(employee);
        assertEquals(expectedCompensation, actualCompensation, 0.01);
    }

    @Test
    // getSalary method to test the getSalary method
    public void getSalary() {
        double expectedSalary = 60000;
        double actualSalary = contractEmployeeService.getSalary(employee);
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    // renewalDate method to test the renewalDate method
    public void renewalDate() {
        Date renewalDate = contractEmployeeService.renewalDate();
        assertNotNull(renewalDate);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expectedDate = calendar.getTime();


        long differenceInMillis = Math.abs(expectedDate.getTime() - renewalDate.getTime());
        long allowedDifferenceInMillis = 3000; // 3 second

        // Check if the difference is less than or equal to 3 seconds
        assertTrue(differenceInMillis <= allowedDifferenceInMillis);

        // assertEquals(expectedDate, renewalDate);
    }
}