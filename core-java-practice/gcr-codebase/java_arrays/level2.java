import java.util.Scanner;

public class level2 {

    public static void main(String[] args) {
        
        Scanner scanner1 = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Enter details for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = scanner1.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double years = scanner1.nextDouble();

            if (salary <= 0 || years <= 0) {
                System.out.println("Invalid entry. Please enter positive values again.");
                i--; 
                continue;
            }
            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        for (int i = 0; i < 10; i++) {
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nEmployee Bonus Breakdown:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d -> Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n", 
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }
        System.out.printf("\nTotal Old Salary payout: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus payout: %.2f\n", totalBonus);
        System.out.printf("Total New Salary payout: %.2f\n", totalNewSalary);


        Scanner scanner2 = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] friendAges = new int[3];
        double[] friendHeights = new double[3];

        System.out.println("\nEnter age and height for Amar, Akbar, and Anthony:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            friendAges[i] = scanner2.nextInt();
            System.out.print("Enter height for " + names[i] + ": ");
            friendHeights[i] = scanner2.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (friendAges[i] < friendAges[youngestIndex]) {
                youngestIndex = i;
            }
            if (friendHeights[i] > friendHeights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("\nYoungest friend is " + names[youngestIndex] + " with age " + friendAges[youngestIndex]);
        System.out.println("Tallest friend is " + names[tallestIndex] + " with height " + friendHeights[tallestIndex]);


        Scanner scanner3 = new Scanner(System.in);
        System.out.print("\nEnter a number to find digits: ");
        int userNum = scanner3.nextInt();

        int maxDigit = 10;
        int[] digitArray = new int[maxDigit];
        int digitIndex = 0;
        int tempNum = Math.abs(userNum);

        while (tempNum != 0) {
            int lastDigit = tempNum % 10;
            if (digitIndex == maxDigit) {
                break;
            }
            digitArray[digitIndex] = lastDigit;
            digitIndex++;
            tempNum /= 10;
        }

        int largestDigit = 0;
        int secondLargestDigit = 0;

        for (int i = 0; i < digitIndex; i++) {
            if (digitArray[i] > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digitArray[i];
            } else if (digitArray[i] > secondLargestDigit && digitArray[i] != largestDigit) {
                secondLargestDigit = digitArray[i];
            }
        }

        System.out.println("Largest digit stored: " + largestDigit);
        System.out.println("Second largest digit stored: " + secondLargestDigit);


        Scanner scanner4 = new Scanner(System.in);
        System.out.print("\nEnter a large number for auto-resizing array calculation: ");
        long dynamicNum = scanner4.nextLong();

        int maxDigitDynamic = 10;
        int[] dynamicDigitArray = new int[maxDigitDynamic];
        int dynDigitIndex = 0;
        long tempDynNum = Math.abs(dynamicNum);

        while (tempDynNum != 0) {
            int lastDigit = (int) (tempDynNum % 10);
            if (dynDigitIndex == maxDigitDynamic) {
                maxDigitDynamic += 10;
                int[] tempResize = new int[maxDigitDynamic];
                for (int j = 0; j < dynamicDigitArray.length; j++) {
                    tempResize[j] = dynamicDigitArray[j];
                }
                dynamicDigitArray = tempResize;
            }
            dynamicDigitArray[dynDigitIndex] = lastDigit;
            dynDigitIndex++;
            tempDynNum /= 10;
        }

        int dynLargest = 0;
        int dynSecondLargest = 0;

        for (int i = 0; i < dynDigitIndex; i++) {
            if (dynamicDigitArray[i] > dynLargest) {
                dynSecondLargest = dynLargest;
                dynLargest = dynamicDigitArray[i];
            } else if (dynamicDigitArray[i] > dynSecondLargest && dynamicDigitArray[i] != dynLargest) {
                dynSecondLargest = dynamicDigitArray[i];
            }
        }

        System.out.println("Largest digit (Dynamic): " + dynLargest);
        System.out.println("Second largest digit (Dynamic): " + dynSecondLargest);


        Scanner scanner5 = new Scanner(System.in);
        System.out.print("\nEnter an integer to reverse: ");
        int numToReverse = scanner5.nextInt();

        int originalValue = Math.abs(numToReverse);
        int digitCount = 0;
        int countTemp = originalValue;

        while (countTemp != 0) {
            digitCount++;
            countTemp /= 10;
        }

        if (numToReverse == 0) {
            digitCount = 1;
        }

        int[] reverseArray = new int[digitCount];
        int valTemp = originalValue;
        for (int i = 0; i < digitCount; i++) {
            reverseArray[i] = valTemp % 10;
            valTemp /= 10;
        }

        System.out.print("Reversed Array presentation: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reverseArray[i] + " ");
        }
        System.out.println();


        Scanner scanner6 = new Scanner(System.in);
        System.out.print("\nEnter the number of persons for BMI check: ");
        int bmiCount = scanner6.nextInt();

        double[] weights = new double[bmiCount];
        double[] heights = new double[bmiCount];
        double[] bmis = new double[bmiCount];
        String[] bmiStatus = new String[bmiCount];

        for (int i = 0; i < bmiCount; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weights[i] = scanner6.nextDouble();
            System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
            heights[i] = scanner6.nextDouble();

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] <= 18.4) {
                bmiStatus[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                bmiStatus[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                bmiStatus[i] = "Overweight";
            } else {
                bmiStatus[i] = "Obese";
            }
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < bmiCount; i++) {
            System.out.printf("Person %d -> Height: %.2fm, Weight: %.1fkg, BMI: %.2f, Status: %s\n", 
                    (i + 1), heights[i], weights[i], bmis[i], bmiStatus[i]);
        }


        Scanner scanner7 = new Scanner(System.in);
        System.out.print("\nEnter number of persons for Multi-Dimensional BMI check: ");
        int multidimBmiCount = scanner7.nextInt();

        double[][] personData = new double[multidimBmiCount][3];
        String[] weightStatus = new String[multidimBmiCount];

        for (int i = 0; i < multidimBmiCount; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double w = scanner7.nextDouble();
            System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
            double h = scanner7.nextDouble();

            if (w <= 0 || h <= 0) {
                System.out.println("Negative or zero entries are invalid. Re-enter positive parameters.");
                i--;
                continue;
            }

            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = w / (h * h);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nMulti-Dimensional BMI Report:");
        for (int i = 0; i < multidimBmiCount; i++) {
            System.out.printf("Person %d -> Weight: %.1f, Height: %.2f, BMI: %.2f, Status: %s\n", 
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }


        Scanner scanner8 = new Scanner(System.in);
        System.out.print("\nEnter the number of students to grade: ");
        int studentCount = scanner8.nextInt();

        double[] physics = new double[studentCount];
        double[] chemistry = new double[studentCount];
        double[] maths = new double[studentCount];
        double[] percentages = new double[studentCount];
        char[] grades = new char[studentCount];

        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " (out of 100):");
            System.out.print("Physics: ");
            double p = scanner8.nextDouble();
            System.out.print("Chemistry: ");
            double c = scanner8.nextDouble();
            System.out.print("Maths: ");
            double m = scanner8.nextDouble();

            if (p < 0 || c < 0 || m < 0 || p > 100 || c > 100 || m > 100) {
                System.out.println("Invalid entries detected. Marks must scale between 0-100.");
                i--;
                continue;
            }

            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
            percentages[i] = (p + c + m) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\nStudent Performance Analytics:");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("Student %d -> P: %.1f, C: %.1f, M: %.1f | Average: %.2f%% | Grade: %c\n", 
                    (i + 1), physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
        }


        Scanner scanner9 = new Scanner(System.in);
        System.out.print("\nEnter number of students for 2D Matrix grading analysis: ");
        int matrixStudentCount = scanner9.nextInt();

        double[][] studentMarksMatrix = new double[matrixStudentCount][3];
        double[] matrixPercentages = new double[matrixStudentCount];
        char[] matrixGrades = new char[matrixStudentCount];

        for (int i = 0; i < matrixStudentCount; i++) {
            System.out.println("Enter marks (0-100) for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            studentMarksMatrix[i][0] = scanner9.nextDouble();
            System.out.print("Chemistry: ");
            studentMarksMatrix[i][1] = scanner9.nextDouble();
            System.out.print("Maths: ");
            studentMarksMatrix[i][2] = scanner9.nextDouble();

            if (studentMarksMatrix[i][0] < 0 || studentMarksMatrix[i][1] < 0 || studentMarksMatrix[i][2] < 0 || 
                studentMarksMatrix[i][0] > 100 || studentMarksMatrix[i][1] > 100 || studentMarksMatrix[i][2] > 100) {
                System.out.println("Invalid entries. Re-enter positive numeric values between 0 and 100.");
                i--;
                continue;
            }

            matrixPercentages[i] = (studentMarksMatrix[i][0] + studentMarksMatrix[i][1] + studentMarksMatrix[i][2]) / 3.0;

            if (matrixPercentages[i] >= 80) {
                matrixGrades[i] = 'A';
            } else if (matrixPercentages[i] >= 70) {
                matrixGrades[i] = 'B';
            } else if (matrixPercentages[i] >= 60) {
                matrixGrades[i] = 'C';
            } else if (matrixPercentages[i] >= 50) {
                matrixGrades[i] = 'D';
            } else if (matrixPercentages[i] >= 40) {
                matrixGrades[i] = 'E';
            } else {
                matrixGrades[i] = 'R';
            }
        }

        System.out.println("\n2D Matrix Grading Report:");
        for (int i = 0; i < matrixStudentCount; i++) {
            System.out.printf("Student %d -> P: %.1f, C: %.1f, M: %.1f | Avg: %.2f%% | Grade: %c\n", 
                    (i + 1), studentMarksMatrix[i][0], studentMarksMatrix[i][1], studentMarksMatrix[i][2], 
                    matrixPercentages[i], matrixGrades[i]);
        }


        Scanner scanner10 = new Scanner(System.in);
        System.out.print("\nEnter an integer to map digit frequencies: ");
        long freqNumber = scanner10.nextLong();

        long workingNumber = Math.abs(freqNumber);
        long sizeCounterTemp = workingNumber;
        int dynamicSize = 0;

        while (sizeCounterTemp != 0) {
            dynamicSize++;
            sizeCounterTemp /= 10;
        }
        if (freqNumber == 0) {
            dynamicSize = 1;
        }

        int[] splitDigits = new int[dynamicSize];
        long storageTemp = workingNumber;
        for (int i = 0; i < dynamicSize; i++) {
            splitDigits[i] = (int) (storageTemp % 10);
            storageTemp /= 10;
        }

        int[] digitFrequencies = new int[10];
        for (int i = 0; i < dynamicSize; i++) {
            int numericDigit = splitDigits[i];
            digitFrequencies[numericDigit]++;
        }

        System.out.println("\nDigit Frequencies Output:");
        for (int i = 0; i < 10; i++) {
            if (digitFrequencies[i] > 0) {
                System.out.println("Digit [" + i + "] repeated: " + digitFrequencies[i] + " time(s)");
            }
        }
    }
}