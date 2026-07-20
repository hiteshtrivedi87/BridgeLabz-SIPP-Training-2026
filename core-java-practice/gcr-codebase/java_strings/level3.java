import java.util.Scanner;

public class level3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    

        System.out.println("\n--- [Problem 1] BMI Team Calculator ---");
        String[][] teamData = new String[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Weight (kg) for Member " + (i + 1) + ": ");
            teamData[i][0] = scanner.next();
            System.out.print("Enter Height (cm) for Member " + (i + 1) + ": ");
            teamData[i][1] = scanner.next();
        }

        String[][] bmiReport = computeBMIMatrix(teamData);
        System.out.printf("\n%-12s | %-12s | %-10s | %-15s\n", "Weight (kg)", "Height (cm)", "BMI", "Status");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-12s | %-12s | %-10s | %-15s\n", 
                bmiReport[i][0], bmiReport[i][1], bmiReport[i][2], bmiReport[i][3]);
        }
        scanner.nextLine();

        System.out.println("\n--- [Problem 2] Find Unique Characters ---");
        System.out.print("Enter a string: ");
        String p2Input = scanner.nextLine();
        char[] uniqueArr = findUniqueCharacters(p2Input);
        System.out.print("Unique characters found: ");
        for (char c : uniqueArr) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("\n--- [Problem 3] First Non-Repeating Character ---");
        System.out.print("Enter a string: ");
        String p3Input = scanner.next();
        char resChar = findFirstNonRepeatingChar(p3Input);
        if (resChar == '\0') {
            System.out.println("All characters repeat, or string is empty.");
        } else {
            System.out.println("First non-repeating character: " + resChar);
        }

        System.out.println("\n--- [Problem 4] Frequency Using 256-ASCII Indexing ---");
        System.out.print("Enter a string: ");
        String p4Input = scanner.next();
        String[][] freqMatrixASCII = getFrequencyASCII(p4Input);
        System.out.println("\nChar | Frequency");
        System.out.println("----------------");
        for (String[] row : freqMatrixASCII) {
            System.out.printf(" %-3s | %-5s\n", row[0], row[1]);
        }

        System.out.println("\n--- [Problem 5] Frequency Matrix via Unique Characters Array ---");
        System.out.print("Enter a string: ");
        String p5Input = scanner.next();
        char[] uniques = findUniqueCharacters(p5Input);
        String[][] freqMatrixUnique = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            int count = 0;
            for (int j = 0; j < getCustomLength(p5Input); j++) {
                if (p5Input.charAt(j) == uniques[i]) {
                    count++;
                }
            }
            freqMatrixUnique[i][0] = String.valueOf(uniques[i]);
            freqMatrixUnique[i][1] = String.valueOf(count);
        }
        System.out.println("\nChar | Frequency");
        System.out.println("----------------");
        for (String[] row : freqMatrixUnique) {
            System.out.printf(" %-3s | %-5s\n", row[0], row[1]);
        }

        System.out.println("\n--- [Problem 6] Frequency Matrix Using Nested Loops ('0' flags) ---");
        System.out.print("Enter a string: ");
        String p6Input = scanner.next();
        char[] p6Chars = customToCharArray(p6Input);
        int[] p6Freq = new int[p6Chars.length];
        for (int i = 0; i < p6Chars.length; i++) {
            if (p6Chars[i] == '0') continue;
            p6Freq[i] = 1;
            for (int j = i + 1; j < p6Chars.length; j++) {
                if (p6Chars[i] == p6Chars[j]) {
                    p6Freq[i]++;
                    p6Chars[j] = '0';
                }
            }
        }
        System.out.println("\nChar | Frequency");
        System.out.println("----------------");
        for (int i = 0; i < p6Chars.length; i++) {
            if (p6Chars[i] != '0') {
                System.out.printf(" %-3c | %-5d\n", p6Chars[i], p6Freq[i]);
            }
        }

        System.out.println("\n--- [Problem 7] Palindrome Checker ---");
        System.out.print("Enter text to check: ");
        String p7Input = scanner.next();
        System.out.println("Logic 1 (Two-Pointer Iteration): " + isPalindromeLogic1(p7Input));
        System.out.println("Logic 2 (Recursion Implementation): " + isPalindromeLogic2(p7Input, 0, getCustomLength(p7Input) - 1));
        System.out.println("Logic 3 (String Inversion Array Comparison): " + isPalindromeLogic3(p7Input));

        System.out.println("\n--- [Problem 8] Anagram Checker ---");
        System.out.print("Enter first string: ");
        String s1 = scanner.next();
        System.out.print("Enter second string: ");
        String s2 = scanner.next();
        System.out.println("Are the strings anagrams? -> " + checkAnagram(s1, s2));

        System.out.println("\n--- [Problem 9] Dynamic Monthly Calendar ---");
        System.out.print("Enter Year (e.g., 2005): ");
        int year = scanner.nextInt();
        System.out.print("Enter Month (1-12): ");
        int month = scanner.nextInt();
        displayCalendar(month, year);

        System.out.println("\n--- [Problem 10] Deck of Cards Shuffler & Distributor ---");
        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();
        System.out.print("Enter how many cards to issue to each player: ");
        int cardsPerPlayer = scanner.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] allocatedCards = distributeCards(deck, players, cardsPerPlayer);
        if (allocatedCards != null) {
            printDistributedCards(allocatedCards);
        }

        System.out.println("\n=======================================================");
        System.out.println("          ALL ASSIGNMENTS COMPLETED SEQUENTIALLY       ");
        System.out.println("=======================================================");
        scanner.close();
    }

    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static char[] customToCharArray(String text) {
        int len = getCustomLength(text);
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static String[][] computeBMIMatrix(String[][] inputData) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = Double.parseDouble(inputData[i][0]);
            double heightCm = Double.parseDouble(inputData[i][1]);
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 10.0) / 10.0;

            String status;
            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";

            result[i][0] = inputData[i][0];
            result[i][1] = inputData[i][1];
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }
        return result;
    }

    public static char[] findUniqueCharacters(String text) {
        int len = getCustomLength(text);
        char[] temp = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }
        char[] uniqueArr = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueArr[i] = temp[i];
        }
        return uniqueArr;
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        int len = getCustomLength(text);
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static String[][] getFrequencyASCII(String text) {
        int[] freq = new int[256];
        int len = getCustomLength(text);
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            if (freq[text.charAt(i)] > 0) {
                uniqueCount++;
                freq[text.charAt(i)] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }
        String[][] matrix = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                matrix[index][0] = String.valueOf(c);
                matrix[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; 
                index++;
            }
        }
        return matrix;
    }

    public static boolean isPalindromeLogic1(String text) {
        int start = 0;
        int end = getCustomLength(text) - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeLogic2(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    public static boolean isPalindromeLogic3(String text) {
        int len = getCustomLength(text);
        char[] original = customToCharArray(text);
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = original[len - 1 - i];
        }
        for (int i = 0; i < len; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static boolean checkAnagram(String s1, String s2) {
        int len1 = getCustomLength(s1);
        int len2 = getCustomLength(s2);
        if (len1 != len2) return false;
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void displayCalendar(int m, int y) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", 
                           "July", "August", "September", "October", "November", "December"};
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && isLeapYear(y)) days[2] = 29;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;

        System.out.println("\n    " + months[m] + " " + y);
        System.out.println("Su Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < d0; i++) {
            System.out.print("   ");
        }
        for (int i = 1; i <= days[m]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d0) % 7 == 0) || (i == days[m])) {
                System.out.println();
            }
        }
    }

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards in a 52-card standard deck to satisfy requests.");
            return null;
        }
        String[][] distributionMatrix = new String[players][cardsPerPlayer];
        int cardIndex = 0;
        for (int p = 0; p < players; p++) {
            for (int c = 0; c < cardsPerPlayer; c++) {
                distributionMatrix[p][c] = deck[cardIndex++];
            }
        }
        return distributionMatrix;
    }

    public static void printDistributedCards(String[][] distributed) {
        for (int i = 0; i < distributed.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            for (int j = 0; j < distributed[i].length; j++) {
                System.out.println("  -> " + distributed[i][j]);
            }
        }
    }
}