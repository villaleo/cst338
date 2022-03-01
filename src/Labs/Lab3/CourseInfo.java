package Labs.Lab3;

import java.util.Scanner;

public class CourseInfo {
    private String courseTitle;
    private String instructor;
    private int enrollment;
    private double average;

    public void printInfo() {
        System.out.println("Course title: " + courseTitle);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrollment: " + enrollment);
        System.out.printf("Average: %.2f%n", average);
    }

    public void readInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter course title: ");
        courseTitle = keyboard.nextLine();
        System.out.print("Enter instructor name: ");
        instructor = keyboard.nextLine();
        System.out.print("Enter enrollment: ");
        enrollment = keyboard.nextInt();

        average = 0;
        for (int i = 0; i < enrollment; i++) {
            System.out.println("Enter a score:");
            int temp = keyboard.nextInt();
            average += temp;
        }
        System.out.println();
        average /= enrollment;
    }
}