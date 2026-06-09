import java.util.Scanner;

public class reverseinteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        int x = input.nextInt();

        int result = reverse(x);
        System.out.println("Reversed result: " + result);

        input.close();
    }

    public static int reverse(int x) {
        long reversedSum = 0;
        
        while (x != 0) {
            int digit = x % 10;
            reversedSum = (reversedSum * 10) + digit;
            x /= 10;
        }
        
        if (reversedSum > Integer.MAX_VALUE || reversedSum < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) reversedSum;
    }
}