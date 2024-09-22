package com.algonquin.cst8288.assignment1.emoloyee;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

public class ContractEmployeeImplTest {
    private ContractEmployeeImpl contractEmployeeService;
    private Employee employee;

    @Before
    public void setUp() {
        contractEmployeeService = new ContractEmployeeImpl();
        employee = new Employee();
        employee.setSalary(60000);
    }

    @Test
    public void calculateTotalCompensation() {
        double expectedCompensation = 60000; // Since it's a contract employee, total compensation is just the salary
        double actualCompensation = contractEmployeeService.calculateTotalCompensation(employee);
        assertEquals(expectedCompensation, actualCompensation, 0.01);
    }

    @Test
    public void getSalary() {
        double expectedSalary = 60000;
        double actualSalary = contractEmployeeService.getSalary(employee);
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void renewalDate() {
        Date renewalDate = contractEmployeeService.renewalDate();
        assertNotNull(renewalDate);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expectedDate = calendar.getTime();


        long differenceInMillis = Math.abs(expectedDate.getTime() - renewalDate.getTime());
        long allowedDifferenceInMillis = 3000; // 3 second

        assertTrue(differenceInMillis <= allowedDifferenceInMillis);

        // assertEquals(expectedDate, renewalDate);
    }
}