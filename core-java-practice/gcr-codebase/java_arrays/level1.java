import java.util.Scanner;

public class level1 {

    public static void main(String[] args) {
        
        Scanner scanner1 = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = scanner1.nextInt();
        }
        System.out.println("\nResults:");
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age.");
            } else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }

        Scanner scanner2 = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner2.nextInt();
        }
        System.out.println("\nAnalysis:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative.");
            } else {
                System.out.println(numbers[i] + " is zero.");
            }
        }
        System.out.println("\nComparison:");
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else if (first < last) {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is equal to the last element (" + last + ").");
        }

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int numTable = scanner3.nextInt();
        int[] multiplicationTable = new int[10];
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = numTable * i;
        }
        System.out.println("\nResult:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numTable + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        Scanner scanner4 = new Scanner(System.in);
        double[] dynNumbers = new double[10];
        double total = 0.0;
        int dynIndex = 0;
        System.out.println("Enter up to 10 positive numbers (Enter 0 or negative to stop):");
        while (true) {
            if (dynIndex == 10) {
                System.out.println("Array limit of 10 reached.");
                break;
            }
            System.out.print("Enter entry " + (dynIndex + 1) + ": ");
            double userInput = scanner4.nextDouble();
            if (userInput <= 0) {
                break;
            }
            dynNumbers[dynIndex] = userInput;
            dynIndex++;
        }
        for (int i = 0; i < dynIndex; i++) {
            total += dynNumbers[i];
        }
        System.out.println("\nSummary:");
        System.out.print("Numbers entered: ");
        for (int i = 0; i < dynIndex; i++) {
            System.out.print(dynNumbers[i] + " ");
        }
        System.out.println("\nTotal sum: " + total);

        Scanner scanner5 = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int numPartial = scanner5.nextInt();
        int[] multiplicationResult = new int[4];
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = numPartial * i;
        }
        System.out.println("\nResult:");
        for (int i = 6; i <= 9; i++) {
            System.out.println(numPartial + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        Scanner scanner6 = new Scanner(System.in);
        double[] heights = new double[11];
        double sumHeights = 0.0;
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner6.nextDouble();
            sumHeights += heights[i];
        }
        double mean = sumHeights / 11;
        System.out.printf("\nThe mean height of the football team is: %.2f\n", mean);

        Scanner scanner7 = new Scanner(System.in);
        System.out.print("Enter a positive natural number: ");
        int naturalNum = scanner7.nextInt();
        if (naturalNum < 1) {
            System.out.println("Error: Not a natural number.");
        } else {
            int splitSize = naturalNum / 2 + 1;
            int[] evenArray = new int[splitSize];
            int[] oddArray = new int[splitSize];
            int evenIndex = 0;
            int oddIndex = 0;
            for (int i = 1; i <= naturalNum; i++) {
                if (i % 2 == 0) {
                    evenArray[evenIndex] = i;
                    evenIndex++;
                } else {
                    oddArray[oddIndex] = i;
                    oddIndex++;
                }
            }
            System.out.print("\nOdd numbers array: ");
            for (int i = 0; i < oddIndex; i++) {
                System.out.print(oddArray[i] + " ");
            }
            System.out.print("\nEven numbers array: ");
            for (int i = 0; i < evenIndex; i++) {
                System.out.print(evenArray[i] + " ");
            }
            System.out.println();
        }

        Scanner scanner8 = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int factorNum = scanner8.nextInt();
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int factorIndex = 0;
        for (int i = 1; i <= factorNum; i++) {
            if (factorNum % i == 0) {
                if (factorIndex == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[factorIndex] = i;
                factorIndex++;
            }
        }
        System.out.print("\nFactors of " + factorNum + " are: ");
        for (int i = 0; i < factorIndex; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        Scanner scanner9 = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = scanner9.nextInt();
        System.out.print("Enter columns: ");
        int columns = scanner9.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner9.nextInt();
            }
        }
        int[] array1D = new int[rows * columns];
        int index1D = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array1D[index1D] = matrix[i][j];
                index1D++;
            }
        }
        System.out.print("\nFlattened 1D Array: ");
        for (int i = 0; i < array1D.length; i++) {
            System.out.print(array1D[i] + " ");
        }
        System.out.println();

        Scanner scanner10 = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int fizzBuzzNum = scanner10.nextInt();
        if (fizzBuzzNum >= 0) {
            String[] results = new String[fizzBuzzNum + 1];
            for (int i = 0; i <= fizzBuzzNum; i++) {
                if (i == 0) {
                    results[i] = "0";
                } else if (i % 3 == 0 && i % 5 == 0) {
                    results[i] = "FizzBuzz";
                } else if (i % 3 == 0) {
                    results[i] = "Fizz";
                } else if (i % 5 == 0) {
                    results[i] = "Buzz";
                } else {
                    results[i] = String.valueOf(i);
                }
            }
            System.out.println("\nResults:");
            for (int i = 0; i <= fizzBuzzNum; i++) {
                System.out.print("Position " + i + " = " + results[i]);
                if (i < fizzBuzzNum) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }
    }
}