/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment
 */

package com.algonquin.cst8288.assignment1.emoloyee;

public class PermanentEmployeeImpl implements PermanentEmployeeService {
    @Override
    public double pensionContribution(Employee employee) {
        return employee.getSalary() * 0.01;
    }

    @Override
    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.025 * employee.getNumberOfServiceYear();
    }

    @Override
    public double calculateTotalCompensation(Employee employee) {
        return getSalary(employee) + calculateBonus(employee);
    }

    @Override
    public double getSalary(Employee employee) {
        return employee.getSalary();
    }
}
