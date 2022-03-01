/**
 * Title: Bank.java
 * Abstract: This class simulates a bank. It has a collection of 5 accounts.
 *           Available actions are to open an account, close an account, and update
 *           the balance of an account.
 *           Author: Leonardo Villalobos
 * Date: 02/25/22
 */

package Homeworks.HW4;

/**
 * A Bank class that holds a maximum of 5 accounts.
 */
public class Bank {
    private final String name;
    private final Account[] accounts;

    private final int MAX_ACCOUNTS = 5;
    private int numAccounts = 0;
    private static double totalBalance = 0;

    /**
     * Checks if the SSN is already in use.
     * @param ssn The SSN to check.
     * @return true if the SSN is already in use, false otherwise.
     */
    private boolean duplicateSSN(int ssn) {
        for (Account account : accounts) {
            if (account == null) continue;
            if (account.getAccountHolder().getSsn() == ssn) return true;
        }
        return false;
    }

    /**
     * Checks if the account number is already in use.
     * @param accNum The account number to check.
     * @return true if the account number is already in use, false otherwise.
     */
    private boolean duplicateAccountNum(int accNum) {
        for (Account account : accounts) {
            if (account == null) continue;
            if (account.getAccNum() == accNum) return true;
        }
        return false;
    }

    /**
     * Constructor for the Bank class. Initializes the accounts array.
     * @param name The name of the bank.
     */
    public Bank(String name) {
        this.name = name;
        accounts = new Account[MAX_ACCOUNTS];
    }

    /**
     * Adds an account to the bank. If the bank is full, the account is not added.
     * @param name The name of the account holder.
     * @param addr The address of the account holder.
     * @param ssn The SSN of the account holder.
     * @param accNum The account number of the account holder.
     * @param accType The type of the account.
     * @param balance The balance of the account.
     * @return true if the account was added, false otherwise.
     */
    public boolean openAccount(String name, String addr, int ssn, int accNum, int accType, double balance) {
        if (numAccounts < MAX_ACCOUNTS && ! duplicateSSN(ssn) && ! duplicateAccountNum(accNum)) {
            accounts[numAccounts++] = new Account(accNum, accType, new Customer(name, addr, ssn), balance);
            totalBalance += balance;
        }
        return false;
    }

    /**
     * Closes the account with the given account number. If the account number is not found, nothing happens.
     * @param accNum The account number of the account to close.
     * @return true if the account was closed, false otherwise.
     */
    public boolean closeAccount(int accNum) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i] == null) continue;
            if (accounts[i].getAccNum() == accNum) {
                totalBalance -= accounts[i].getBalance();
                accounts[i] = null;
                numAccounts--;
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the given account. If the account number is not found, nothing happens.
     * @param accNum The account number of the account to display.
     * @return true if the account was displayed, false otherwise.
     */
    public boolean accountInfo(int accNum) {
        Account match;
        for (Account account : accounts) {
            if (account == null) continue;
            if (account.getAccNum() == accNum) {
                match = account;
                System.out.printf("Account Info:\tAccount Number: %d%n", match.getAccNum());
                System.out.println(match.getAccType() == 1? "Checking account" : "Savings account");
                System.out.printf("Balance: $%.2f%n%n", match.getBalance());
                System.out.println(match.getAccountHolder());
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the balance of the account with the given account number.
     * If the account number is not found, nothing happens.
     * @param accNum The account number of the account to update.
     * @param amount The amount to update the balance by.
     * @return true if the account was updated, false otherwise.
     */
    public boolean updateBalance(int accNum, double amount) {
        for (Account account : accounts) {
            if (account == null) continue;
            if (account.getAccNum() == accNum) {
                totalBalance -= account.getBalance();
                account.setBalance(amount);
                totalBalance += account.getBalance();
                return true;
            }
        }
        return false;
    }

    /**
     * Update the address of the account with the given account number.
     * If the account number is not found, nothing happens.
     * @param accNum The account number of the account to update.
     * @param addr The new address of the account.
     * @return true if the account was updated, false otherwise.
     */
    public boolean updateAddress(int accNum, String addr) {
        for (Account account : accounts) {
            if (account == null) continue;
            if (account.getAccNum() == accNum) {
                account.getAccountHolder().setAddress(addr);
                return true;
            }
        }
        return false;
    }

    /**
     * Display the information of the bank. The information includes the total balance of the bank,
     * the number of accounts, and the information of each account.
     */
    void bankInfo() {
        System.out.printf("Bank Name: %s\n", name);
        System.out.printf("Number of Accounts: %d\n", numAccounts);
        for (Account account : accounts) {
            if (account == null) continue;
            System.out.println("\t" + account);
        }
        System.out.printf("Bank Total Balance: $%.2f\n", totalBalance);
    }
}
