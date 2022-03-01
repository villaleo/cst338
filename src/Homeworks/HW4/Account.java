/**
 * Title: Account.java
 * Abstract: This class simulates a bank account. It has a number, type, balance,
 *           and a corresponding customer.
 * Author: Leonardo Villalobos
 * Date: 02/25/22
 */

package Homeworks.HW4;

public class Account {
    int accNum;
    int accType;
    double balance;
    Customer accountHolder;

    public Account(int accNum, int accType, Customer accountHolder, double balance) {
        this.accNum = accNum;
        this.accType = accType;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccNum() {
        return accNum;
    }

    public int getAccType() {
        return accType;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return String.format("%d: $%.2f - %s: %s", accNum, balance, accountHolder.getName(), accountHolder.getSsn());
    }

    public double getBalance() {
        return balance;
    }
}
