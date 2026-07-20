import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() { return sideA; }
    public void setSideA(double sideA) { this.sideA = sideA; }

    public double getSideB() { return sideB; }
    public void setSideB(double sideB) { this.sideB = sideB; }

    public double getSideC() { return sideC; }
    public void setSideC(double sideC) { this.sideC = sideC; }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }
}

public class ShapeReportSystem {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)
        };

        System.out.println("=================================================");
        System.out.printf("%-12s | %-12s | %-12s\n", "Shape Type", "Area", "Perimeter");
        System.out.println("=================================================");
        
        for (Shape shape : shapes) {
            String type = shape.getClass().getSimpleName();
            System.out.printf("%-12s | %-12.2f | %-12.2f\n", type, shape.area(), shape.perimeter());
        }
        System.out.println("=================================================");
    }
}