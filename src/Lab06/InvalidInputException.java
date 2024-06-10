/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-16
 * Modified: 2024-06-09
 * Description: Lab assignment 6
 */

package Lab06;

// Custom exception class
public class InvalidInputException extends Exception{
    // Default constructor with a default message
    public InvalidInputException() {
        super("Your input was invalid.");
    }

    // Constructor with a custom message
    public InvalidInputException(String message) {
        super(message);
    }
}
