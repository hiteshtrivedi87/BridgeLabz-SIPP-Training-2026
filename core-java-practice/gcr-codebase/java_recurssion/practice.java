public class practice {
    public static void main(String[] args) {
        printNTo1(5);
    }

    public static void printNTo1(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNTo1(n - 1);
    }
}

class Problem2 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

class Problem3 {
    public static void main(String[] args) {
        System.out.println(sumN(5));
    }

    public static int sumN(int n) {
        if (n == 0) return 0;
        return n + sumN(n - 1);
    }
}

class Problem4 {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    public static String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}

class Problem5 {
    public static void main(String[] args) {
        String testStr = "madam";
        if (isPalindrome(testStr)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}

class Problem6 {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
class Problem7 {
    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }

    public static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }
}

class Problem8 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        generateSubsets(arr, 0, "");
    }

    public static void generateSubsets(int[] arr, int i, String current) {
        if (i == arr.length) {
            System.out.println("[" + current + "]");
            return;
        }
        generateSubsets(arr, i + 1, current.isEmpty() ? "" + arr[i] : current + "," + arr[i]);
        generateSubsets(arr, i + 1, current);
    }
}

class Problem9 {
    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char src, char dest, char helper) {
        if (n == 0) return;
        towerOfHanoi(n - 1, src, helper, dest);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, dest, src);
    }
}

class Problem10 {
    public static void main(String[] args) {
        printPermutations("ABC", "");
    }

    public static void printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1);
            printPermutations(rest, ans + ch);
        }
    }
}