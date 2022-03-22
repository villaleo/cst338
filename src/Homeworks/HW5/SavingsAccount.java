/*
 * Title: SavingsAccount.java
 * Abstract: This class simulates a savings account, which is a derived class of the
 *           `Account` base class. Users are able to access the monthly interest
 *           payment as well as the inherited members from the base class.
 * Author: Leonardo Villalobos
 * Date: 03/20/22
 */

package Homeworks.HW5;

public class SavingsAccount extends Account {
    private final double monthlyInterestRate;
    private double monthlyInterestPayment = 0;

    // The monthly interest payment should be calculated by a method that applies
    // the payment to the account balance.
    private void calculateInterestPayment() {
        this.monthlyInterestPayment = this.getBalance() * this.monthlyInterestRate;
    }

    private void receiveInterest() {
        this.setBalance(this.getBalance() + this.monthlyInterestPayment);
    }

    public SavingsAccount(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public double getInterestPayment() {
        this.calculateInterestPayment();
        this.receiveInterest();
        return this.monthlyInterestPayment;
    }
}
