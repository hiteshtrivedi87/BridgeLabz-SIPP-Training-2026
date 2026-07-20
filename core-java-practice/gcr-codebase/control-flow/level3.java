import java.util.Scanner;

class LeapYearMultipleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year >= 1582) {
            if (year % 400 == 0) {
                System.out.println("The Year is a Leap Year");
            } else if (year % 100 == 0) {
                System.out.println("The Year is not a Leap Year");
            } else if (year % 4 == 0) {
                System.out.println("The Year is a Leap Year");
            } else {
                System.out.println("The Year is not a Leap Year");
            }
        } else {
            System.out.println("Year must be 1582 or greater");
        }
        input.close();
    }
}

class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year >= 1582) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("The Year is a Leap Year");
            } else {
                System.out.println("The Year is not a Leap Year");
            }
        } else {
            System.out.println("Year must be 1582 or greater");
        }
        input.close();
    }
}

class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        double physics = input.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double chemistry = input.nextDouble();
        System.out.print("Enter Maths marks: ");
        double maths = input.nextDouble();

        double average = (physics + chemistry + maths) / 3.0;

        String grade = "";
        String remarks = "";

        if (average >= 80) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (average >= 70) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (average >= 60) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (average >= 50) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (average >= 40) {
            grade = "E";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R";
            remarks = "(Remedial standards)";
        }

        System.out.println("Average Mark: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        input.close();
    }
}

class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        boolean isPrime = true;

        if (number > 1) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        } else {
            isPrime = false;
        }

        System.out.println("Is the number a prime number? " + isPrime);
        input.close();
    }
}

class ArmstrongNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += (digit * digit * digit);
            originalNumber /= 10;
        }

        if (number == sum) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
        input.close();
    }
}

class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        int count = 0;
        int temp = Math.abs(number);

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                count++;
            }
        }

        System.out.println("Number of digits: " + count);
        input.close();
    }
}

class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        double heightMeter = heightCm / 100.0;
        double bmi = weight / (heightMeter * heightMeter);

        String status = "";
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("Your BMI value is: " + bmi);
        System.out.println("Weight Status: " + status);
        input.close();
    }
}

class HarshadNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += digit;
            originalNumber /= 10;
        }

        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is Not a Harshad Number.");
        }
        input.close();
    }
}

class AbundantNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is Not an Abundant Number.");
        }
        input.close();
    }
}

class SwitchCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = input.nextDouble();
        System.out.print("Enter second number: ");
        double second = input.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = input.next();

        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Print Invalid Operator");
                break;
        }
        input.close();
    }
}

class DayOfWeek {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        System.out.println("Day index output (0=Sun, 1=Mon, ...): " + d0);
    }
}