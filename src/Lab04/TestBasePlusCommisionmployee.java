/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-28
 * Modified: 2024-05-28
 * Description: Lab assignment
 */

package Lab04;

public class TestBasePlusCommisionmployee {
    public static void main(String[] args) {
        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "Bo", "Qu", "123-456-7890", 4200, .12, 700);

        // get base-salaried commission employee data
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());

        employee.setBaseSalary(1000); // set base salary

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee.toString());
    }
}
