class BankAccount {
    int accountNumber;
    String holder;
    double balance;

    static int totalAccounts = 0;

    BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void getStatement() {
        System.out.println("\nAccount No: " + accountNumber);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {

        BankAccount a1 = new BankAccount(101, "Ayush", 10000);
        BankAccount a2 = new BankAccount(102, "Rahul", 15000);
        BankAccount a3 = new BankAccount(103, "Riya", 20000);

        a1.deposit(1000);
        a1.withdraw(500);
        a1.deposit(2000);
        a1.withdraw(3000);
        a1.deposit(500);

        a2.deposit(3000);
        a2.withdraw(1000);
        a2.deposit(500);
        a2.withdraw(7000);
        a2.deposit(1500);

        a3.deposit(2000);
        a3.withdraw(1000);
        a3.deposit(2500);
        a3.withdraw(5000);
        a3.deposit(3000);

        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("\nTotal Accounts = " + totalAccounts);
    }
}