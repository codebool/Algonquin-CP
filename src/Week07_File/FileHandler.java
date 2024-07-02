package Week07_File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Define a class named 'FileHandler'
public class FileHandler {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) {

        // Step 1: Specify the file you want to create or use.
        // Create a 'File' object and pass the name of the file as a parameter to its constructor.
        // This will create a new File instance of "example.txt".
        File file = new File("example.txt");

        // Step 2: Write data to the file using 'FileWriter'.
        // 'FileWriter' is a class used to write text to files.
        try (FileWriter writer = new FileWriter(file)) { // 'try-with-resources' block is used to automatically close the writer.

            // The 'write' method of the FileWriter class writes the specified string to the file.
            writer.write("Hello, World...");

            // Print a message to the console to indicate that writing data to the file was successful.
            System.out.println("File written successfully!");

        } catch (IOException e) { // This block catches any IOExceptions that may be thrown, for example, due to an IO operation failure.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}