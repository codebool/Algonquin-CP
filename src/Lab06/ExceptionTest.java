/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-06-16
 * Modified: 2024-06-09
 * Description: Lab assignment 6
 */

package Lab06;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new InvalidInputException("Your input was invalid.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
