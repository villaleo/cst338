package Labs.Lab3;

import java.util.Scanner;

public class Bill {
    private int hours, minutes;
    private double fee, rate = 150.0;

    private double getFee(int hours, int minutes) {
        int minutesWorked = hours * 60 + minutes;
        int quarterHours = minutesWorked / 15;
        return quarterHours * rate;
    }

    public void inputTimeWorked() {
        var buffer = new Scanner((System.in));
        System.out.println("Enter number of full hours worked\nfollowed by number of minutes:");
        hours = buffer.nextInt();
        minutes = buffer.nextInt();
        System.out.printf("Time worked:%n%d hours and %d minutes%n", hours, minutes);
    }

    public void updateFee() {
        var buffer = new Scanner(System.in);
        System.out.println("Enter a coupon number:");
        int coupon = buffer.nextInt();

        if (coupon == 1234) {
            rate -= rate / 10;
            System.out.println("Your coupon is valid. (10% discount)");
        } else {
            System.out.println("Your coupon is invalid.");
        }
        fee = getFee(hours, minutes);
    }

    public void outputBill() {
        System.out.printf("Rate: $%.2f per quarter hour.%nAmount due: $%.2f%n", rate, fee);
    }
}
