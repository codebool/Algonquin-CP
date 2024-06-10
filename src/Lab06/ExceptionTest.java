/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-16
 * Modified: 2024-06-09
 * Description: Lab assignment 6
 */

package Lab06;

import java.util.Scanner;

// Custom exception class
public class ExceptionTest {
    // Quotient method that throws an ArithmeticException, which is a built-in exception
    public static int quotient(int numerator, int denominator) {
        // If the denominator is 0, throw an ArithmeticException
        return numerator / denominator;
    }

    // Main method to test the quotient method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // try block to catch exceptions
        try {
            System.out.print("Please enter an integer numerator: ");
            int numerator = scanner.nextInt();
            // If the numerator is less than or equal to 0, throw an InvalidInputException
            if(numerator <= 0) {
                throw new InvalidInputException("You must enter positive numbers");
            }

            System.out.print("Please enter an integer denominator: ");
            int denominator = scanner.nextInt();
            // If the denominator is less than or equal to 0, throw an InvalidInputException
            if(denominator <= 0) {
                throw new InvalidInputException("You must enter positive numbers");
            }
            int result = quotient(numerator, denominator);
            System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
        } catch (ArithmeticException | InvalidInputException e) { // using multi-catch here to catch multiple exceptions
            // Print the error message if an exception is caught
            System.out.println("Error: " + e.getMessage());
        }
    }
}
