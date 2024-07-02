package Week07_File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Define a class named 'FileReaderExample'
public class FileReaderExample {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) {

        // Step 1: Specify the file you want to read from.
        // Create a 'File' object and pass the name of the file as a parameter to its constructor.
        // This will create a new File instance for "example.txt".
        File file = new File("example.txt");

        // Step 2: Use 'Scanner' to read the content from the file.
        // 'Scanner' is a class used to parse and read text from various input sources such as files, strings, etc.
        try (Scanner scanner = new Scanner(file)) { // 'try-with-resources' block is used to automatically close the scanner.

            // Step 3: Read the file line by line.
            // The 'hasNextLine' method of the Scanner class checks if there is another line in the input.
            // The 'nextLine' method reads and returns the next line of the text.
            while (scanner.hasNextLine()) {

                // Print each line to the console.
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) { // This block catches a FileNotFoundException which occurs if the file does not exist.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}