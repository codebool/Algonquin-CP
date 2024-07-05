/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-07
 * Modified: 2024-07-05
 * Description: Lab assignment 07
 */

package Lab07;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encryption {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // Prompt user for the file path
        // EXAMPLE  C:\Users\quboc\OneDrive\Desktop\Roles_RoleID.png
        System.out.print("Please enter the file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        // Create an instance of the Encryption class
        Encryption encryption = new Encryption();
        // Call the encrypt method
        try {
            encryption.encrypt(filePath);
            encryption.decrypt(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to rename the file with a suffix
    public static String renameFile(String filePath, String suffix) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf(".");

        String newFileName;
        if(dotIndex == -1) {
            newFileName = fileName + suffix;
        } else {
            newFileName = fileName.substring(0, dotIndex) + suffix + fileName.substring(dotIndex);
        }

        return path.getParent().resolve(newFileName).toString();
    }

    // Method to encrypt the file
    private void encrypt(String inPutFilePath) throws IOException {
        // Rename the file with a suffix
        String outputFilePath = renameFile(inPutFilePath, "Encrypted");

        // Create a BufferedInputStream and BufferedOutputStream
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inPutFilePath));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {

            // Read the file byte by byte
            int byteRead;
            // Encrypt the file by adding 7 to each byte, -1 is the end of the file
            while ((byteRead = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(byteRead + 7);
            }
            System.out.println("The file " + outputFilePath + " has been encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to decrypt the file
    private void decrypt(String inPutFilePath) throws IOException {
        // Rename the file with a suffix to indicate that it is decrypted or encrypted
        String inputFilePath = renameFile(inPutFilePath, "Encrypted");
        String outputFilePath = renameFile(inPutFilePath, "Decrypted");

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFilePath));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {

            int byteRead;
            // Decrypt the file by subtracting 7 from each byte, -1 is the end of the file
            while ((byteRead = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(byteRead - 7);
            }
            System.out.println("The file " + outputFilePath + " has been decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
