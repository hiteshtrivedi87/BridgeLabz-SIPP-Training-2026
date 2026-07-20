import java.util.Scanner;


class DivisibleByFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        boolean isDivisible = (number % 5 == 0);
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
        input.close();
    }
}

class FirstSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = input.nextInt();
        System.out.print("Enter number 3: ");
        int number3 = input.nextInt();
        boolean isSmallest = (number1 < number2 && number1 < number3);
        System.out.println("Is the first number the smallest? " + isSmallest);
        input.close();
    }
}

class LargestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = input.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = input.nextInt();
        System.out.print("Enter number 3: ");
        int number3 = input.nextInt();
        boolean isFirstLargest = (number1 > number2 && number1 > number3);
        boolean isSecondLargest = (number2 > number1 && number2 > number3);
        boolean isThirdLargest = (number3 > number1 && number3 > number2);
        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
        input.close();
    }
}

class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number >= 1) {
            int sum = number * (number + 1) / 2;
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        input.close();
    }
}

class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = input.nextInt();
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        input.close();
    }
}

class NumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int number = input.nextInt();
        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
        input.close();
    }
}

class SpringSeason {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        boolean isSpring = (month == 3 && day >= 20 && day <= 31) ||
                           (month == 4 && day >= 1 && day <= 30) ||
                           (month == 5 && day >= 1 && day <= 31) ||
                           (month == 6 && day >= 1 && day <= 20);
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

class CountdownWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown starting point: ");
        int counter = input.nextInt();
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        input.close();
    }
}

class CountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown starting point: ");
        int start = input.nextInt();
        for (int counter = start; counter >= 1; counter--) {
            System.out.println(counter);
        }
        input.close();
    }
}

class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter a double value (0 to stop): ");
        double userValue = input.nextDouble();
        while (userValue != 0.0) {
            total += userValue;
            System.out.print("Enter a double value (0 to stop): ");
            userValue = input.nextDouble();
        }
        System.out.println("The total sum is: " + total);
        input.close();
    }
}

class SumWithBreak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double userValue = input.nextDouble();
            if (userValue <= 0) {
                break;
            }
            total += userValue;
        }
        System.out.println("The total sum is: " + total);
        input.close();
    }
}

class SumComparisonWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        if (n >= 1) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }
            System.out.println("Formula result: " + formulaSum);
            System.out.println("While loop result: " + loopSum);
            System.out.println("Both computations match and are correct: " + (formulaSum == loopSum));
        } else {
            System.out.println("Not a natural number.");
        }
        input.close();
    }
}

class SumComparisonFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();
        if (n >= 1) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            System.out.println("Formula result: " + formulaSum);
            System.out.println("For loop result: " + loopSum);
            System.out.println("Both computations match and are correct: " + (formulaSum == loopSum));
        } else {
            System.out.println("Not a natural number.");
        }
        input.close();
    }
}

class FactorialWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number >= 0) {
            long factorial = 1;
            int i = 1;
            while (i <= number) {
                factorial *= i;
                i++;
            }
            System.out.println("The factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number >= 0) {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}