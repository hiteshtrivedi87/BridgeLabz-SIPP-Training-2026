import java.util.Scanner;

public class BmiTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        

        System.out.print("Enter weight in kilograms : ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in meters : ");
        double height = scanner.nextDouble();

        if (height <= 0 || weight <= 0) {
            System.out.println("Error: Height and weight must be greater than zero.");
        } else {
            double bmi = weight / (height * height);

            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                category = "Normal weight";
            } else if (bmi >= 25.0 && bmi < 29.9) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            System.out.println("\n---------- FITNESS REPORT ----------");
            System.out.printf("Calculated BMI: %.2f\n", bmi);
            System.out.println("Health Category: " + category);
            System.out.println("------------------------------------");
        }

        scanner.close();
    }
}