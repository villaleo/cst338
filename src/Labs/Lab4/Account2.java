/**
 * Title: Account2.java
 * Abstract: Defines an account with methods to deposit and withdraw money.
 * Author: Leonardo Villalobos
 * Date: 02/16/22
 */

package Labs.Lab4;

public class Account2 {
    private String name;
    private int number;
    private int type;
    private double balance;

    public Account2(String name, int number, int type, double balance){
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

    public boolean deposit(double fund) {
        if (fund < 0.0) {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        } else {
            balance += fund;
            return true;
        }
    }

    public boolean withdrawal(double fund) {
        if (fund > balance) {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        } else {
            balance -= fund;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Account name: " + name + "\nAccount number: " + number + "\n" +
                "Account type: " + type + "\nBalance: $" + balance + "\n";
    }
}