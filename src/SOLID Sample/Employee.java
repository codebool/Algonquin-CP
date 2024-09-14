import java.util.Date;

/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-06
 * Modified: 2024-09-06
 * Description: SOLID Principles - Single Responsibility Principle (SRP)
 */

public class Employee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

    public Employee(String employeeId, String name, String address, Date dateOfJoining) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}

// HR Promotions: separate class for HR promotions
class HRPromotions {
    public boolean isPromotionDueThisYear(Employee employee) {
        // Logic to check if promotion is due for the employee
        return true; // Example logic
    }
}

// Finance Calculations: separate class for Finance calculations
class FinanceCalculations {
    public double calculateIncomeTaxForCurrentYear(Employee employee) {
        // Logic to calculate tax for the employee
        return 5000.00; // Example logic
    }
}