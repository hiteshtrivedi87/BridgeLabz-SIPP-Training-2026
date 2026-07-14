package Collections.BinarySearch;

public class FirstLastOccurrence {

    public int[] searchRange(int[] arr, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = findFirst(arr, target);
        result[1] = findLast(arr, target);
        return result;
    }

    private int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                index = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    private int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                index = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}