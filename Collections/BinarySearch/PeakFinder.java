package Collections.BinarySearch;

public class PeakFinder {

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean greaterThanLeft = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean greaterThanRight = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (greaterThanLeft && greaterThanRight) {
                return mid;
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
