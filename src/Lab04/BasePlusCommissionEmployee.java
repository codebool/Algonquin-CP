/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-24
 * Modified: 2024-05-24
 * Description: Lab assignment 04
 */

package Lab04;

public class BasePlusCommissionEmployee {
    private double baseSalary; // base salary per week

    // six-argument constructor
    public BasePlusCommissionEmployee(String first, String last,
                                      String ssn, double sales, double rate, double salary) {
        /* construct the CommissionEmployee portion of this object */
        setBaseSalary(salary); // validate and store base salary
    }

    // get first name
    public String getFirstName() {
        /* get the first name of the composed CommissionEmployee object */

    }

    // set first name
    public void setFirstName(String first) {
        /* set the first name of the composed CommissionEmployee object */
    }

    // get last name
    public String getLastName() {
        /* get the last name of the composed CommissionEmployee object */
    }

    // set last name
    public void setLastName(String last) {
        /* set the last name of the composed CommissionEmployee object */
    }

    // get social security number
    public String getSocialSecurityNumber() {
        /* get the social security number of the composed CommissionEmployee object */
    }

    // set social security number
    public void setSocialSecurityNumber(String ssn) {
        /* set the social security number of the composed CommissionEmployee object */
    }

    // get gross sales amount
    public double getGrossSales() {
        /* get the gross sales amount of the composed CommissionEmployee object */
    }

    // set gross sales amount
    public void setGrossSales(double sales) {
        /* set the gross sales amount of the composed CommissionEmployee object */
    }

    // get commission rate
    public double getCommissionRate() {
        /* get the commission rate of the composed CommissionEmployee object */
    }

    // set commission rate
    public void setCommissionRate(double rate) {
        /* set the commission rate of the composed CommissionEmployee object */
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
    }

    // return String representation of BasePlusCommissionEmployee object
    public String toString() {
        /* Return a string consisting of the string representation of the composed
        CommissionEmployee object along with the base salary */
    }
}
