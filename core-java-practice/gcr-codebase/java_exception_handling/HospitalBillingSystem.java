class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    
    private static final String[] PATIENTS = {"Alice", "Bob", "Charlie"};

    public static void processBilling(String inputItems, String inputIndex, double billAmount, double paymentAmount) {
        try {
            int itemsCount = Integer.parseInt(inputItems);
            int patientIndex = Integer.parseInt(inputIndex);

            if (itemsCount == 0) {
                int averageCostPerItem = 100 / 0; 
            }

            String patientName = PATIENTS[patientIndex];
            System.out.println("Processing bill for: " + patientName);

            if (paymentAmount < billAmount) {
                throw new InsufficientFundsException("Payment failed: Provided ₹" + paymentAmount + 
                        " is less than the required bill amount ₹" + billAmount);
            }

            System.out.println("Billing successful! Change returned: ₹" + (paymentAmount - billAmount));

        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input format. Please enter numbers only.");
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot calculate billing for zero items (Division by zero).");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Patient index is invalid. Patient record not found.");
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected system error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processBilling("5", "1", 1500.0, 2000.0);
        processBilling("0", "1", 1500.0, 2000.0);
        processBilling("5", "10", 1500.0, 2000.0);
        processBilling("abc", "1", 1500.0, 2000.0);
        processBilling("5", "2", 2500.0, 1000.0);
    }
}