package Projects.Project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private String bankName;

    private static double totalBalance = 0.0;

    public Bank(String name) {
        this.bankName = name;
    }

    public void readData(String filePath) {
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
            System.exit(1);
        }

        int numCustomers = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCustomers; i++) {
            String[] customer = in.nextLine().split(",");
            customers.add(new Customer(
                    customer[0], customer[1], Integer.parseInt(customer[2]), customer[3]
            ));
        }

        int numAccounts = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numAccounts; i++) {
            String[] query = in.nextLine().split(",");
            String ssn = query[0];
            int accountNumber = Integer.parseInt(query[1]);
            int type = Integer.parseInt(query[2]);
            double amount = Double.parseDouble(query[3]);

            totalBalance += amount;

            Customer customer = null;
            for (var c : customers) {
                if (c.getSocialSecurity().equals(ssn)) {
                    customer = c;
                    break;
                }
            }
            accounts.add(new Account(accountNumber, type, ssn, amount, customer));
        }
    }

    public void bankInfo() {
        System.out.printf("Bank Name: %s\n", bankName);
        System.out.printf("Number of Customers: %d\n", customers.size());
        for (var customer : customers)
            System.out.printf("\t\t%s\n", customer);
        System.out.printf("Number of Accounts: %d\n", accounts.size());
        for (var account : accounts)
            System.out.printf("\t\t%s\n", account);
        System.out.printf("Total Balance: $%.2f\n", totalBalance);
    }

    public void accountInfo(int accountNumber) {
        for (var account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println(account.getAccountInfo());
                return;
            }
        }
        System.out.printf("Account (%d) does not exist.", accountNumber);
    }

    private void deposit(int accountNumber, double amount) {
        for (var account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                transactions.add(new Transaction(account, 1, amount, LocalDateTime.now()));
            }
        }
    }

    private void withdraw(int accountNumber, double amount) {
        for (var account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.withdraw(amount);
                transactions.add(new Transaction(account, 2, amount, LocalDateTime.now()));
            }
        }
    }

    public boolean closeAccount(int accountNumber) {
        for (var account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accounts.remove(account);
                transactions.add(new Transaction(account, 3, LocalDateTime.now()));
                return true;
            }
        }
        return false;
    }

    public void transaction(int accountNumber) {
        boolean found = false;
        for (var transaction : transactions) {
            if (transaction.getAccountNumber() == accountNumber) {
                found = true;
                System.out.print(transaction);
            }
        }
        if (!found) {
            System.out.printf("\t- No transaction for account %d\n", accountNumber);
        }
    }

    private static void demo1() {
        Bank csumbBank = new Bank("CSUMB");
        System.out.println("=== READ DATA ===");
        csumbBank.readData("/Users/lvill/dev/Java/CST338-03/src/Projects/Project1/resources/test1.txt");
        System.out.println("=== DONE ===");
        System.out.println("\n=== BANK INFORMATION ===");
        csumbBank.bankInfo();
        System.out.println("\n=== ACCOUNT INFORMATION ===");
        csumbBank.accountInfo(1000);
        csumbBank.deposit(1000, 150.25);
        System.out.println("\n=== ACCOUNT INFORMATION ===");
        csumbBank.accountInfo(1000);
        csumbBank.withdraw(1000, 100);
        System.out.println("\n=== ACCOUNT INFORMATION ===");
        csumbBank.accountInfo(1000);
        System.out.println("\n=== ACCOUNT CLOSE ===");
        if (csumbBank.closeAccount(1000)) {
            System.out.println("Account closed.");
        }
        System.out.println("\n=== TRANSACTION INFO ===");
        csumbBank.transaction(1000);
        System.out.println("\n=== TRANSACTION INFO ===");
        csumbBank.transaction(2000);
    }

    private static void demo2() {
        Bank csumbBank = new Bank("CSUMB");
        csumbBank.readData("/Users/lvill/dev/Java/CST338-03/src/Projects/Project1/resources/test1.txt");
        System.out.println("=== NEW CUSTOMERS ===");
        csumbBank.newCustomer("Bob Smith", "123 University Center", 93955, "123-45-6789");
        csumbBank.newCustomer("Unknown Smith", "123 University Center", 93955, "777-77-7777");
        System.out.println("\n=== NEW ACCOUNTS ===");
        csumbBank.newAccount("777-77-7777", 4000, 1, 100.50);
        csumbBank.newAccount("123-45-7777", 2000, 1, 100.50);
        csumbBank.newAccount("123-45-7777", 4000, 1, 100.50);
        System.out.println("\n=== ACCOUNT INFO ===");
        csumbBank.accountInfo(7000);
        System.out.println("\n=== CUSTOMER WITH LAST FOUR DIGIT SSN ===");
        csumbBank.customerInfoWithSSN(7979);
        System.out.println("\n=== CUSTOMER WITH SSN 7777 ===");
        csumbBank.customerInfoWithSSN(7777);
        System.out.println("\n=== CUSTOMER WITH SSN 6789 ===");
        csumbBank.customerInfoWithSSN(6789);
        // We try to close the account 2000.
//        csumbBank.closeAccount(2000);
//        System.out.println("\n=== REMOVE CUSTOMER: 555-55-5555 ===");
//        csumbBank.removeCustomer("555-55-5555");
//        System.out.println("\n=== REMOVE CUSTOMER: 777-77-7777 ===");
//        csumbBank.removeCustomer("777-77-7777");
    }

    private void customerInfoWithSSN(int ssn) {
        boolean found = false;

        for (var cust : customers) {
            if (Integer.parseInt(cust.getSocialSecurity().substring(7)) == ssn) {
                System.out.printf("Name:\t%s\n", cust.getName());
                System.out.printf("%s, %d\n", cust.getAddress(), cust.getZipCode());
                System.out.printf("SSN: %s\n", cust.getSocialSecurity());

                for (var acc: accounts) {
                    if (acc.getCustomer().getSocialSecurity().equals(cust.getSocialSecurity())) {
                        if (acc.hasCheckingAccount()) {
                            System.out.printf("Checking (%d), $%.2f\n", acc.getAccountNumber(), acc.getBalance());
                        }
                        if (acc.hasSavingAccount()) {
                            System.out.printf("Savings (%d), $%.2f\n", acc.getAccountNumber(), acc.getBalance());
                        }
                        if (! acc.hasCheckingAccount() && ! acc.hasSavingAccount()) {
                            System.out.println("No accounts");
                        }
                    }
                }
                found = true;
            }
        }

        if (!found) {
            System.out.printf("No customer with %d\n", ssn);
        }
    }

    private void newAccount(String ssn, int id, int type, double amount) {
        // Fails if user already has an account of type `type`.
        for (var acc: accounts) {
            if (acc.getSocialSecurity().equals(ssn)) {
                if (type == 1 && acc.hasCheckingAccount()) {
                    System.out.printf("Account creation failed - %s (%s) already has a checking account\n",
                            acc.getCustomer().getName(), acc.getSocialSecurity());
                }
                else if (type == 2 && acc.hasSavingAccount()) {
                    System.out.printf("Account creation failed - %s (%s) already has a savings account\n",
                            acc.getCustomer().getName(), acc.getSocialSecurity());
                }
                return;
            }
        }

        // Fails if account number is already in use.
        for (var acc: accounts) {
            if (acc.getAccountNumber() == id) {
                System.out.printf("Account creation failed - Account %d already exists\n", id);
                return;
            }
        }

        Customer toCreate = null;
        for (var cust: customers) {
            if (cust.getSocialSecurity().equals(ssn)) {
                toCreate = cust;
            }
        }
        assert toCreate != null;
        System.out.printf("Account creation - Number: %d, Customer: %s", id, toCreate.getName());
        accounts.add(new Account(id, type, ssn, amount, toCreate));
    }

    private void newCustomer(String name, String address, int zip, String ssn) {
        for (var account : accounts) {
            if (account.getSocialSecurity().equals(ssn)) {
                System.out.printf("%s is NOT added - Duplicated SSN.\n", name);
                return;
            }
        }
        customers.add(new Customer(name, address, zip, ssn));
        System.out.printf("%s is added.\n", name);
    }

    // Sample runs
    public static void main(String[] args) {
        demo2();
    }
}
