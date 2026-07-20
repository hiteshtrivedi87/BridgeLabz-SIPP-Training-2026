class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Ayush", 21);
        Person p2 = new Person(p1);

        p1.display();
        System.out.println();
        p2.display();
    }
}