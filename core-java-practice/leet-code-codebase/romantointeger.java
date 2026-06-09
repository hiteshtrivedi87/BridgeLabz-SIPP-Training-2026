import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class romantointeger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a Roman Numeral: ");
        String roman = scanner.next().toUpperCase();
        
        int result = convertRomanToInt(roman);
        System.out.println("The integer value is: " + result);
        
        scanner.close();
    }

    public static int convertRomanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = romanMap.get(s.charAt(i));

            if (i < length - 1) {
                int nextVal = romanMap.get(s.charAt(i + 1));

                if (currentVal < nextVal) {
                    total -= currentVal;
                } else {
                    total += currentVal;
                }
            } else {
                total += currentVal;
            }
        }

        return total;
    }
} 
    

