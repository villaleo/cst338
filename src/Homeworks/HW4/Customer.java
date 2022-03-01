/**
 * Title: Customer.java
 * Abstract: This class simulates a customer account.
 * Author: Leonardo Villalobos
 * Date: 02/25/22
 */

package Homeworks.HW4;

public class Customer {
    private String name;
    private String address;
    private int ssn;

    public Customer(String name, String addr, int ssn) {
        this.name = name;
        this.address = addr;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Customer:\t%s%n%s%n", name, address) + String.format("SSN: %d%n", ssn);
    }
}
