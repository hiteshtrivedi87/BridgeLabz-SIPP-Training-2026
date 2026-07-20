class StudentTwo {
    static String universityName = "GLA University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    String grade;

    StudentTwo(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void display() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        StudentTwo s = new StudentTwo("Ayush", 101, "A");

        if (s instanceof StudentTwo) {
            s.display();
        }

        displayTotalStudents();
    }
}