import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FeedbackAnalyzer {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int goodCount = 0;
            System.out.println("Enter 5 feedback messages:");

            for (int i = 0; i < 5; i++) {
                String feedback = reader.readLine();
                if (feedback != null && feedback.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }

            System.out.println("Good Feedback Count = " + goodCount);

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}