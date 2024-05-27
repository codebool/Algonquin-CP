/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-02
 * Modified: 2024-05-26
 * Description: Lab assignment 04
 */

package Lab04;

public class BasePlusCommissionEmployee {
    private double baseSalary; // base salary per week
    private final CommissionEmployee commissionEmployee;

    // six-argument constructor
    public BasePlusCommissionEmployee(String first, String last,
                                      String ssn, double sales, double rate, double salary) {
        // construct the CommissionEmployee object
        this.commissionEmployee = new CommissionEmployee(first, last, ssn, sales, rate);
        setBaseSalary(salary); // validate and store base salary
    }

    // get first name
    public String getFirstName() {
        /* get the first name of the composed CommissionEmployee object */
        return commissionEmployee.getFirstName();
    }

    // get last name
    public String getLastName() {
        /* get the last name of the composed CommissionEmployee object */
        return commissionEmployee.getLastName();
    }

    // get social security number
    public String getSocialSecurityNumber() {
        /* get the social security number of the composed CommissionEmployee object */
        return commissionEmployee.getSocialSecurityNumber();
    }

    // get gross sales amount
    public double getGrossSales() {
        /* get the gross sales amount of the composed CommissionEmployee object */
        return commissionEmployee.getGrossSales();
    }

    // set gross sales amount
    public void setGrossSales(double sales) {
        /* set the gross sales amount of the composed CommissionEmployee object */
        commissionEmployee.setGrossSales(sales);
    }

    // get commission rate
    public double getCommissionRate() {
        /* get the commission rate of the composed CommissionEmployee object */
        return commissionEmployee.getCommissionRate();
    }

    // set commission rate
    public void setCommissionRate(double rate) {
        /* set the commission rate of the composed CommissionEmployee object */
        commissionEmployee.setCommissionRate(rate);
    }

    // get base salary
    public double getBaseSalary() {
        /* get the base salary of the composed CommissionEmployee object */
        return baseSalary;
    }

    // set base salary
    public void setBaseSalary(double salary) {
        /* validate and store base salary */
        baseSalary = (salary < 0.0) ? 0.0 : salary;
    }

    // calculate earnings
    public double earnings() {
        /* calculate the earnings of the composed CommissionEmployee object */
        return baseSalary + commissionEmployee.earnings();
    }

    // return String representation of BasePlusCommissionEmployee object
    public String toString() {
          /* Return a string consisting of the string representation of the composed
        CommissionEmployee object along with the base salary */
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "commission employee", getFirstName(), getLastName(),
                "social security number", getSocialSecurityNumber(),
                "gross sales", commissionEmployee.getGrossSales(),
                "commission rate", commissionEmployee.getCommissionRate(),
                "base salary", baseSalary,
                "earnings", earnings());
    }
}
