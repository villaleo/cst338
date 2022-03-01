package Labs.Lab2;

import java.util.Scanner;

/*
 * Title: DrawDiagram.java
 * Abstract: Displays a parallelogram and an isosceles triangle given a size.
 * Author: Leonardo Villalobos
 * Date: Feb 7, 2022
 */

public class DrawDiagram {
    public static void drawParallelogram(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--)
                System.out.print("  ");
            for (int j = 0; j < n; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void drawIsosceles(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner buffer = new Scanner(System.in);
        System.out.print("Enter a length: ");
        int size = buffer.nextInt();

        drawParallelogram(size);
        System.out.println();
        drawIsosceles(size);
    }
}
