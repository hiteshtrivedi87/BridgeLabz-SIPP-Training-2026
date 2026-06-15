import java.util.Arrays;
import java.util.Scanner;

public class level2{

    public static void main(String[] args) {
        
    }

    public static void runQuestion1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Sum of factors: " + findSum(factors));
        System.out.println("Product of factors: " + findProduct(factors));
        System.out.println("Sum of squares of factors: " + findSumOfSquares(factors));
    }

    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long findProduct(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double findSumOfSquares(int[] factors) {
        double sumSq = 0;
        for (int f : factors) {
            sumSq += Math.pow(f, 2);
        }
        return sumSq;
    }

    public static void runQuestion2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (n): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int recursiveSum = sumRecursion(n);
        int formulaSum = sumFormula(n);

        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both computations match successfully.");
        }
    }

    public static int sumRecursion(int n) {
        if (n == 1) return 1;
        return n + sumRecursion(n - 1);
    }

    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void runQuestion3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian Calendar limit).");
            return false;
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void runQuestions4To6() {
        System.out.println("--- Unit Converter Results ---");
        System.out.println("5 Km to Miles: " + convertKmToMiles(5));
        System.out.println("10 Miles to Km: " + convertMilesToKm(10));
        System.out.println("2 Meters to Feet: " + convertMetersToFeet(2));
        System.out.println("12 Feet to Meters: " + convertFeetToMeters(12));
        System.out.println("4 Yards to Feet: " + convertYardsToFeet(4));
        System.out.println("100 Fahrenheit to Celsius: " + convertFahrenheitToCelsius(100));
        System.out.println("150 Pounds to Kilograms: " + convertPoundsToKilograms(150));
    }

    public static double convertKmToMiles(double km) { return km * 0.621371; }
    public static double convertMilesToKm(double miles) { return miles * 1.60934; }
    public static double convertMetersToFeet(double meters) { return meters * 3.28084; }
    public static double convertFeetToMeters(double feet) { return feet * 0.3048; }

    public static double convertYardsToFeet(double yards) { return yards * 3; }
    public static double convertFeetToYards(double feet) { return feet * 0.333333; }
    public static double convertMetersToInches(double meters) { return meters * 39.3701; }
    public static double convertInchesToMeters(double inches) { return inches * 0.0254; }
    public static double convertInchesToCm(double inches) { return inches * 2.54; }

    public static double convertFahrenheitToCelsius(double fahrenheit) { return (fahrenheit - 32) * 5 / 9; }
    public static double convertCelsiusToFahrenheit(double celsius) { return (celsius * 9 / 5) + 32; }
    public static double convertPoundsToKilograms(double pounds) { return pounds * 0.453592; }
    public static double convertKilogramsToPounds(double kilograms) { return kilograms * 2.20462; }
    public static double convertGallonsToLiters(double gallons) { return gallons * 3.78541; }
    public static double convertLitersToGallons(double liters) { return liters * 0.264172; }

    public static void runQuestion7() {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            
            if (canStudentVote(ages[i])) {
                System.out.println("Student can vote.");
            } else {
                System.out.println("Student cannot vote.");
            }
        }
    }

    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void runQuestion8() {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height for " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }

        findYoungest(ages, names);
        findTallest(heights, names);
    }

    public static void findYoungest(int[] ages, String[] names) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println("The youngest friend is: " + names[minIndex]);
    }

    public static void findTallest(double[] heights, String[] names) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("The tallest friend is: " + names[maxIndex]);
    }

    public static void runQuestion9() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparison == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comparison == 0) {
            System.out.println("First element and last element are equal.");
        } else {
            System.out.println("First element is less than the last element.");
        }
    }

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 == num2) return 0;
        return -1;
    }

    public static void runQuestion10() {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);
        displayStatus(data);
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = data[i][0] / Math.pow(heightInMeters, 2);
        }
    }

    public static void displayStatus(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            String status;
            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";

            System.out.printf("Person %d -> Height: %.1f cm, Weight: %.1f kg, BMI: %.2f, Status: %s\n",
                    (i + 1), data[i][1], data[i][0], bmi, status);
        }
    }

    public static void runQuestion11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) {
            System.out.println("No real roots (Delta is negative).");
        } else if (roots.length == 1) {
            System.out.println("One root: " + roots[0]);
        } else {
            System.out.println("Two roots: Root 1 = " + roots[0] + ", Root 2 = " + roots[1]);
        }
    }

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{r1, r2};
        } else if (delta == 0) {
            double r = -b / (2 * a);
            return new double[]{r};
        } else {
            return new double[0];
        }
    }

    public static void runQuestion12() {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.println("Generated Numbers: " + Arrays.toString(randomNumbers));

        double[] metrics = findAverageMinMax(randomNumbers);
        System.out.println("Average: " + metrics[0]);
        System.out.println("Minimum: " + (int)metrics[1]);
        System.out.println("Maximum: " + (int)metrics[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) return new double[]{0, 0, 0};

        double sum = 0;
        double min = numbers[0];
        double max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double avg = sum / numbers.length;
        return new double[]{avg, min, max};
    }
}