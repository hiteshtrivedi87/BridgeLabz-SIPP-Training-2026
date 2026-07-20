class Circle {
    double radius;

    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area = " + area);
    }

    void circumference() {
        double circumference = 2 * 3.14 * radius;
        System.out.println("Circumference = " + circumference);
    }

    public static void main(String[] args) {
        Circle c = new Circle();

        c.radius = 7;

        c.area();
        c.circumference();
    }
}