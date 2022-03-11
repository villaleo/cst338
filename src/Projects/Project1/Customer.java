/**
 * Title: Customer.java
 * Abstract: This class simulates a Customer. Each customer has a name, address, zip code,
 *           and social security. Available methods are only accessors.
 * Author: Leonardo Villalobos
 * Date: 03/11/22
 */

package Projects.Project1;

public class Customer {
    private String name;
    private String address;
    private int zipCode;
    private String socialSecurity;

    public Customer(String name, String address, int zipCode, String socialSecurity) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.socialSecurity = socialSecurity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, socialSecurity);
    }
}
