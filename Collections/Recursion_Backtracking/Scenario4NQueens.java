package Collections.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Scenario4NQueens {

    public static List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] sensorCol = new int[n];
        backtrack(n, 0, sensorCol, result);
        return result;
    }

    private static void backtrack(int n, int row, int[] sensorCol, List<List<String>> result) {
        if (row == n) {
            result.add(buildGrid(n, sensorCol));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;
                backtrack(n, row + 1, sensorCol, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] sensorCol) {
        for (int r = 0; r < row; r++) {
            if (sensorCol[r] == col) return false;
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) return false;
        }
        return true;
    }

    private static List<String> buildGrid(int n, int[] sensorCol) {
        List<String> grid = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int c = 0; c < n; c++) {
                rowBuilder.append(sensorCol[r] == c ? "S " : ". ");
            }
            grid.add(rowBuilder.toString().trim());
        }
        return grid;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> placements = placeSensors(n);

        System.out.println("Valid grid placements for N = " + n + ":\n");
        for (int i = 0; i < placements.size(); i++) {
            System.out.println("Option " + (i + 1) + ":");
            for (String row : placements.get(i)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
