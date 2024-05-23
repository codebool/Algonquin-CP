package Lab03; 
/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-26
 * Modified: 2024-05-23
 * Description: Lab assignment 3
 */

import java.util.Scanner;

public class Time2Test {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Time2 time = new Time2();
        int choice = getMenuChoice();
        while (choice != 5) {
            switch (choice) {
                case 1: //set hour
                    System.out.print("Enter hour: ");
                    int hour = input.nextInt();
                    // Write code here that sets the hour. If the hour is invalid, display an error message.
                    if (time.setHour(hour)) {
                        System.out.println("Hour set successfully.");
                    } else {
                        System.out.println("Invalid hour.");
                    }
                    break;
                case 2: //set minute
                    System.out.print("Enter minute: ");
                    int minute = input.nextInt();
                    // Write code here that sets the minute. If the minute is invalid, display an error message.
                    if (time.setMinute(minute)) {
                        System.out.println("Minute set successfully.");
                    } else {
                        System.out.println("Invalid minute.");
                    }
                    break;
                case 3: //set second
                    System.out.print("Enter second: ");
                    int second = input.nextInt();
                    // Write code here that sets the second. If the second is invalid, display an error message.
                    if (time.setSecond(second)) {
                        System.out.println("Second set successfully.");
                    } else {
                        System.out.println("Invalid second.");
                    }
                    break;
                case 4: // add 1 second
                    time.tick();
                    break;
            }
            System.out.printf( "Hour: %d  Minute: %d  Second: %d\n", time.getHour(), time.getMinute(), time.getSecond() );
            System.out.printf( "Universal time: %s   Standard time: %s\n", time.toUniversalString(), time.toString() );

            choice = getMenuChoice();
        }
    }

    // prints a menu and returns a value corresponding to the menu choice
    public static int getMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Set Hour");
        System.out.println("2. Set Minute");
        System.out.println("3. Set Second");
        System.out.println("4. Add 1 second");
        System.out.println("5. Exit");
        System.out.print("Choice: ");
        
        return input.nextInt();
    }
}