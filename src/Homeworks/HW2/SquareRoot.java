/*
 * Title: SquareRoot.java
 * Abstract: Given a positive whole number, this program estimates the square root of the
 *           number using a recursive mathematical formula which converges to sqrt(num).
 * Author: Leonardo Villalobos
 * Date: 02/10/2022
 */

package Homeworks.HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {
    public static double calculateGuess(double x, double s) {
        return (x + (s / x)) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println("This program estimates square roots.");
        System.out.println("Please enter a whole number:");
        Scanner buffer = new Scanner(System.in);

        int number = 0;
        boolean validInput = false;
        do {
            try {
                number = buffer.nextInt();
                System.out.println();
                validInput = true;
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a whole number (no words, just numbers):");
                buffer.next();
            }
        } while (!validInput);

        double initialGuess = number / 2.0;
        System.out.printf("Initial guess: %.2f%n", initialGuess);

        // Was struggling in this part-- I know we need to iterate until we meet the condition
        // specified on the document.
        System.out.printf("Guess 2: %f%n", SquareRoot.calculateGuess(initialGuess, number / initialGuess));
    }
}
