import java.util.Random;

public class level3 {

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();
        System.out.print("Heights: ");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150;
            System.out.print(heights[i] + " ");
        }
        System.out.println();
        System.out.println("Sum: " + findSum(heights));
        System.out.println("Mean: " + findMean(heights));
        System.out.println("Shortest: " + findShortest(heights));
        System.out.println("Tallest: " + findTallest(heights));

        long num1 = 153;
        System.out.println("\n--- Part 2 & 3 & 4 Testing (" + num1 + ") ---");
        int[] digits1 = storeDigits(num1);
        System.out.println("Digit Count: " + countDigits(num1));
        System.out.println("Is Duck: " + isDuckNumber(digits1));
        System.out.println("Is Armstrong: " + isArmstrongNumber(num1));
        findLargestAndSecondLargest(digits1);
        findSmallestAndSecondSmallest(digits1);
        System.out.println("Sum of Digits: " + sumOfDigits(digits1));
        System.out.println("Sum of Squares: " + sumOfSquaresOfDigits(digits1));
        System.out.println("Is Harshad: " + isHarshadNumber(num1));
        
        int[][] freq = findDigitFrequency(num1);
        System.out.println("Frequencies:");
        for(int i = 0; i < freq.length; i++) {
            System.out.println("Digit " + freq[i][0] + ": " + freq[i][1]);
        }
        
        System.out.println("Is Palindrome: " + isPalindrome(num1));

        long num2 = 145;
        System.out.println("\n--- Part 5 & 6 Testing (" + num2 + ") ---");
        System.out.println("Is Prime: " + isPrime(num2));
        System.out.println("Is Neon: " + isNeonNumber(num2));
        System.out.println("Is Spy: " + isSpyNumber(num2));
        System.out.println("Is Automorphic: " + isAutomorphicNumber(num2));
        System.out.println("Is Buzz: " + isBuzzNumber(num2));
        System.out.println("Is Perfect: " + isPerfectNumber(num2));
        System.out.println("Is Abundant: " + isAbundantNumber(num2));
        System.out.println("Is Deficient: " + isDeficientNumber(num2));
        System.out.println("Is Strong: " + isStrongNumber(num2));

        int num3 = 12;
        System.out.println("\n--- Part 7 Testing (" + num3 + ") ---");
        int[] factors = findFactors(num3);
        System.out.print("Factors: ");
        for(int f : factors) System.out.print(f + " ");
        System.out.println();
        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cubes: " + findProductOfCubes(factors));

        System.out.println("\n--- Part 8 Testing (OTP) ---");
        String[] otpStorage = new String[10];
        for (int i = 0; i < 10; i++) {
            otpStorage[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpStorage[i]);
        }
        System.out.println("Are OTPs Unique? " + checkUnique(otpStorage));
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    public static double findMean(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) findSum(arr) / arr.length;
    }

    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
        }
        return min;
    }

    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
        }
        return max;
    }

    public static int countDigits(long num) {
        if (num == 0) return 1;
        int count = 0;
        long temp = Math.abs(num);
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int[] storeDigits(long num) {
        int size = countDigits(num);
        int[] digits = new int[size];
        long temp = Math.abs(num);
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(long num) {
        int[] digits = storeDigits(num);
        int power = digits.length;
        long sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == num;
    }

    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
    }

    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        System.out.println("Smallest: " + smallest + ", Second Smallest: " + secondSmallest);
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += (int) Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(long num) {
        if (num == 0) return false;
        int[] digits = storeDigits(num);
        return num % sumOfDigits(digits) == 0;
    }

    public static int[][] findDigitFrequency(long num) {
        int[] digits = storeDigits(num);
        int[] rawCounts = new int[10];
        for (int d : digits) rawCounts[d]++;
        int uniqueCount = 0;
        for (int i = 0; i < 10; i++) {
            if (rawCounts[i] > 0) uniqueCount++;
        }
        int[][] frequencyArray = new int[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (rawCounts[i] > 0) {
                frequencyArray[index][0] = i;
                frequencyArray[index][1] = rawCounts[i];
                index++;
            }
        }
        return frequencyArray;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(long num) {
        int[] original = storeDigits(num);
        int[] reversed = reverseDigits(original);
        return compareArrays(original, reversed);
    }

    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(long num) {
        long square = num * num;
        long sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    public static boolean isSpyNumber(long num) {
        long sum = 0;
        long product = 1;
        long temp = Math.abs(num);
        if (temp == 0) return false;
        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(long num) {
        long square = num * num;
        long temp = num;
        while (temp > 0) {
            if (temp % 10 != square % 10) return false;
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    public static boolean isBuzzNumber(long num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }

    private static long sumOfProperDivisors(long num) {
        long sum = 0;
        for (long i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum;
    }

    public static boolean isPerfectNumber(long num) {
        if (num <= 0) return false;
        return sumOfProperDivisors(num) == num;
    }

    public static boolean isAbundantNumber(long num) {
        if (num <= 0) return false;
        return sumOfProperDivisors(num) > num;
    }

    public static boolean isDeficientNumber(long num) {
        if (num <= 0) return false;
        return sumOfProperDivisors(num) < num;
    }

    public static boolean isStrongNumber(long num) {
        if (num <= 0) return false;
        long temp = num;
        long sum = 0;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    private static long factorial(int d) {
        long fact = 1;
        for (int i = 1; i <= d; i++) fact *= i;
        return fact;
    }

    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        if (factors.length <= 1) return factors[0];
        return factors[factors.length - 2];
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

    public static String generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    public static boolean checkUnique(String[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i].equals(otps[j])) return false;
            }
        }
        return true;
    }
}