package Week07_File;

import java.io.*; // Import required classes for IO operations

// Define a class named 'FileReaderExampleBIN'
public class FileReaderExampleBIN {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) {

        // Step 1: Specify the binary file you want to read from.
        // Create a 'File' object and pass the name of the file as a parameter to its constructor.
        // This will create a new File instance for "data.bin".
        File file = new File("data.bin"); // The binary file that was created by FileHandlerBIN

        // Step 2: Use 'ObjectInputStream' to read the content from the binary file.
        // 'ObjectInputStream' is used to read objects from an InputStream in binary format.
        try (
                // Create a FileInputStream to read bytes from the specified file
                FileInputStream fis = new FileInputStream(file);

                // Create an ObjectInputStream to read objects from the FileInputStream
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {

            // Step 3: Read the object from the binary file.
            // The 'readObject' method of the ObjectInputStream class reads an object from the InputStream.
            // For this example, we expect the object to be an array of integers, so we typecast the result accordingly.
            int[] data = (int[]) ois.readObject();

            // Step 4: Print out each element of the array.
            // Use an enhanced for loop to iterate through the array and print each element.
            for (int i : data) {
                System.out.println(i);
            }
        } catch (IOException | ClassNotFoundException e) { // This block catches any IOExceptions or ClassNotFoundExceptions that may be thrown.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}