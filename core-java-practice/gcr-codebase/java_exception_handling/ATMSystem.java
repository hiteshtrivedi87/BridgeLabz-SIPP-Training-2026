class InsufficientBalanceException extends Exception {
    private final double currentBalance;
    private final double withdrawalRequest;

    public InsufficientBalanceException(double currentBalance, double withdrawalRequest) {
        super("Transaction Denied: Insufficient funds for this withdrawal.");
        this.currentBalance = currentBalance;
        this.withdrawalRequest = withdrawalRequest;
    }

    public double getShortfall() {
        return withdrawalRequest - currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getWithdrawalRequest() {
        return withdrawalRequest;
    }
}

public class ATMSystem {
    private double balance = 5000.0;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: ₹" + balance);
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();
        double requestAmount = 8000.0;

        try {
            System.out.println("Attempting to withdraw: ₹" + requestAmount);
            atm.withdraw(requestAmount);
        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
            System.err.println("Your current balance: ₹" + e.getCurrentBalance());
            System.err.println("Requested amount: ₹" + e.getWithdrawalRequest());
            System.err.println("Shortfall: Missing ₹" + e.getShortfall());
        }
    }
}