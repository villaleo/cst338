/*
 * Title: ArrayListDemo.java
 * Abstract: A class used to demonstrate the ArrayList class and its methods.
 * Author: Leonardo Villalobos
 * Date: 02/23/2022
 */

package Labs.Lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class used to demonstrate the ArrayList class and its methods.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        var toDoList = new ArrayList<String>(20);
        var buffer = new Scanner(System.in);
        String next, answer;

        System.out.println("Enter list entries, when prompted.");
        do {
            System.out.println("Input an entry:");
            next = buffer.nextLine();
            toDoList.add(next);

            System.out.print("More items? (y/n)");
            answer = buffer.nextLine();
        } while (!answer.equalsIgnoreCase("n"));

        System.out.println("The list contains:");
        for (String entry : toDoList) System.out.println(entry);

        System.out.println("An item to search:");
        next = buffer.nextLine();
        System.out.println(next + " is " + (toDoList.contains(next)?  "in": "not in") + " the list.");

        System.out.println("An item to remove:");
        next = buffer.nextLine();
        System.out.println(next + " was " + (toDoList.remove(next)? "removed": "not removed") + " from the list.");

        System.out.println("The list contains:");
        for (String entry : toDoList) System.out.println(entry);
    }
}
