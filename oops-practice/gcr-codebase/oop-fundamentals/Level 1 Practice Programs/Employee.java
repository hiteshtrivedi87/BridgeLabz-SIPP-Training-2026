class Employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID   : " + id);
        System.out.println("Salary        : " + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();

        emp.name = "Ayush";
        emp.id = 101;
        emp.salary = 50000;

        emp.display();
    }
}