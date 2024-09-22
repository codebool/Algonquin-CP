/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment 1
 */

package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.controller.Rate;

// Implementation of PermanentEmployeeService
public class PermanentEmployeeImpl implements PermanentEmployeeService {
    @Override
    // Calculate the pension contribution of a permanent employee
    public double pensionContribution(Employee employee) {
        return employee.getSalary() * Rate.PENSION_PERCENTAGE;
    }

    @Override
    // Calculate the bonus of a permanent employee
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * Rate.BONUS_PERCENTAGE * employee.getNumberOfServiceYear();
    }

    @Override
    // Calculate the total compensation of a permanent employee
    public double calculateTotalCompensation(Employee employee) {
        return getSalary(employee) + calculateBonus(employee);
    }

    @Override
    // Get the salary of a permanent employee
    public double getSalary(Employee employee) {
        return employee.getSalary();
    }
}
