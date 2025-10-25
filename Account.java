// File: com/digitalbank/finance/Account.java
package com.digitalbank.finance;

/** Class  Represents a customer's bank account with strict encapsulation rules keeping details secure */
public class  Account {

    // A Stores key details securely so they cannot be accessed directly.
    // Use 'private' modifier to restrict direct access to external code.
    private long accountNumber;
    private double balance;
    private String customerID; // A unique, sensitive identifier

    /*Constructor initializes a new account.*/
    public Account(long accountNumber, String customerID, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = initialBalance;
        System.out.println("New Account created for Customer: " + customerID);
    }

    // B. Provide a way to retrieve details (read-only access).

    /*Public getter method to retrieve the balance. Allows anyone to view the balance but not modify it. */
    public double getBalance() {
        return this.balance;
    }

    /** Public getter method to retrieve the (read-only) account number.*/
    public long getAccountNumber() {
        return this.accountNumber;
    }

    /** Public controlled operation for depositing funds.Authorized way to modify the balance.*/
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful. Current balance: " + this.balance);
        } else {
            System.out.println("Deposit failed. Amount must be positive.");
        }
    }

    /*Public controlled operation for withdrawing funds.Prevents unauthorized balance modification */
    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + this.balance);
            return true;
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
            return false;
        }
    }

    /**Protected setter to update the balance.
     * This method can ONLY be accessed by classes within the 'com.digitalbank.finance' package
     * or by subclasses, ensuring it is a restricted, system-level operation.
     */
    protected void applySystemCorrection(double adjustment) {
        this.balance += adjustment;
        System.out.println("System adjustment applied. New balance: " + this.balance);
    }
}
