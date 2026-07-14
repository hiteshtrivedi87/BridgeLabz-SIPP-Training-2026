package Collections.Two_Pointers_Sliding_Windows;

public class CpuSpikeDetector {

    public int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        
        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }
}
