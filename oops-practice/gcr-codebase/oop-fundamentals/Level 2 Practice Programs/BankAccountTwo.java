class BankAccountTwo {
    static String bankName = "SBI";
    static int totalAccounts = 0;

    String accountHolderName;
    final int accountNumber;

    BankAccountTwo(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        BankAccountTwo b = new BankAccountTwo("Ayush", 1001);

        if (b instanceof BankAccountTwo) {
            b.display();
        }

        getTotalAccounts();
    }
}