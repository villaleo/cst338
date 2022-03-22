/*
 * Title: Account.java
 * Abstract: This class simulates an account, which is a parent of the
 *           `CheckingAccount` and `SavingsAccount` child classes. This class
 *           implements three contracts that define how an `account` behaves.
 * Author: Leonardo Villalobos
 * Date: 03/20/22
 */

package Homeworks.HW5;

public class Account implements Balanceable, Depositable, Withdrawable {
    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        this.balance = amount;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
