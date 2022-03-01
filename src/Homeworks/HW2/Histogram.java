/*
 * Title: Histogram.java
 * Abstract: Given a specified amount of numbers, this program calculates the occurrence of
 *           each integer and displays a diagram to visualize the amounts of each number.
 * Author: Leonardo Villalobos
 * Date: 02/10/2022
 */

package Homeworks.HW2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        var occurrences = new HashMap<Integer, Integer>();
        var buffer = new Scanner(System.in);
        int amountOfInputs;

        System.out.println("How many input values [max: 30]?");
        amountOfInputs = buffer.nextInt();

        System.out.printf("\nEnter %d numbers.\n", amountOfInputs);
        for (int i = 0; i < amountOfInputs; i++) {
            int number = buffer.nextInt();
            boolean alreadyHasKey = occurrences.containsKey(number);
            occurrences.put(number, !alreadyHasKey? 1: occurrences.get(number) + 1);
        }

        int maxOccurrence = Integer.MIN_VALUE;
        System.out.println("\nNumber\tOccurrence");
        for (var key: occurrences.keySet()) {
            int current = occurrences.get(key);
            if (current > maxOccurrence)
                maxOccurrence = current;
            System.out.println(key + "\t\t" + current);
        }

        System.out.println("\n========= Vertical Bar ========");
        var fillBelow = new ArrayList<Integer>();
        for (int i = maxOccurrence; i >= 1; i--) {
            System.out.print("| " + i + " |  ");
            for (int j = 0; j < 10; j++) {
                if (occurrences.get(j) == null) {
                    System.out.print("  ");
                    continue;
                }
                if (occurrences.get(j) == i) {
                    System.out.print("* ");
                    fillBelow.add(j);
                } else if (fillBelow.contains(j))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("===============================");
        System.out.println("| No | 0 1 2 3 4 5 6 7 8 9");
        System.out.println("===============================");
    }
}
