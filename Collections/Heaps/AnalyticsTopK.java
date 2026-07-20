package Collections.Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AnalyticsTopK {

    public List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
