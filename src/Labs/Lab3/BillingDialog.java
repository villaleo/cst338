package Labs.Lab3;

public class BillingDialog {
    public static void main(String[] args) {
        System.out.println("Welcome to CSUMB software house!");
        Bill yourBill = new Bill();
        yourBill.inputTimeWorked();
        yourBill.updateFee();
        yourBill.outputBill();
        System.out.println("Thanks for doing business with us.");
    }
}
