package Collections.sorting_algorithm;

import java.util.Arrays;

public class AttendanceRanking {
    
    // Helper class to hold employee records and support sorting
    static class Employee implements Comparable<Employee> {
        int id;
        int attendance;

        public Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }

        @Override
        public int compareTo(Employee other) {
            // High attendance should rank higher (descending order)
            if (this.attendance != other.attendance) {
                return Integer.compare(other.attendance, this.attendance);
            }
            // If attendance is tied, the smaller ID ranks higher (ascending order)
            return Integer.compare(this.id, other.id);
        }
    }

    public static int[] getTopKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(employeeIds[i], attendance[i]);
        }

        // Sort using our custom compareTo rules
        Arrays.sort(employees);

        // Extract the top K employee IDs
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employees[i].id;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] topK = getTopKEmployees(employeeIds, attendance, k);
        System.out.println("Top " + k + " Employees: " + Arrays.toString(topK));
        // Output should match: [103, 101, 104]
    }
}
