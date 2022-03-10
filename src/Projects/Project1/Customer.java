package Projects.Project1;

public class Customer {
    // TODO: Each Customer can have a maximum of two Accounts (= one checking and
    //  one savings account) and accounts cannot be shared between customers.

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

    // Debugging

    @Override
    public String toString() {
        return String.format("%s: %s", name, socialSecurity);
    }
}
