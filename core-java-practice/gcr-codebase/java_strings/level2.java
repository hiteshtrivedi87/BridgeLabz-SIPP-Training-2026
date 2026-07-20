import java.util.Scanner;

public class level2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    

        System.out.println("\n--- [1] Custom Length via Exception Handling ---");
        System.out.print("Enter a string: ");
        String q1Input = scanner.next();
        int q1CustomLength = getCustomLength(q1Input);
        int q1BuiltInLength = q1Input.length();
        System.out.println("Custom computed length: " + q1CustomLength);
        System.out.println("Built-in length method: " + q1BuiltInLength);
        System.out.println("Validation identical? " + (q1CustomLength == q1BuiltInLength));

        scanner.nextLine();

        System.out.println("\n--- [2] Word Splitter Implementation ---");
        System.out.print("Enter a line of text: ");
        String q2Input = scanner.nextLine();
        String[] q2CustomWords = customSplit(q2Input);
        String[] q2BuiltInWords = q2Input.split(" ");
        boolean arraysMatch = compareStringArrays(q2CustomWords, q2BuiltInWords);
        System.out.println("Do custom split and built-in split arrays match? " + arraysMatch);

        System.out.println("\n--- [3] Words with Length Matrix ---");
        System.out.print("Enter text line: ");
        String q3Input = scanner.nextLine();
        String[] q3Words = customSplit(q3Input);
        String[][] q3Matrix = getWordsWithLengths(q3Words);
        System.out.println("\nWord\t\tLength");
        System.out.println("--------------------");
        for (int i = 0; i < q3Matrix.length; i++) {
            int parsedLen = Integer.parseInt(q3Matrix[i][1]);
            System.out.println(q3Matrix[i][0] + "\t\t" + parsedLen);
        }

        System.out.println("\n--- [4] Find Shortest and Longest Words ---");
        System.out.print("Enter text line: ");
        String q4Input = scanner.nextLine();
        String[] q4Words = customSplit(q4Input);
        String[][] q4Matrix = getWordsWithLengths(q4Words);
        int[] extremeIndices = findShortestAndLongest(q4Matrix);
        System.out.println("Shortest word: " + q4Matrix[extremeIndices[0]][0]);
        System.out.println("Longest word: " + q4Matrix[extremeIndices[1]][0]);

        System.out.println("\n--- [5] Vowel and Consonant Metrics ---");
        System.out.print("Enter text string: ");
        String q5Input = scanner.nextLine();
        int[] vowelConsCounts = countVowelsAndConsonants(q5Input);
        System.out.println("Total Vowels: " + vowelConsCounts[0]);
        System.out.println("Total Consonants: " + vowelConsCounts[1]);

        System.out.println("\n--- [6] Tabular Vowel/Consonant Classification Matrix ---");
        System.out.print("Enter text string: ");
        String q6Input = scanner.nextLine();
        String[][] classificationMatrix = getCharacterClassificationMatrix(q6Input);
        display2DArray(classificationMatrix, new String[]{"Character", "Classification"});

        System.out.println("\n--- [7] Custom Trim Optimization ---");
        System.out.print("Enter text containing leading/trailing spaces: ");
        String q7Input = scanner.nextLine();
        int[] bounds = getTrimBounds(q7Input);
        String q7CustomTrimmed = customSubstring(q7Input, bounds[0], bounds[1]);
        String q7BuiltInTrimmed = q7Input.trim();
        System.out.println("Custom Trimmed Result: '" + q7CustomTrimmed + "'");
        System.out.println("Built-in Trimmed Result: '" + q7BuiltInTrimmed + "'");
        System.out.println("Do the trimmed metrics match exactly? " + compareStrings(q7CustomTrimmed, q7BuiltInTrimmed));

        System.out.println("\n--- [8] Student Voting Qualification Status ---");
        System.out.print("Enter number of students for voting check: ");
        int totalStudents = scanner.nextInt();
        int[] studentAges = generateRandomAges(totalStudents);
        String[][] votingEligibilityMatrix = evaluateVotingEligibility(studentAges);
        display2DArray(votingEligibilityMatrix, new String[]{"Age Row Index", "Eligible to Vote"});

        System.out.println("\n--- [9] Rock-Paper-Scissors Strategy Simulation ---");
        System.out.print("Enter number of matches to simulate: ");
        int totalMatches = scanner.nextInt();
        runRockPaperScissorsSimulation(scanner, totalMatches);

        System.out.println("\n--- [10] Student Grading Performance Scorecard System ---");
        System.out.print("Enter the number of students for marks computation: ");
        int numberOfStudents = scanner.nextInt();
        int[][] studentMarks = generateRandomMarks(numberOfStudents);
        double[][] studentMetrics = calculateMetrics(studentMarks);
        String[][] studentGrades = calculateGrades(studentMetrics);
        displayScorecard(studentMarks, studentMetrics, studentGrades);

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

    public static String[] customSplit(String text) {
        int length = getCustomLength(text);
        if (length == 0) {
            return new String[0];
        }

        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int indexTracker = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[indexTracker] = i;
                indexTracker++;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            words[i] = customSubstring(text, start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[spaceCount] = customSubstring(text, start, length);

        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!compareStrings(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareStrings(String s1, String s2) {
        int len1 = getCustomLength(s1);
        int len2 = getCustomLength(s2);
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String customSubstring(String text, int start, int end) {
        String res = "";
        for (int i = start; i < end; i++) {
            res += text.charAt(i);
        }
        return res;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] matrix = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            matrix[i][0] = words[i];
            matrix[i][1] = String.valueOf(getCustomLength(words[i]));
        }
        return matrix;
    }

    public static int[] findShortestAndLongest(String[][] wordsMatrix) {
        if (wordsMatrix.length == 0) {
            return new int[]{-1, -1};
        }
        int shortestIdx = 0;
        int longestIdx = 0;
        int minLen = Integer.parseInt(wordsMatrix[0][1]);
        int maxLen = Integer.parseInt(wordsMatrix[0][1]);

        for (int i = 1; i < wordsMatrix.length; i++) {
            int currentLen = Integer.parseInt(wordsMatrix[i][1]);
            if (currentLen < minLen) {
                minLen = currentLen;
                shortestIdx = i;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                longestIdx = i;
            }
        }
        return new int[]{shortestIdx, longestIdx};
    }

    public static String checkCharacterType(char ch) {
        char target = ch;
        if (target >= 'A' && target <= 'Z') {
            target = (char) (target + 32);
        }
        if (target == 'a' || target == 'e' || target == 'i' || target == 'o' || target == 'u') {
            return "Vowel";
        } else if (target >= 'a' && target <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        int len = getCustomLength(text);
        for (int i = 0; i < len; i++) {
            String evaluation = checkCharacterType(text.charAt(i));
            if (compareStrings(evaluation, "Vowel")) {
                vowels++;
            } else if (compareStrings(evaluation, "Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static String[][] getCharacterClassificationMatrix(String text) {
        int len = getCustomLength(text);
        String[][] matrix = new String[len][2];
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            matrix[i][0] = String.valueOf(ch);
            matrix[i][1] = checkCharacterType(ch);
        }
        return matrix;
    }

    public static int[] getTrimBounds(String text) {
        int len = getCustomLength(text);
        int start = 0;
        int end = len;
        while (start < len && text.charAt(start) == ' ') {
            start++;
        }
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static int[] generateRandomAges(int totalStudents) {
        int[] ages = new int[totalStudents];
        for (int i = 0; i < totalStudents; i++) {
            ages[i] = (int) (Math.random() * 50) + 1;
        }
        return ages;
    }

    public static String[][] evaluateVotingEligibility(int[] ages) {
        String[][] matrix = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            matrix[i][0] = "Age: " + ages[i];
            if (ages[i] < 0) {
                matrix[i][1] = "false";
            } else {
                matrix[i][1] = (ages[i] >= 18) ? "true" : "false";
            }
        }
        return matrix;
    }

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) {
            return "rock";
        } else if (rand < 0.66) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (compareStrings(userChoice, computerChoice)) {
            return "tie";
        }
        if (compareStrings(userChoice, "rock")) {
            return compareStrings(computerChoice, "scissors") ? "user" : "computer";
        }
        if (compareStrings(userChoice, "paper")) {
            return compareStrings(computerChoice, "rock") ? "user" : "computer";
        }
        if (compareStrings(userChoice, "scissors")) {
            return compareStrings(computerChoice, "paper") ? "user" : "computer";
        }
        return "invalid";
    }

    public static String[][] computeMatchStatistics(int userWins, int computerWins, int totalMatches) {
        String[][] stats = new String[2][3];
        
        double userAvg = (double) userWins / totalMatches;
        double compAvg = (double) computerWins / totalMatches;
        double userPct = userAvg * 100;
        double compPct = compAvg * 100;

        stats[0][0] = "User Stats";
        stats[0][1] = String.valueOf(userAvg);
        stats[0][2] = String.valueOf(userPct) + "%";

        stats[1][0] = "Computer Stats";
        stats[1][1] = String.valueOf(compAvg);
        stats[1][2] = String.valueOf(compPct) + "%";

        return stats;
    }

    public static void runRockPaperScissorsSimulation(Scanner scanner, int totalMatches) {
        int userWins = 0;
        int computerWins = 0;
        int currentMatch = 1;

        while (currentMatch <= totalMatches) {
            System.out.print("\n[Match " + currentMatch + "] Enter rock, paper, or scissors: ");
            String userChoice = scanner.next();
            userChoice = userChoice.toLowerCase();

            if (!compareStrings(userChoice, "rock") && !compareStrings(userChoice, "paper") && !compareStrings(userChoice, "scissors")) {
                System.out.println("Invalid selection string choice. Re-playing current match execution match cycle.");
                continue;
            }

            String compChoice = getComputerChoice();
            System.out.println("Computer chose: " + compChoice);

            String status = determineWinner(userChoice, compChoice);
            if (compareStrings(status, "user")) {
                System.out.println("Result: Match went to Player.");
                userWins++;
            } else if (compareStrings(status, "computer")) {
                System.out.println("Result: Match went to Computer.");
                computerWins++;
            } else {
                System.out.println("Result: Match verified as Tie.");
            }
            currentMatch++;
        }

        System.out.println("\n=== Game Summary Data Matrix ===");
        System.out.println("Total Simulated Games: " + totalMatches);
        System.out.println("Player Total Matches Won: " + userWins);
        System.out.println("Computer Total Matches Won: " + computerWins);
        System.out.println("Ties Logged: " + (totalMatches - (userWins + computerWins)));

        String[][] targetPerformanceStats = computeMatchStatistics(userWins, computerWins, totalMatches);
        System.out.println();
        display2DArray(targetPerformanceStats, new String[]{"Competitor", "Average Metric Wins", "Winning Percentage Metric %"});
    }

    public static void display2DArray(String[][] matrix, String[] columnHeaders) {
        for (int k = 0; k < columnHeaders.length; k++) {
            System.out.print(columnHeaders[k] + "\t\t");
        }
        System.out.println("\n------------------------------------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateRandomMarks(int numStudents) {
        int[][] marks = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            marks[i][0] = (int) (Math.random() * 91) + 10;
            marks[i][1] = (int) (Math.random() * 91) + 10;
            marks[i][2] = (int) (Math.random() * 91) + 10;
        }
        return marks;
    }

    public static double[][] calculateMetrics(int[][] marks) {
        double[][] metrics = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;
            
            metrics[i][0] = Math.round(total * 100.0) / 100.0;
            metrics[i][1] = Math.round(average * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    public static String[][] calculateGrades(double[][] metrics) {
        String[][] grades = new String[metrics.length][2];
        for (int i = 0; i < metrics.length; i++) {
            double pct = metrics[i][2];
            if (pct >= 80) {
                grades[i][0] = "A";
                grades[i][1] = "(Level 4, above agency-normalized standards)";
            } else if (pct >= 70) {
                grades[i][0] = "B";
                grades[i][1] = "(Level 3, at agency-normalized standards)";
            } else if (pct >= 60) {
                grades[i][0] = "C";
                grades[i][1] = "(Level 2, below, but approaching agency-normalized standards)";
            } else if (pct >= 50) {
                grades[i][0] = "D";
                grades[i][1] = "(Level 1, well below agency-normalized standards)";
            } else if (pct >= 40) {
                grades[i][0] = "E";
                grades[i][1] = "(Level 1-, too below agency-normalized standards)";
            } else {
                grades[i][0] = "R";
                grades[i][1] = "(Remedial standards)";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] marks, double[][] metrics, String[][] grades) {
        System.out.println("\n========================================================================================================================");
        System.out.printf("%-10s | %-7s | %-7s | %-7s | %-7s | %-7s | %-10s | %-5s | %-50s\n", 
                "Student ID", "Physics", "Chem", "Math", "Total", "Average", "Percentage", "Grade", "Remarks");
        System.out.println("========================================================================================================================");
        
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Student %-3d | %-7d | %-7d | %-7d | %-7.2f | %-7.2f | %-9.2f%% | %-5s | %-50s\n",
                    (i + 1),
                    marks[i][0], marks[i][1], marks[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2],
                    grades[i][0], grades[i][1]);
        }
        System.out.println("========================================================================================================================");
    }
}