import java.util.Scanner;

public class level1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Java Core Programming Assignments ===\n");

        System.out.println("--- 1. Simple Interest Calculator ---");
        System.out.print("Enter Principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter Rate of Interest (%): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter Time (years): ");
        double time = scanner.nextDouble();
        
        double simpleInterest = (principal * rate * time) / 100;
        
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f\n\n", 
                simpleInterest, principal, rate, time);

        System.out.println("--- 2. Maximum Handshakes ---");
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        System.out.println("The number of possible handshakes: " + handshakes + "\n");

        System.out.println("--- 3. Athlete Rounds Calculator ---");
        System.out.print("Enter side 1 of triangular park (meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side 2 of triangular park (meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side 3 of triangular park (meters): ");
        double side3 = scanner.nextDouble();
        
        double perimeter = side1 + side2 + side3;
        double targetDistanceMeters = 5000.0;
        double rounds = targetDistanceMeters / perimeter;
        
        System.out.printf("The athlete needs to complete %.2f rounds to complete a 5km run.\n\n", rounds);

        System.out.println("--- 4. Check Number Sign ---");
        System.out.print("Enter an integer: ");
        int numCheck = scanner.nextInt();
        
        int signResult;
        if (numCheck > 0) {
            signResult = 1;
        } else if (numCheck < 0) {
            signResult = -1;
        } else {
            signResult = 0;
        }
        
        System.out.println("Result Code (1 for Positive, -1 for Negative, 0 for Zero): " + signResult + "\n");

        System.out.println("--- 5. Spring Season Check ---");
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();
        
        boolean isSpring = false;
        if ((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
            isSpring = true;
        }
        
        if (isSpring) {
            System.out.println("Its a Spring Season\n");
        } else {
            System.out.println("Not a Spring Season\n");
        }

        System.out.println("--- 6. Sum of N Natural Numbers ---");
        System.out.print("Enter value of n: ");
        int n = scanner.nextInt();
        
        int loopSum = 0;
        for (int i = 1; i <= n; i++) {
            loopSum += i;
        }
        
        System.out.println("The sum of first " + n + " natural numbers using loop is: " + loopSum + "\n");

        System.out.println("--- 7. Smallest and Largest of Three Numbers ---");
        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter number 3: ");
        int number3 = scanner.nextInt();
        
        int smallest = number1;
        int largest = number1;

        if (number2 < smallest) smallest = number2;
        if (number3 < smallest) smallest = number3;

        if (number2 > largest) largest = number2;
        if (number3 > largest) largest = number3;
        
        System.out.println("Smallest: " + smallest + ", Largest: " + largest + "\n");

        System.out.println("--- 8. Quotient and Remainder ---");
        System.out.print("Enter dividend number: ");
        int number = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        
        int quotient = number / divisor;
        int remainder = number % divisor;
        
        System.out.println("Quotient: " + quotient + ", Remainder: " + remainder + "\n");

        System.out.println("--- 9. Chocolate Division ---");
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = scanner.nextInt();
        
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        
        System.out.println("Chocolates each child gets: " + chocolatesPerChild);
        System.out.println("Remaining chocolates: " + remainingChocolates + "\n");

        System.out.println("--- 10. Wind Chill Temperature ---");
        System.out.print("Enter temperature (in Fahrenheit, <= 50): ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed (in mph, >= 3): ");
        double windSpeed = scanner.nextDouble();
        
        double windChill = 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * temperature * Math.pow(windSpeed, 0.16));
        
        System.out.printf("The calculated Wind Chill temperature is: %.2f\n\n", windChill);

        System.out.println("--- 11. Trigonometric Functions ---");
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        
        double radians = Math.toRadians(angle);
        double sineVal = Math.sin(radians);
        double cosVal = Math.cos(radians);
        double tanVal = Math.tan(radians);
        
        System.out.printf("For angle %.2f°:\n", angle);
        System.out.printf("Sine: %.4f\n", sineVal);
        System.out.printf("Cosine: %.4f\n", cosVal);
        System.out.printf("Tangent: %.4f\n", tanVal);

        System.out.println("\n=========================================");
        scanner.close();
    }
}