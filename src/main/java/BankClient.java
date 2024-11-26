/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-22
 * Modified: 2024-11-25
 * Description: Lab assignment 10
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

// Bank class with methods to create account, deposit, withdraw, and get balance
class BankClient {
    // Main method to connect to the server and send commands
    public static void main(String[] args) {
        // Try-with-resources to automatically close resources
        try (Socket socket = new Socket("localhost", 8888);
             // DataInputStream to read data from the server
             DataInputStream din = new DataInputStream(socket.getInputStream());
             // DataOutputStream to write data to the server
             DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
             // BufferedReader to read user input from the console
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server...");
            System.out.println("Available commands:");
            // Display available commands
            System.out.println("1. CREATE <your_account_name>");
            System.out.println("2. DEPOSIT <your_account_name> <amount>");
            System.out.println("3. WITHDRAW <your_account_name> <amount>");
            System.out.println("4. BALANCE <your_account_name>");
            System.out.println("Type 'stop' to disconnect.");

            String command = "";
            // Loop until user types 'stop'
            while (!command.equals("stop")) {
                // Prompt user to enter command
                System.out.print("Enter command: ");
                // Read user input
                command = br.readLine(); // Read user input
                // Send command to server
                dout.writeUTF(command); // Send command to server
                // Flush output stream
                dout.flush();

                // Receive response from server
                String response = din.readUTF(); // Receive response from server
                // Display server response
                System.out.println("Server response: " + response);
            }
        } catch (Exception e) { // Catch any exceptions
            e.printStackTrace();
        }
    }
}

