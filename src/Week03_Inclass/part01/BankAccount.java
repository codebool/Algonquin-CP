/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-21
 * Modified: 2024-05-21
 * Description: Lab assignment
 */

package Week03_Inclass.part01;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;
    private static int accountCounter = 0;
    private AccountType accountType;

    public BankAccount(String accountNumber, String accountHolderName, BigDecimal initialBalance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    public BankAccount(String accountNumber, String accountHolderName, AccountType accountType) {
        this(accountNumber, accountHolderName, BigDecimal.ZERO, accountType);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (amount.compareTo(balance) > 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance = balance.subtract(amount);
    }

    public static int getNextAccountNumber() {
        return ++accountCounter;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}

