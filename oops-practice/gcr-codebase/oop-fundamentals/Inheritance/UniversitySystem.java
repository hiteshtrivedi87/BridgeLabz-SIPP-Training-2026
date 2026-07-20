class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

class Student extends Person {
    private final String studentId;
    private double gpa;

    public Student(String name, String studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() { return studentId; }
    
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
    }
}

class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, String studentId, double gpa, String thesisTitle) {
        super(name, studentId, gpa);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: \"" + thesisTitle + "\"";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        GradStudent grad = new GradStudent("Alice Smith", "GS-9921", 3.91, "Quantum Cryptography");

        System.out.println(grad.toString());

        System.out.println("GradStudent IS-A Student: " + (grad instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (grad instanceof Person));
        
        Student checkStudentRef = grad;
        Person checkPersonRef = grad;
        System.out.println("Polymorphic Reference Check Pass!");
    }
}