/**
 * Title: Bank2.java
 * Abstract: Defines a bank with methods to add, close, and display accounts.
 * Author: Leonardo Villalobos
 * Date: 02/16/22
 */

package Labs.Lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank2 {
    private final Account2[] accounts;
    private static final int CAPACITY = 3;
    private String bankName;
    private int numberOfAccounts;

    public Bank2() {
        accounts = new Account2[CAPACITY];
        numberOfAccounts = 0;
    }

    public ArrayList<Account2> getAccounts() {
        var out = new ArrayList<Account2>();
        for (var account: accounts) {
            if (account != null) out.add(account);
        }
        return out;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Open a new account.
     * Enables a user to type the account holder’s name, account number, account type, and initial balance.
     *
     * @return false if the account number is already in use or if the number of accounts is already at the maximum.
     */
    public boolean openAccount() {
        var buffer = new Scanner(System.in);
        if (numberOfAccounts == CAPACITY) return false;

        System.out.print("Enter account holder's name: ");
        String accountHolderName = buffer.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = buffer.nextInt();

        System.out.print("Enter account type: ");
        int accountType = buffer.nextInt();

        System.out.print("Enter initial balance: ");
        double initialBalance = buffer.nextDouble();

        for (var account: accounts) {
            if (account != null && account.getNumber() == accountNumber) return false;
        }
        accounts[numberOfAccounts++] = new Account2(accountHolderName, accountNumber, accountType, initialBalance);
        return true;
    }

    /**
     * Remove an account from the list of accounts.
     *
     * @param accountNumber the account number
     * @return false if accountNumber doesn't exist, otherwise true.
     */
    public boolean closeAccount(int accountNumber) {
        if (numberOfAccounts == 0) return true;
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i] == null) continue;
            if (accounts[i].getNumber() == accountNumber) {
                accounts[i] = null;
                return true;
            }
        }
        return false;
    }

    public void printAccounts() {
        for (var account: accounts) {
            if (account != null) {
                System.out.println(account);
            }
        }
    }
}
