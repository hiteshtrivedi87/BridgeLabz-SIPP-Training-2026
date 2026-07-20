import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int candidate1 = 0;
        int candidate2 = 0;
        int candidate3 = 0;

        while (true) {
            System.out.print("Enter voter age (or -1 to stop): ");
            int age = sc.nextInt();

            if (age == -1) {
                break;
            }

            if (age >= 18) {
                System.out.println("Eligible to vote.");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                System.out.print("Enter your vote (1, 2, or 3): ");
                int vote = sc.nextInt();

                if (vote == 1) {
                    candidate1++;
                } else if (vote == 2) {
                    candidate2++;
                } else if (vote == 3) {
                    candidate3++;
                } else {
                    System.out.println("Invalid vote!");
                }
            } else {
                System.out.println("Not eligible to vote.");
            }

            System.out.println();
        }

        System.out.println("----- Election Results -----");
        System.out.println("Candidate A votes: " + candidate1);
        System.out.println("Candidate B votes: " + candidate2);
        System.out.println("Candidate C votes: " + candidate3);

        sc.close();
    }
}