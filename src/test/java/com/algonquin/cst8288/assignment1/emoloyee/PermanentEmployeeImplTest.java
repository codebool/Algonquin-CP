package com.algonquin.cst8288.assignment1.emoloyee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermanentEmployeeImplTest {
    private PermanentEmployeeImpl permanentEmployeeService;
    private Employee employee;

    @Before
    public void setUp() {
        permanentEmployeeService = new PermanentEmployeeImpl();
        employee = new Employee();
        employee.setSalary(80000);
        employee.setNumberOfServiceYear(10);
    }

    @Test
    public void pensionContribution() {
        double expectedContribution = 800; // 1% of salary
        double actualContribution = permanentEmployeeService.pensionContribution(employee);
        assertEquals(expectedContribution, actualContribution, 0.01);
    }

    @Test
    public void calculateBonus() {
        double expectedBonus = 20000; // 2.5% of salary * years of service
        double actualBonus = permanentEmployeeService.calculateBonus(employee);
        assertEquals(expectedBonus, actualBonus, 0.01);
    }

    @Test
    public void calculateTotalCompensation() {
        double expectedCompensation = 100000; // Salary + Bonus
        double actualCompensation = permanentEmployeeService.calculateTotalCompensation(employee);
        assertEquals(expectedCompensation, actualCompensation, 0.01);
    }

    @Test
    public void getSalary() {
        double expectedSalary = 80000;
        double actualSalary = permanentEmployeeService.getSalary(employee);
        assertEquals(expectedSalary, actualSalary, 0.01);
    }
}