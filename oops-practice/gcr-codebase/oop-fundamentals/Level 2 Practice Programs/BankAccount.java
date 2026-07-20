class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " Deposited");
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " Withdrawn");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance : " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        acc.accountHolder = "Ayush";
        acc.accountNumber = 12345;
        acc.balance = 10000;

        acc.deposit(5000);
        acc.withdraw(3000);
        acc.displayBalance();
    }
}