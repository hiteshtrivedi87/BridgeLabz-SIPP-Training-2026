import java.util.Scanner;
//Welcome to Bridgelabz!

public class Assisted_Problems {
    public static void main(String[] args) {
        System.out.println("Welcome to Bridgelabz!");
    }
}

//Add Two Numbers

class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double sum = num1 + num2;
        System.out.println("The sum is: " + sum);
        
        
    }
}

//Celsius to Fahrenheit Conversion


class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
        
        
    }
}

//Area of a Circle


class AreaOfCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is: " + area);
        
        
    }
}

//Volume of a Cylinder


class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();
        
        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();
        
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume);
        
        
    }
}