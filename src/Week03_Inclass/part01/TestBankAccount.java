/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-21
 * Modified: 2024-05-21
 * Description: Lab assignment
 */

package Week03_Inclass.part01;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount savingAccount = new BankAccount("12345", "John Doe", TEN, AccountType.SAVINGS);

        // Depositing Money
        savingAccount.deposit(ONE);
        System.out.println("Balance after deposit: " + savingAccount.getBalance());

        // Withdrawing Money
        try {
            savingAccount.withdraw(new BigDecimal("5.00"));
            System.out.println("Balance after withdrawal: " + savingAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Creating a Checking Account with no initial balance
        BankAccount checkingAccount = new BankAccount("67890", "Jane Smith", AccountType.CHECKING);
        System.out.println("Initial balance of checking account: " + checkingAccount.getBalance());

        // Using ArrayList to store BankAccount objects
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(savingAccount);
        accounts.add(checkingAccount);
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountHolderName() + " has a " + account.getAccountType().getDescription() + " with account number " + account.getAccountNumber() + " and a balance of " + account.getBalance());
        }
    }
}
