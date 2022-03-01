/**
 * Title: Bank2Test_2.java
 * Abstract: This program tests the Bank2 class. It tests the method to close an account
 *           and the method to display all accounts.
 * Author: Leonardo Villalobos
 * Date: 02/16/22
 */

package Labs.Lab4;

public class Bank2Test_2 {
    public static void main(String[] args) {
        Bank2 test2 = new Bank2();

        /// Set bank name to "Central Coast Federal Credit Union"
        test2.setBankName("Central Coast Federal Credit Union");

        /// Attempt to open a new account, "Ruby Chavez"
        /// ** Input **
        // Enter account holder's name: Ruby Chavez
        // Enter account number: 21576
        // Enter account type: 2
        // Enter initial balance: 7623.12
        //
        /// ** Output **
        // Account opened successfully
        //
        // ** Explanation **
        // Read in the user's data. Further details available on Javadoc.
        System.out.println(test2.openAccount()? "\nAccount opened successfully.\n" : "\nAccount not opened.\n");

        /// Attempt to open a new account, "Sky Reed"
        /// ** Input **
        // Enter account holder's name: Sky Reed
        // Enter account number: 432912
        // Enter account type: 1
        // Enter initial balance: 23498.23
        //
        /// ** Output **
        // Account opened successfully
        //
        // ** Explanation **
        // Read in the user's data. Further details available on Javadoc.
        System.out.println(test2.openAccount()? "\nAccount opened successfully.\n" : "\nAccount not opened.\n");

        /// Display all existing accounts.
        /// ** Output **
        // Account name: Ruby Chavez
        // Account number: 21576
        // Account type: 2
        // Balance: $7623.12
        //
        // Account name: Sky Reed
        // Account number: 432912
        // Account type: 1
        // Balance: $23498.23
        //
        /// ** Explanation **
        // We see both accounts, since they each have unique account numbers.
        test2.printAccounts();

        /// Remove all accounts
        var accounts = test2.getAccounts();
        for (var account: accounts) {
            if (test2.closeAccount(account.getNumber())) {
                System.out.println("Account removed: " + account.getNumber());
            } else {
                System.out.println("Account not removed: " + account.getNumber());
            }
        }

        /// Display all existing accounts.
        /// ** Output **
        //
        /// ** Explanation **
        // Nothing is displayed because all accounts have been removed.
        test2.printAccounts();
    }
}
