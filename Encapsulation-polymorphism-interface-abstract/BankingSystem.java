import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance; 

    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

  
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();


    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}


interface Loanable {
    boolean applyForLoan(double amount);

    double calculateLoanEligibility();
}


class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; 

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    
    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 0.5; 
    }
}


class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; 
    private double overdraftLimit = 1000; 

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    
    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    @Override
    public double calculateLoanEligibility() {
        return (balance * 2) + overdraftLimit;
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savings = new SavingsAccount("SA123456", "Alice", 5000);
        CurrentAccount current = new CurrentAccount("CA987654", "Bob", 3000);

        accounts.add(savings);
        accounts.add(current);

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Interest Earned: " + account.calculateInterest());


            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                double loanAmount = 2000; 
                System.out.println("Loan Eligibility: " + loanAccount.calculateLoanEligibility());
                System.out.println("Loan Approval: " + (loanAccount.applyForLoan(loanAmount) ? "Approved" : "Denied"));
            }

            System.out.println("----------------------------");
        }
    }
}
