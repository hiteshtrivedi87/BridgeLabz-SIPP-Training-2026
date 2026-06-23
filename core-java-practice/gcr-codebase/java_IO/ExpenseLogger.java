import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseLogger {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true))) {

            System.out.print("Enter expense category (e.g., Food): ");
            String category = scanner.nextLine().trim();

            System.out.print("Enter expense amount: ");
            String amount = scanner.nextLine().trim();

            writer.write(category + " - " + amount);
            writer.newLine();

            System.out.println("Expense logged successfully.");

        } catch (IOException e) {
            System.err.println("Error saving expense data: " + e.getMessage());
        }
    }
}