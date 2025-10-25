//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter
// File: Main.java
import com.digitalbank.finance.Account;

public class Main {
    public static void main(String[] args) {
        // 1. Create a new secure account
        Account userAccount = new Account(900112345, "CUST789", 600.00);
        System.out.println("---------------------------------");

        System.out.println("Account Number (Read-Only): " + userAccount.getAccountNumber());
        System.out.println("Initial Balance (Read-Only): " + userAccount.getBalance());
        System.out.println("---------------------------------");

        // C. Allow Controlled Operations
        System.out.println("Attempting authorized operations:");
        userAccount.deposit(200.00);  // Success via public method
        userAccount.withdraw(50.00);   // Success via public method
        userAccount.withdraw(1000.00); // Fail due to internal logic check

        System.out.println("---------------------------------");

        System.out.println("\nFinal Balance: " + userAccount.getBalance());
    }
}

