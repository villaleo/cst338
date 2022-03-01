/*
 * Title: Employee.java
 * Abstract: A class used to model an employee. The main method of this class
 *           demonstrates the use of the Employee class with an ArrayList.
 * Author: Leonardo Villalobos
 * Date: 02/23/2022
 */

package Labs.Lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an employee with a name and ID number.
 */
public class Employee {
    private final int idNum;
    private final String firstName;

    public Employee() {
        this.idNum = 0;
        this.firstName = "";
    }

    public Employee(int idNum, String firstName) {
        this.idNum = idNum;
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee e) {
            return this.idNum == e.idNum && this.firstName.equals(e.firstName);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.idNum, this.firstName);
    }

    public static void main(String[] args) {
        var buffer = new Scanner(System.in);
        var employees = new ArrayList<Employee>();
        int id;
        Employee temp;
        String name, more;

        do {
            System.out.print("Input an ID number: ");
            id = buffer.nextInt();
            System.out.print("Input a name: ");
            buffer.nextLine();
            name = buffer.nextLine();

            employees.add(new Employee(id, name));
            System.out.print("More employees? (y/n): ");
            more = buffer.nextLine();
        } while (more.equalsIgnoreCase("y"));

        System.out.println("The list contains:");
        for (var employee: employees) System.out.println(employee);
        System.out.println();

        do {
            System.out.println("Type the employee ID number and name to search");
            System.out.print("ID number: ");
            id = buffer.nextInt();
            System.out.print("Name: ");
            buffer.nextLine();
            name = buffer.nextLine();

            temp = new Employee(id, name);
            System.out.println(temp + " is " + (employees.contains(temp) ? "" : "not ") + "an employee");

            System.out.print("\nAnother search? (y/n) ");
            more = buffer.nextLine();
        } while (more.equalsIgnoreCase("y"));

        do {
            System.out.print("Enter the ID number of employee to be fired: ");
            id = buffer.nextInt();
            System.out.print("Enter their name: ");
            buffer.nextLine();
            name = buffer.nextLine();

            temp = new Employee(id, name);
            System.out.println(employees.remove(temp)? temp + " has been fired. (Bye!)" :
                    "Employee not found.");

            System.out.println("\nThe employee list contains:");
            for (var employee: employees) System.out.println(employee);

            System.out.println("\nFire another? (y/n)");
            more = buffer.nextLine();
        } while (more.equalsIgnoreCase("y"));
    }
}
