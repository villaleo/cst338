/*
 * Title: CheckingAccount.java
 * Abstract: This class simulates a checking account, which is a derived class of the
 *           `Account` base class. Users are able to access the monthly fee method,
 *           as well as the inherited members from the base class. The monthly fee
 *           is accumulated per method invocation (withdraw and deposit).
 * Author: Leonardo Villalobos
 * Date: 03/20/22
 */

package Homeworks.HW5;

public class CheckingAccount extends Account {
    private double monthlyFee;
    private double invocations = 0;

    private void calculateMonthlyFeePayment() {
        this.monthlyFee *= this.invocations;
    }

    public CheckingAccount(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    // Include a method that subtracts the monthly fee from the account balance.
    public void payMonthlyFee() {
        this.setBalance(this.getBalance() - monthlyFee);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        this.invocations++;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        this.invocations++;
    }

    public double getMonthlyFee() {
        this.calculateMonthlyFeePayment();
        this.payMonthlyFee();
        return this.monthlyFee;
    }
}
