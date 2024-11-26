/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-22
 * Modified: 2024-11-25
 * Description: Lab assignment 10
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

// Bank class
class Bank {
    // ConcurrentHashMap to store account names and balances (thread-safe)
    private ConcurrentHashMap<String, Double> accounts = new ConcurrentHashMap<>();

    // Create account with initial balance of 0.0 if it doesn't already exist (thread-safe)
    public synchronized String createAccount(String accountName) {
        if (accounts.containsKey(accountName)) {
            return "Account already exists!";
        }
        accounts.put(accountName, 0.0);
        return "Account created successfully!";
    }

    // Deposit amount to account if it exists (thread-safe)
    public synchronized String deposit(String accountName, double amount) {
        if (!accounts.containsKey(accountName)) {
            return "Account not found!";
        }
        // Update account balance
        accounts.put(accountName, accounts.get(accountName) + amount);
        return "Deposited " + amount + " to " + accountName + ".";
    }

    // Withdraw amount from account if it exists and has sufficient balance (thread-safe)
    public synchronized String withdraw(String accountName, double amount) {
        // Check if account exists
        if (!accounts.containsKey(accountName)) {
            return "Account not found!";
        }
        // Check if account has sufficient balance
        if (accounts.get(accountName) < amount) {
            return "Insufficient balance!";
        }
        // Update account balance
        accounts.put(accountName, accounts.get(accountName) - amount);
        return "Withdrew " + amount + " from " + accountName + ".";
    }

    // Get account balance if it exists (thread-safe)
    public synchronized String getBalance(String accountName) {
        // Check if account exists
        if (!accounts.containsKey(accountName)) {
            return "Account not found!";
        }
        return "Balance for " + accountName + ": " + accounts.get(accountName);
    }
}

// ClientHandler class to handle client requests
class ClientHandler extends Thread {
    private Socket socket;
    private Bank bank;

    // Constructor to initialize socket and bank
    public ClientHandler(Socket socket, Bank bank) {
        this.socket = socket;
        this.bank = bank;
    }

    // Run method to handle client requests
    @Override
    public void run() {
        // Try-with-resources to automatically close resources
        try (DataInputStream din = new DataInputStream(socket.getInputStream());
             // DataOutputStream to send response to client
             DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {

            String str = "";
            while (!str.equals("stop")) {
                // Read command from client and split into parts
                str = din.readUTF();
                String[] parts = str.split(" ");
                String command = parts[0];

                // Process command and send response to client
                String response = switch (command) {
                    // Create account with account name
                    case "CREATE" -> bank.createAccount(parts[1]);
                    // Deposit amount to account
                    case "DEPOSIT" -> bank.deposit(parts[1], Double.parseDouble(parts[2]));
                    // Withdraw amount from account
                    case "WITHDRAW" -> bank.withdraw(parts[1], Double.parseDouble(parts[2]));
                    // Get account balance
                    case "BALANCE" -> bank.getBalance(parts[1]);
                    // Invalid command
                    default -> "Invalid command!";
                };

                // Send response to client
                dout.writeUTF(response);
                // Flush output stream
                dout.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// BankServer class to start server
public class BankServer {
    // Main method to start server
    public static void main(String[] args) throws Exception {
        // Create new bank object
        Bank bank = new Bank();
        // Create new server socket on port 8888
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("Server started...");
        // Accept client connections and start new client handler thread for each client connection
        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected...");
            new ClientHandler(s, bank).start();
        }
    }
}

