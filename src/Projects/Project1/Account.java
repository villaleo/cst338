package Projects.Project1;

public class Account {
    private int accountNumber;
    private int accountType;
    private double balance;
    private Customer customer;
    private String socialSecurity;

    private boolean checkingAccount = false;
    private boolean savingAccount = false;

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public Account(int accountNumber, int accountType, String socialSecurity, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.socialSecurity = socialSecurity;
        this.balance = balance;
        this.customer = customer;

        if (this.accountType == 1 && !checkingAccount) {
            this.checkingAccount = true;
        } else if (this.accountType == 2 && !savingAccount) {
            this.savingAccount = true;
        }
    }

    /**
     * Withdraws the specified amount from the account. If the amount is greater than the balance,
     * then the balance is set to zero.
     * @param amount the amount to withdraw
     * @return the amount withdrawn
     */
    public double withdraw(double amount) {
        if (amount > balance) {
            balance = 0;
            return balance;
        }
        balance -= amount;
        return amount;
    }

    public String getAccountType(int type) {
        return switch (type) {
            case 1 -> "Checking";
            case 2 -> "Savings";
            default -> "Unknown";
        };
    }

    public String getAccountInfo() {
        return String.format("\t- Number: %d\n", accountNumber) +
                String.format("\t- %s\n", getAccountType(accountType)) +
                String.format("\t- Balance: $%.2f\n", balance) +
                String.format("\t- Customer: %s", customer.getName());
    }

    @Override
    public String toString() {
        return String.format("%d: $%.2f", accountNumber, balance);
    }

    public boolean hasCheckingAccount() {
        return checkingAccount;
    }

    public boolean hasSavingAccount() {
        return savingAccount;
    }
}
