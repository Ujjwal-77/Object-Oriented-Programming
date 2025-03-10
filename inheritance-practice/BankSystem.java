class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }

    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Savings Account with Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Checking Account with Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    private int depositDuration;

    public FixedDepositAccount(String accountNumber, double balance, int depositDuration) {
        super(accountNumber, balance);
        this.depositDuration = depositDuration;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account with Duration: " + depositDuration + " months");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA12345", 5000, 3.5);
        BankAccount acc2 = new CheckingAccount("CA67890", 2000, 1000);
        BankAccount acc3 = new FixedDepositAccount("FD11223", 10000, 12);

        acc1.displayAccountType();
        acc1.displayBalance();

        acc2.displayAccountType();
        acc2.displayBalance();

        acc3.displayAccountType();
        acc3.displayBalance();
    }
}
