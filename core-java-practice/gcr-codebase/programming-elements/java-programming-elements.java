import java.util.*;


class birthyear{
    public static void main(String[] args) {
        int birthYear = 2000;
        int currentYear = 2024;
        int age = currentYear - birthYear;
        System.out.println("Harry's age in 2024 is " + age);
    }
}

class PCMAverage {
    public static void main(String[] args) {
        double maths = 94;
        double physics = 95;
        double chemistry = 96;
        double average = (maths + physics + chemistry) / 3;
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}

class KmToMilesFixed {
    public static void main(String[] args) {
        double km = 10.8;
        double miles = km * 1.6;
        System.out.println("The distance " + km + " km in miles is " + miles);
    }
}

class ProfitLoss {
    public static void main(String[] args) {
        double costPrice = 129;
        double sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        
        System.out.print("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" +
                         "The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "\n");
    }
}

class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;
        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}

class UniversityDiscountFixed {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = fee * (discountPercent / 100);
        double discountedFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
    }
}

class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        
        double radiusMiles = radiusKm / 1.6;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
        
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}



class KmToMilesInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km;
        
        System.out.print("Enter distance in km: ");
        km = input.nextDouble();
        
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        
        input.close();
    }
}



class UniversityDiscountInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter total student fee: ");
        double fee = input.nextDouble();
        
        System.out.print("Enter university discount percent: ");
        double discountPercent = input.nextDouble();
        
        double discount = fee * (discountPercent / 100);
        double discountedFee = fee - discount;
        
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
        
        input.close();
    }
}



class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();
        
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        double remainingInches = totalInches % 12;
        
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + remainingInches);
        
        input.close();
    }
}




class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number 1: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter number 2: ");
        double number2 = input.nextDouble();
        
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        
        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
        
        input.close();
    }
}



class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        
        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / (2.54 * 2.54);
        
        System.out.println("The Area of the triangle in sq in is " + areaInches + " and sq cm is " + areaCm);
        
        input.close();
    }
}



class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter perimeter: ");
        double perimeter = input.nextDouble();
        
        double side = perimeter / 4;
        
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        
        input.close();
    }
}



class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        
        System.out.println("The distance in yards is " + yards + " while the distance in miles is " + miles);
        
        input.close();
    }
}



class TotalPrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();
        
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        
        double totalPrice = unitPrice * quantity;
        
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        
        input.close();
    }
}



class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number 1: ");
        int number1 = input.nextInt();
        
        System.out.print("Enter number 2: ");
        int number2 = input.nextInt();
        
        int quotient = number1 / number2;
        int remainder = number1 % number2;
        
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);
        
        input.close();
    }
}



class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        int a = input.nextInt();
        
        System.out.print("Enter b: ");
        int b = input.nextInt();
        
        System.out.print("Enter c: ");
        int c = input.nextInt();
        
        int op1 = a + b * c;
        int op2 = a * b + c;
        int op3 = c + a / b;
        int op4 = a % b + c;
        
        System.out.println("The results of Int Operations are " + op1 + ", " + op2 + ", " + op3 + ", and " + op4);
        
        input.close();
    }
}




class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        
        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;
        double op4 = a % b + c;
        
        System.out.println("The results of Double Operations are " + op1 + ", " + op2 + ", " + op3 + ", and " + op4);
        
        input.close();
    }
}