import java.util.Arrays;
import java.util.Scanner;

public class plusone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of digits: ");
        int size = input.nextInt();
        
        int[] digits = new int[size];
        System.out.println("Enter the digits one by one (separated by spaces or enter):");
        for (int i = 0; i < size; i++) {
            digits[i] = input.nextInt();
        }

        int[] result = plusOne(digits);
        System.out.println("Result after adding one: " + Arrays.toString(result));

        input.close();
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}