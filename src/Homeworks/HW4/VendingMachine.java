/**
 * Title: VendingMachine.java
 * Abstract: This class simulates a vending machine at CSUMB. Available items are
 *           water, coffee, chips, and chocolate. More details are given in the
 *           VendingMachine class documentation.
 * Author: Leonardo Villalobos
 * Date: 02/25/22
 */

package Homeworks.HW4;

import java.util.Scanner;

/**
 * A class called VendingMachine that simulates an imaginary vending machine at CSUMB.
 * A user can buy a bottle of water ($1.50), a coffee ($2.00), a bag of chips ($1.00),
 * or a chocolate bar ($2.50) from the machine.
 * <br>
 * The user can buy several items if they are available in the machine. For payment,
 * a user can use only cash (including coins). Additionally, an administrator of
 * the machine can reset or refill the machine.
 */
public class VendingMachine {
    private int name;
    private String location;

    private static final int AMT_ITEMS = 4;
    private final int[] items = {0, 0, 0, 0};
    private final String[] itemNames = {"water", "coffee", "chips", "chocolate"};
    private final double[] itemPrices = {1.50, 2.00, 1.00, 2.50};

    private static final double TAX_RATE = 0.10;

    private double totalEarnings = 0;
    private int[] itemsSelected = {0, 0, 0, 0};
    private final int[] itemsSold = {0, 0, 0, 0};

    /**
     * Instantiates a new Vending machine with a given name and a default location of "UNKNOWN".
     *
     * @param name the name of the vending machine (serial number).
     */
    public VendingMachine(int name) {
        this.name = name;
        this.location = "UNKNOWN";
    }

