package Lab02; /**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-17
 * Modified: 2024-05-17
 * Description: Lab assignment 2
 */

import java.util.Scanner;

public class Unique {
    // Gets 5 unique numbers from the user
    public void getNumbers() {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5]; // Array to store the unique numbers
        int entered = 0; // Number of entered numbers

        while (entered < 5) {
            System.out.print("Enter number: ");
            int number = input.nextInt();

            // Validate the input
            if (number >= 10 && number <= 100) {
                // Check if the number has already been entered
                if (!contains(numbers, number, entered)) {
                    numbers[entered] = number;
                    entered++;
                } else {
                    System.out.printf("%d has already been entered\n", number);
                }
            } else {
                System.out.println("Number must be between 10 and 100");
            }

            // Print the list of unique values
            System.out.print("Unique numbers so far: ");
            for (int i = 0; i < entered; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
    }

    // Check if the number has already been entered
    private boolean contains(int[] numbers, int number, int entered) {
        // Loop through the entered numbers
        for (int i = 0; i < entered; i++) {
            // Check if the number has already been entered
            if (numbers[i] == number) {
                return true;
            }
        }
        // Return false if the number has not been entered
        return false;
    }

    public static void main(String[] args) {
        Unique application = new Unique();
        application.getNumbers();
    }
}