import java.util.Scanner;

/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-11
 * Modified: 2024-09-11
 * Description: SOLID Principles - Dependency Inversion Principle (DIP)
 */

interface InputDevice {
    String fetchInput();
}

class KeyboardInput implements InputDevice {
    @Override
    public String fetchInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

class InputHandler {
    public void displayUppercase(InputDevice inputDevice) {
        String input = inputDevice.fetchInput();
        System.out.println(input.toUpperCase());
    }
}