    /**
     * Instantiates a new Vending machine with a given name and location.
     *
     * @param name    the name of the vending machine (serial number).
     * @param location the location of the vending machine.
     */
    public VendingMachine(int name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Compares two VendingMachine objects.
     * @param obj the object to compare to.
     * @return true if both objects contain the same amount of each item. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VendingMachine machine) {
            for (int i = 0; i < AMT_ITEMS; i++) {
                if (this.items[i] != machine.items[i]) return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Displays the serial number and location of the vending machine. Also displays the current
     * inventory of the vending machine.
     * @return a string representation of the vending machine.
     */
    @Override
    public String toString() {
        return (
            String.format("Serial Number: %d%n", name) +
            String.format("Location: %s%n", location.equals("UNKNOWN")? "UNKNOWN":location) +
            "Contents:\n" + String.format("\tWater: %d%n\tCoffee: %d%n", items[0], items[1]) +
            String.format("\tChips: %d%n\tChocolate: %d", items[2], items[3])
        );
    }

    /**
     * Sets the location of the vending machine.
     *
     * @param location the location of the vending machine.
     */
    public void setLocation(String location) { this.location = location; }

    /**
     * Sets the name of the vending machine.
     *
     * @param name the serial number of the vending machine.
     */
    public void setName(int name) { this.name = name; }

    /**
     * Reset the items of the vending machine to the amounts specified.
     *
     * @param water     the water amount.
     * @param coffee    the coffee amount.
     * @param chips     the chips amount.
     * @param chocolate the chocolate amount.
     */
    public void reset(int water, int coffee, int chips, int chocolate) {
        items[0] = water;
        items[1] = coffee;
        items[2] = chips;
        items[3] = chocolate;
    }

    /**
     * Add items to the vending machine, accumulating the amount of each item.
     *
     * @param water     the water amount.
     * @param coffee    the coffee amount.
     * @param chips     the chips amount.
     * @param chocolate the chocolate amount.
     */
    public void addItems(int water, int coffee, int chips, int chocolate) {
        items[0] += water;
        items[1] += coffee;
        items[2] += chips;
        items[3] += chocolate;
    }

    /**
     * Display a menu of the items available for purchase.
     */
    public void displayMenu() {
        System.out.println("===== Vending Machine Menu =====");
        System.out.print(
            """
            1. Water............$1.50
            2. Coffee...........$2.00
            3. Chips............$1.00
            4. Chocolate........$2.50
            """.indent(1)
        );
    }

    /**
     * Buy an item from the vending machine. Asks the user for the item and amount to purchase.
     *
     */
    public void buyItem() {
        var buffer = new Scanner(System.in);

        System.out.print("Select an item number: ");
        int selection = buffer.nextInt();
        buffer.nextLine();
        if (invalidSelection(selection)) {
            System.out.println("Invalid selection!");
            return;
        }

        System.out.print("How many do you want to buy? ");
        int quantity = buffer.nextInt();
        buffer.nextLine();
        inStockAfterQuery(selection, quantity);
    }

    /**
     * Buy an item from the vending machine given a selection and quantity.
     * @param selection the item to purchase.
     * @param quantity the amount to purchase.
     * @return true if the item was purchased, false otherwise.
     */
    public boolean buyItem(int selection, int quantity) {
        System.out.printf("Select an item number: %d%n", selection);
        if (invalidSelection(selection)) {
            System.out.println("Invalid selection!");
            return false;
        }

        System.out.printf("How many do you want to buy? %d%n", quantity);
        return inStockAfterQuery(selection, quantity);
    }

    /**
     * Check if the item is in stock after the query. If the item is in stock, the item is
     * selected and the amount of the item is subtracted from the vending machine.
     * @param selection the item to purchase.
     * @param quantity the amount to purchase.
     * @return true if the item is still in stock after purchasing, false otherwise.
     */
    private boolean inStockAfterQuery(int selection, int quantity) {
        if (items[selection - 1] - quantity <= 0) {
            System.out.printf("Selection Failed. We don't have enough %s.%n", itemNames[selection - 1]);
            return false;
        }

        makeSelection(selection, quantity);
        System.out.printf("You selected %s. Quantity: %d%n", itemNames[selection - 1], quantity);
        return true;
    }

    /**
     * Select an item from the vending machine and subtract the amount from the vending machine.
     * @param selection the item to purchase.
     * @param quantity the amount to purchase.
     */
    private void makeSelection(int selection, int quantity) {
        items[selection - 1] -= quantity;
        itemsSelected[selection - 1] += quantity;
    }

    /**
     * Check if a selection is invalid.
     * @param selection the item to purchase.
     * @return true if the selection is invalid, false otherwise.
     */
    private boolean invalidSelection(int selection) { return selection <= 0 || selection > 4; }

    /**
     * Returns the selected items back to the vending machine.
     * @param selection the item to return.
     * @param quantity the amount to return.
     */
    public void returned(int selection, int quantity) {
        System.out.printf("You selected %s. Quantity: %d%n", itemNames[selection - 1], quantity);
        items[selection - 1] += quantity;
        itemsSelected[selection - 1] -= quantity;
    }

    /**
     * Ask the user to pay for the items selected. If the user has enough money, the change is
     * returned to the user.
     *
     * @return true if the user has enough money, false otherwise.
     */
    public boolean payment() {
        var buffer = new Scanner(System.in);
        double total = 0;
        for (int i = 0; i < AMT_ITEMS; i++) {
            total += itemPrices[i] * itemsSelected[i];
        }
        total += total * TAX_RATE;

        System.out.print("Enter money amount: ");
        String input = buffer.nextLine();
        double money = Double.parseDouble(input.substring(1));

        if (money < total) {
            System.out.printf("Insufficient money. $%.2f returned.%n", money);
            return false;
        }
        System.out.printf("Sufficient money. $%.2f returned%n", money - total);
        totalEarnings += total;

        for (int i = 0; i < AMT_ITEMS; i++) {
            itemsSold[i] += itemsSelected[i];
        }
        itemsSelected = new int[AMT_ITEMS];
        return true;
    }

    /**
     * Displays the receipt for the user. The receipt includes the items purchased and the total
     * price.
     */
    public void displayReceipt() {
        double total = 0;
        for (int i = 0; i < AMT_ITEMS; i++) {
            total += itemPrices[i] * itemsSold[i];
            if (itemsSold[i] > 0) {
                System.out.printf("%s: $%.2f X %d = $%.2f%n", itemNames[i], itemPrices[i], itemsSold[i], total);
            }
        }
        System.out.printf("Tax (10.0%%): $%.2f%n", total * TAX_RATE);
        System.out.printf("Total: $%.2f%n", total + total * TAX_RATE);
    }

    /**
     * Displays the total earnings for the day, the total number of items sold, and other statistics.
     */
    public void status() {
        System.out.printf("Serial Number: %d%n", name);
        System.out.printf("Location: %s%n", location);
        System.out.println("Sold Items:");
        for (int i = 0; i < AMT_ITEMS; i++) {
            System.out.printf("\t%s: %d%n", itemNames[i], itemsSold[i]);
        }
        System.out.println("Current Contents:");
        for (int i = 0; i < AMT_ITEMS; i++) {
            System.out.printf("\t%s: %d%n", itemNames[i], items[i]);
        }
        System.out.printf("Total Earnings: $%.2f%n", totalEarnings);
    }
}
