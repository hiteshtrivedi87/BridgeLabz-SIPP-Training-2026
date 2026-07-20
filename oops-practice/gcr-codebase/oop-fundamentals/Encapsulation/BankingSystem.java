abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Transaction Failed: Invalid amount or Insufficient Funds.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Acc Number: " + accountNumber + " | Holder: " + holderName + " | Current Balance: $" + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    @Override
    public double calculateInterest() {
        return (getBalance() * getInterestRate()) / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double getMonthlyBonusRate() { return monthlyBonusRate; }
    public void setMonthlyBonusRate(double monthlyBonusRate) { this.monthlyBonusRate = monthlyBonusRate; }

    @Override
    public double calculateInterest() {
        return (getBalance() * getMonthlyBonusRate()) / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV-1122", "Alice Vance", 1000.0, 4.5);
        BankAccount current = new CurrentAccount("CUR-3344", "Bruce Wayne", 5000.0, 1.2);

        System.out.println("=== Processing Savings Account ===");
        savings.displayAccountDetails();
        savings.deposit(500.0);
        savings.withdraw(200.0);
        savings.displayAccountDetails();
        System.out.println("Calculated Yearly Interest: $" + savings.calculateInterest());

        System.out.println("\n=== Processing Current Account ===");
        current.displayAccountDetails();
        current.deposit(1500.0);
        current.withdraw(1000.0);
        current.displayAccountDetails();
        System.out.println("Calculated Monthly Bonus Interest: $" + current.calculateInterest());
    }
}