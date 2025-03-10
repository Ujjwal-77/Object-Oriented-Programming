import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, String accountType, double initialDeposit) {
        Account newAccount = new Account(this, accountType, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " in " + name);
    }
    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account Type: " + acc.getAccountType() + ", Balance: $" + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Account {
    private Bank bank;
    private String accountType;
    private double balance;

    public Account(Bank bank, String accountType, double balance) {
        this.bank = bank;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("ABC Bank");
        Bank bank2 = new Bank("XYZ Bank");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        bank1.openAccount(customer1, "Savings", 1000);
        bank1.openAccount(customer1, "Checking", 500);

        bank2.openAccount(customer2, "Savings", 2000);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
