package Labs.Lab2;

import java.util.Scanner;

/*
 * Title: Factorial.java
 * Abstract: Displays the factorial of a given input, along with the steps used to
 *           reach that calculation.
 * Author: Leonardo Villalobos
 * Date: Feb 7, 2022
 */

public class Factorial {
    public static int factorial(int n) {
        if (n <= 0) {
            System.out.print("--> ");
            return 1;
        }
        if (n == 1) {
            System.out.print("1 ");
            return n * factorial(0);
        }
        System.out.print(n + " * ");
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        String selection;
        do {
            Scanner buffer = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = buffer.nextInt();

            if (number < 0)
                System.out.println("Invalid input.");
            else {
                System.out.print(number + "! --> ");
                int result = factorial(number);
                System.out.println(result);
            }
            System.out.print("Try again? (Y/N) ");
            selection = buffer.next();

        } while (!selection.equals("N"));
        System.out.println("Bye.");
    }
}
