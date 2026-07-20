class EmployeeTwo {
    static String companyName = "TCS";
    static int totalEmployees = 0;

    String name;
    final int id;
    String designation;

    EmployeeTwo(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void display() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        EmployeeTwo e = new EmployeeTwo("Ayush", 101, "Developer");

        if (e instanceof EmployeeTwo) {
            e.display();
        }

        displayTotalEmployees();
    }
}