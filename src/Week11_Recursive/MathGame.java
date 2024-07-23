/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-23
 * Modified: 2024-07-23
 * Description: Lab assignment
 */

package Week11_Recursive;

import java.math.BigInteger;
import java.util.Scanner;

public class MathGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Math is fun!!!!");

        System.out.println("Choose a game mode:");
        System.out.println("1. Guess the Fibonacci Number");
        System.out.println("2. Calculate the Factorial");
        System.out.println("3. Towers of Hanoi");
        System.out.println("4. Generate Koch Curve Fractal");

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                playFibonacciGame(scanner);
                break;
            case 2:
                playFactorialGame(scanner);
                break;
            case 3:
                playTowersOfHanoi(scanner);
                break;
            case 4:
                generateKochCurveFractal(scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting Game!!!");
                break;
        }
    }

    private static void playFactorialGame(Scanner scanner) {
        System.out.println("Enter a number to calculate the factorial:");
        int number = scanner.nextInt();
        BigInteger factorialResult = factorial(number);
        System.out.println("The factorial of " + number + " is " + factorialResult);
    }

    private static BigInteger factorial(int number) {
        if (number == 0 || number == 1) {
            return BigInteger.ONE;
        } else if(number < 0) {
            return BigInteger.ZERO; // negative number factorial is 0, but it is not defined actually!!
        }
        else {
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        }
    }

    private static void playFibonacciGame(Scanner scanner) {
        System.out.println("Enter a number to calculate the Fibonacci:");
        int number = scanner.nextInt();
        BigInteger fibonacciResult = fibonacci(number);
        System.out.println("The Fibonacci of " + number + " is " + fibonacciResult);
    }

    // 1,1,2,3,5,8,13,21,34,55,89,144,233,377,610... number is the index in the sequence, so 8->21
    private static BigInteger fibonacci(int index) {
        if (index == 0) {
            return BigInteger.ZERO;
        } else if (index == 1) {
            return BigInteger.ONE;
        } else {
            return fibonacci(index - 1).add(fibonacci(index - 2));
        }
    }

    private static void playTowersOfHanoi(Scanner scanner) {
        System.out.println("Towers of Hanoi: Solve the puzzle!");
        System.out.println("Enter the number of disks:");
        int numberOfDisks = scanner.nextInt();
        solveTowerOfHanoi(numberOfDisks, 'A', 'C', 'B');
    }

    private static void solveTowerOfHanoi(int num, char fromPeg, char toPeg, char auxPeg) {
        if (num == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        solveTowerOfHanoi(num - 1, fromPeg, auxPeg, toPeg); // move n-1 disks from A to B using C
        System.out.println("Move disk " + num + " from peg " + fromPeg + " to peg " + toPeg);
        solveTowerOfHanoi(num - 1, auxPeg, toPeg, fromPeg); // move n-1 disks from B to C using A
    }

    private static void generateKochCurveFractal(Scanner scanner) {
        System.out.println("Koch Curve Fractal: Generate the fractal drawing!");
        System.out.println("Enter the number of iterations for the Koch Curve:");
        int iterations = scanner.nextInt();
        System.out.println("Enter the length of the line:");
        int length = scanner.nextInt();
        drawKochCurve(iterations);
    }

    private static void drawKochCurve(int iterations) {
        if(iterations == 0) {
            System.out.println("Base case: drawing a straight line segment");
            return;
        }

        System.out.println("Divide the line segment into 4 segments and draw the Koch curve recursively");
    }
}
