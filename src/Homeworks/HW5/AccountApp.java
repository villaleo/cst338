/*
 * Title: AccountApp.java
 * Abstract: This class simply demos the `CheckingAccount` and `SavingsAccount`
 *           classes by requesting user input to enter some input into the accounts.
 * Author: Leonardo Villalobos
 * Date: 03/20/22
 */

package Homeworks.HW5;

import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {
        var buffer = new Scanner(System.in);
        System.out.println("Welcome to the Account application\n");

        System.out.print("Enter initial Checking amount: ");
        double checkingAmount = buffer.nextDouble();
        System.out.print("Enter initial Savings amount: ");
        double savingsAmount = buffer.nextDouble();

        System.out.print("Enter Checking fee: ");
        double checkingFee = buffer.nextDouble();
        System.out.print("Enter Savings interest rate: ");
        double savingsInterestRate = buffer.nextDouble();

        System.out.println("\nOK! This is your information");
        System.out.printf("Checking Amount: $%,.2f\n", checkingAmount);
        System.out.printf("Savings Amount: $%,.2f\n", savingsAmount);
        System.out.printf("Checking Fee: $%,.2f\n", checkingFee);
        System.out.printf("Interest Rate: %.0f%%\n", savingsInterestRate * 100);

        System.out.println("\nEnter the transactions for the month\n");

        var savings = new SavingsAccount(savingsInterestRate);
        savings.setBalance(savingsAmount);
        var checking = new CheckingAccount(checkingFee);
        checking.setBalance(checkingAmount);

        char moreQueries;
        do {
            System.out.print("Withdraw or deposit? (w/d): ");
            char actionSelection = buffer.next().charAt(0);
            System.out.print("Checking or Savings? (c/s): ");
            char accountTypeSelection = buffer.next().charAt(0);
            System.out.print("Amount?: ");
            double transactionAmount = buffer.nextDouble();

            Account target = accountTypeSelection == 'c'? checking : savings;
            if (actionSelection == 'w') {
                target.withdraw(transactionAmount);
            } else {
                target.deposit(transactionAmount);
            }

            System.out.print("\nContinue? (y/n): ");
            moreQueries = buffer.next().charAt(0);
            System.out.println();
        } while (moreQueries == 'y');

        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("Checking fee:\t\t\t\t$%,.2f\n", checking.getMonthlyFee());
        System.out.printf("Savings interest payment:\t$%,.2f\n", savings.getInterestPayment());

        System.out.println("\nFinal Balances");
        System.out.printf("Checking: $%,.2f\n", checking.getBalance());
        System.out.printf("Savings: $%,.2f\n", savings.getBalance());
    }
}
