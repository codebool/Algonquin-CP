/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-09
 * Modified: 2024-05-31
 * Description: Lab assignment 5
 */

package Lab05;

// Payable interface test program processing Invoices and Employees polymorphically
public class PayableInterfaceTest {
    // main method
    public static void main(String[] args) {
        Payable[] payableObjects = new Payable[6];
        // populate array with objects that implement Payable, based on the sample output
        payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payableObjects[3] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        payableObjects[4] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
        payableObjects[5] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

        System.out.println("Invoices and Employees processed polymorphically:\n");

        for(Payable currentPayable : payableObjects){
            System.out.printf( "%s \n", currentPayable.toString());
            // determine whether element is a BasePlusCommissionEmployee
            if(currentPayable instanceof BasePlusCommissionEmployee){
                // downcast Payable reference to BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employeeWithBaseSalary = (BasePlusCommissionEmployee) currentPayable;
                // increase base salary by 10%, based on the sample output
                employeeWithBaseSalary.setBaseSalary(1.10 * employeeWithBaseSalary.getBaseSalary());
                System.out.printf("new base salary with 10%% increase is: $%,.2f\n", employeeWithBaseSalary.getBaseSalary());
            }
            System.out.printf( "%s: $%,.2f\n\n", "payment due", currentPayable.getPaymentAmount());
        }
    }
}
