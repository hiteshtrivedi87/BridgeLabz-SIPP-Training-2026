package Collections.sorting_algorithm;
public class InsertionSort {
    public static void insertionSort(int[] empIds) {
        int n = empIds.length;
        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;

           
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j = j - 1;
            }
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] empIds = {1004, 1001, 1005, 1002, 1003};
        insertionSort(empIds);
        System.out.println("Sorted Employee IDs: " + java.util.Arrays.toString(empIds));
    }
}