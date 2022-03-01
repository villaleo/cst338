/**
 * Title: Bank2Test_1.java
 * Abstract: This program tests the Bank2 class. It verifies that no two accounts
 *           have the same account number. It also verifies the method to print
 *           the accounts in the bank.
 * Author: Leonardo Villalobos
 * Date: 02/16/22
 */

package Labs.Lab4;

public class Bank2Test_1 {
    public static void main(String[] args) {
        Bank2 test1 = new Bank2();

        /// Set bank name to "Bank of America"
        test1.setBankName("Bank of America");

        /// Attempt to open a new account, "Leonardo Villalobos".
        /// ** Input **
        // Enter account holder's name: Leonardo Villalobos
        // Enter account number: 439823
        // Enter account type: 0
        // Enter initial balance: 9452.77
        //
        /// ** Output **
        // Account opened successfully
        //
        // ** Explanation **
        // Read in the user's data. Further details available on Javadoc.
        System.out.println();
        System.out.println(test1.openAccount()? "Account opened successfully." : "Account not opened.");

        /// Display all existing accounts.
        /// ** Output **
        // Account name: Leonardo Villalobos
        // Account number: 439823
        // Account type: 0
        // Balance: $9452.77
        //
        /// ** Explanation **
        // We only have one account, so we only see the details for that one account.
        test1.printAccounts();

        /// Attempt to add a new account, "Gregory Juarez".
        /// ** Input **
        // Enter account holder's name: Gregory Juarez
        // Enter account number: 439823
        // Enter account type: 1
        // Enter initial balance: 11238.23
        //
        /// ** Output **
        // Account not opened.
        //
        /// ** Explanation **
        // Account used an existing account number, so it was not registered. See javadoc.
        System.out.println(test1.openAccount()? "Account opened successfully." : "Account not opened.");

        /// Display all existing accounts.
        /// ** Output **
        // Account name: Leonardo Villalobos
        // Account number: 439823
        // Account type: 0
        // Balance: $9452.77
        //
        /// ** Explanation **
        // We still only have the first account since the second was not registered.
        test1.printAccounts();
    }
}
