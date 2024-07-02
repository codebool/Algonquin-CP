package Week07_File;

import java.nio.file.*; // Import classes for handling file paths and operations
import java.io.IOException; // Import class for handling I/O exceptions
import java.nio.file.attribute.BasicFileAttributes; // Import class to access basic file attributes

// Define a class named 'FileInfo'
public class FileInfo {

    // The main method is the entry point of a Java application.
    public static void main(String[] args) {

        // Step 1: Specify the file you want to get information about.
        // Create a 'Path' object and pass the file name as a parameter to its 'get' method.
        // This will create a new Path instance for "example.txt".
        // The text file should be present in the same level of the SRC folder
        Path path = Paths.get("example.txt");

        // Step 2: Retrieve file attributes using 'Files' class.
        // 'BasicFileAttributes' is an interface that provides a view of basic file attributes.
        try {
            // Use 'readAttributes' method of the 'Files' class to read the basic attributes of the file.
            // The method requires the path to the file and the class representing the attribute view.
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

            // Step 3: Display the retrieved file attributes.
            // Print the file's creation time to the console.
            System.out.println("Creation Time: " + attr.creationTime());

            // Print the file's last modified time to the console.
            System.out.println("Last Modified Time: " + attr.lastModifiedTime());

            // Print the file's size in bytes to the console.
            System.out.println("Size: " + attr.size() + " bytes");

        } catch (IOException e) { // This block catches any IOExceptions that may be thrown, for example, if the file cannot be found or accessed.

            // Print the stack trace to the console if an exception occurs.
            e.printStackTrace();
        }
    }
}