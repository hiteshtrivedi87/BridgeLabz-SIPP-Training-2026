class CircleTwo {
    double radius;

    CircleTwo() {
        this(5);
    }

   CircleTwo(double radius) {
        this.radius = radius;
    }

    void display() {
        double area = 3.14 * radius * radius;
        System.out.println("Radius : " + radius);
        System.out.println("Area : " + area);
    }

    public static void main(String[] args) {
        CircleTwo c2 = new CircleTwo(7);
        CircleTwo c1 = new CircleTwo();

        c1.display();
        System.out.println();
        c2.display();
    }
}