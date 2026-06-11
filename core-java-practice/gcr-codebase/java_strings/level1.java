import java.util.Scanner;

public class level1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       

        System.out.println("\n--- [1] String Comparison (charAt vs equals) ---");
        System.out.print("Enter first string: ");
        String q1Str1 = scanner.next();
        System.out.print("Enter second string: ");
        String q1Str2 = scanner.next();
        
        boolean q1Custom = compareStrings(q1Str1, q1Str2);
        boolean q1BuiltIn = q1Str1.equals(q1Str2);
        System.out.println("Custom charAt() match: " + q1Custom);
        System.out.println("Built-in equals() match: " + q1BuiltIn);
        System.out.println("Are both evaluation methods identical? " + (q1Custom == q1BuiltIn));

        System.out.println("\n--- [2] Substring Generation & Validation ---");
        System.out.print("Enter a source string: ");
        String q2Text = scanner.next();
        System.out.print("Enter start index: ");
        int q2Start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int q2End = scanner.nextInt();

        String q2CustomSub = customSubstring(q2Text, q2Start, q2End);
        String q2BuiltInSub = q2Text.substring(q2Start, q2End);
        System.out.println("Custom Substring extracted: " + q2CustomSub);
        System.out.println("Built-in Substring extracted: " + q2BuiltInSub);
        System.out.println("Do they match? " + compareStrings(q2CustomSub, q2BuiltInSub));

        System.out.println("\n--- [3] Custom toCharArray Conversion ---");
        System.out.print("Enter text to convert to array: ");
        String q3Text = scanner.next();
        
        char[] q3CustomArr = customToCharArray(q3Text);
        char[] q3BuiltInArr = q3Text.toCharArray();
        System.out.println("Do the generated char arrays match? " + compareCharArrays(q3CustomArr, q3BuiltInArr));

        System.out.println("\n--- [4] NullPointerException Demonstration ---");
        System.out.println("Calling safe handling method first...");
        handleNullPointerException();

        System.out.println("\n--- [5] StringIndexOutOfBoundsException Demonstration ---");
        System.out.print("Enter a short string: ");
        String q5Text = scanner.next();
        System.out.println("Calling safe handling method first...");
        handleStringIndexOutOfBounds(q5Text);

        System.out.println("\n--- [6] IllegalArgumentException Demonstration ---");
        System.out.print("Enter a string (ideally > 5 characters): ");
        String q6Text = scanner.next();
        System.out.println("Calling safe handling method first...");
        handleIllegalArgumentException(q6Text);

        System.out.println("\n--- [7] NumberFormatException Demonstration ---");
        System.out.print("Enter a non-numeric string (e.g., 'hello'): ");
        String q7Text = scanner.next();
        System.out.println("Calling safe handling method first...");
        handleNumberFormatException(q7Text);

        System.out.println("\n--- [8] ArrayIndexOutOfBoundsException Demonstration ---");
        System.out.print("How many names do you want to input? ");
        int q8Size = scanner.nextInt();
        String[] q8Names = new String[q8Size];
        for (int i = 0; i < q8Size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            q8Names[i] = scanner.next();
        }
        System.out.println("Calling safe handling method first...");
        handleArrayIndexOutOfBounds(q8Names);

        scanner.nextLine(); 

        System.out.println("\n--- [9] Uppercase Conversion via ASCII Math ---");
        System.out.print("Enter a full sentence line: ");
        String q9Text = scanner.nextLine();
        
        String q9CustomUpper = customToUpperCase(q9Text);
        String q9BuiltInUpper = q9Text.toUpperCase();
        System.out.println("Custom Uppercase Result: " + q9CustomUpper);
        System.out.println("Built-in Uppercase Result: " + q9BuiltInUpper);
        System.out.println("Verification match: " + compareStrings(q9CustomUpper, q9BuiltInUpper));

        System.out.println("\n--- [10] Lowercase Conversion via ASCII Math ---");
        System.out.print("Enter another full sentence line: ");
        String q10Text = scanner.nextLine();
        
        String q10CustomLower = customToLowerCase(q10Text);
        String q10BuiltInLower = textToLowerCaseBuiltIn(q10Text);
        System.out.println("Custom Lowercase Result: " + q10CustomLower);
        System.out.println("Built-in Lowercase Result: " + q10BuiltInLower);
        System.out.println("Verification match: " + compareStrings(q10CustomLower, q10BuiltInLower));

        System.out.println("\n=====================================================");
        System.out.println("CRITICAL TEST ZONE: Triggering Uncaught Exceptions");
        System.out.println("Choose which unhandled crash to test (1-5), or 0 to exit clean:");
        System.out.println("1. NullPointerException\n2. StringIndexOutOfBounds\n3. IllegalArgumentException\n4. NumberFormatException\n5. ArrayIndexOutOfBounds");
        System.out.print("Selection: ");
        int crashChoice = scanner.nextInt();

        switch (crashChoice) {
            case 1 -> generateNullPointerException();
            case 2 -> generateStringIndexOutOfBounds(q5Text);
            case 3 -> generateIllegalArgumentException(q6Text);
            case 4 -> generateNumberFormatException(q7Text);
            case 5 -> generateArrayIndexOutOfBounds(q8Names);
            default -> System.out.println("Exiting safely without intentional program crash.");
        }

        scanner.close();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static char[] customToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static String customToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static String customToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static String textToLowerCaseBuiltIn(String text) {
        return text.toLowerCase();
    }

    public static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length()); 
    }

    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("-> Intercepted Exception: " + e);
        }
    }

    public static void generateStringIndexOutOfBounds(String text) {
        char ch = text.charAt(text.length() + 10);
        System.out.println("Character found: " + ch);
    }

    public static void handleStringIndexOutOfBounds(String text) {
        try {
            char ch = text.charAt(text.length() + 10);
            System.out.println("Character found: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("-> Intercepted Exception: " + e);
        }
    }

    public static void generateIllegalArgumentException(String text) {
        String sub = text.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    public static void handleIllegalArgumentException(String text) {
        try {
            if (text.length() > 5) {
                String sub = text.substring(5, 2);
            } else {
                throw new IllegalArgumentException("Input too small to reverse indices dynamically.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("-> Intercepted Specific Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("-> Intercepted Generic Exception: " + e.getClass().getName());
        }
    }

    public static void generateNumberFormatException(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    public static void handleNumberFormatException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("-> Intercepted Specific Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("-> Intercepted Generic Exception: " + e);
        }
    }

    public static void generateArrayIndexOutOfBounds(String[] names) {
        System.out.println(names[names.length + 10]);
    }

    public static void handleArrayIndexOutOfBounds(String[] names) {
        try {
            System.out.println(names[names.length + 10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-> Intercepted Specific Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("-> Intercepted Generic Exception: " + e);
        }
    }
}