/*
 * Title: Toy.java
 * Abstract: A dummy class to demonstrate method overriding and the ArrayList class.
 * Author: Leonardo Villalobos
 * Date: 02/23/2022
 */

package Labs.Lab5;

import java.util.ArrayList;

/**
 * A class used as an example to show how to override the equals() method and
 * the ArrayList class.
 */
public class Toy {
    private int number;
    private String name;

    public Toy(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Toy toy) {
            return this.number == toy.number && this.name.equals(toy.name);
        }
        return false;
    }

    public static void main(String[] args) {
        var list = new ArrayList<Toy>();
        Toy tom100 = new Toy(100, "T om");
        Toy tom200 = new Toy(200, "Tom");

        list.add(tom100);
        list.add(tom200);

        Toy tom100_2 = new Toy(100, "Tom");
        System.out.println(tom100.equals(tom100_2)? "Found" : "Not found");
    }
}
