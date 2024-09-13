/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-13
 * Modified: 2024-09-13
 * Description: Lab assignment
 */

package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Calendar;
import java.util.Date;

public class ContractEmployeeImpl implements ContractEmployeeService {
    @Override
    public double calculateTotalCompensation(Employee employee) {
        return getSalary(employee);
    }

    @Override
    public double getSalary(Employee employee) {
        return employee.getSalary();
    }

    @Override
    public Date renewalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }
}
