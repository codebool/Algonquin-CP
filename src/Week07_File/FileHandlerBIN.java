package Week07_File;

import java.io.*; // Import required classes for IO operations

// Define a class named 'FileHandlerBIN'
public class FileHandlerBIN {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) throws FileNotFoundException {

        // Step 1: Specify the binary file you want to create or use.
        // Create a 'FileOutputStream' object and pass the name of the file as a parameter.
        // This will create a new FileOutputStream instance for "data.bin".
        FileOutputStream binOut = new FileOutputStream("data.bin");

        // Step 2: Write binary data to the file using 'ObjectOutputStream'.
        // 'ObjectOutputStream' is used to write objects to an OutputStream in binary format.
        try (ObjectOutputStream objOut = new ObjectOutputStream(binOut)) { // 'try-with-resources' block is used to automatically close the object output stream.

            // The 'writeObject' method of the ObjectOutputStream class writes the specified object to the OutputStream.
            // Here, we are writing an array of integers {1, 2, 3}.
            objOut.writeObject(new int[]{1, 2, 3});

            // Print a message to the console to indicate that writing data to the file was successful.
            System.out.println("File written successfully!");

        } catch (IOException e) { // This block catches any IOExceptions that may be thrown, for example, due to an IO operation failure.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}