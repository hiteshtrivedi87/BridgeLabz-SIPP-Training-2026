abstract class Employee {
    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int employeeId, String employeeName, double monthlySalary) {
        super(employeeId, employeeName);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }

    @Override
    public double calculateSalary() {
        return getMonthlySalary();
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String employeeName, int hoursWorked, double hourlyRate) {
        super(employeeId, employeeName);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public double calculateSalary() {
        return getHoursWorked() * getHourlyRate();
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee ftEmp = new FullTimeEmployee(101, "Alice Smith", 5000.00);
        Employee ptEmp = new PartTimeEmployee(102, "Bob Jones", 45, 20.00);

        System.out.println("--- Employee Payroll Details ---");
        ftEmp.displayEmployeeInfo();
        System.out.println("Calculated Salary: $" + ftEmp.calculateSalary());
        System.out.println("---------------------------------");
        ptEmp.displayEmployeeInfo();
        System.out.println("Calculated Salary: $" + ptEmp.calculateSalary());
        System.out.println("---------------------------------");
    }
}