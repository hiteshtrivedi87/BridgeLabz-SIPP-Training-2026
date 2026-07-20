public class Student {

    String name;
    int[] marks;
    int total;
    double percentage;
    String grade;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    void calculateResult() {
        total = 0;

        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }

        percentage = total / 5.0;

        if (percentage >= 90)
            grade = "A+";
        else if (percentage >= 80)
            grade = "A";
        else if (percentage >= 70)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else
            grade = "F";
    }

    void display() {
        System.out.println(name + "\t" + total + "\t" + percentage + "\t" + grade);
    }
}