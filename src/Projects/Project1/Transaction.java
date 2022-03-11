/**
 * Title: Transaction.java
 * Abstract: This class simulates a Transaction. Each transaction contains the account number,
 *           transaction type, amount, and the time of the transaction itself. Available methods
 *           are instance variable accessors.
 * Author: Leonardo Villalobos
 * Date: 03/11/22
 */

package Projects.Project1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int accountNumber;
    private int transactionType; // 1 for deposit, 2 for withdrawal, 3 for closing account
    private double amount;
    private LocalDateTime transactionTime;

    /**
     * Creates a new transaction object given an account, transaction type, amount, and time.
     * @param account The account that the transaction is being made on.
     * @param transactionType The type of transaction being made.
     * @param amount The amount of the transaction.
     * @param transactionTime The time of the transaction.
     */
    public Transaction(Account account, int transactionType, double amount, LocalDateTime transactionTime) {
        this.accountNumber = account.getAccountNumber();
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionTime = transactionTime;
    }

    /**
     * Creates a new transaction object given an account, transaction type, and amount.
     * @param account The account that the transaction is being made on.
     * @param transactionType The type of transaction being made.
     * @param amount The amount of the transaction.
     */
    public Transaction(Account account, int transactionType, double amount) {
        this.accountNumber = account.getAccountNumber();
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Transaction(Account account, int transactionType, LocalDateTime transactionTime) {
        this.accountNumber = account.getAccountNumber();
        this.transactionType = transactionType;
        this.transactionTime = transactionTime;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public String getTransactionType() {
        if (transactionType == 3)
            return "Account closed";

        String action = switch (transactionType) {
            case 1 -> "Deposit";
            case 2 -> "Withdrawal";
            default -> "Unknown";
        };
        return String.format("%s ($%.2f)", action, amount);
    }

    private String formatTime() {
        var date = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        return transactionTime.format(date);
    }

    @Override
    public String toString() {
        return String.format("\t- Account Number: %d, ", accountNumber) +
                String.format("%s, ", getTransactionType()) +
                String.format("%s%n", formatTime());
    }
}
