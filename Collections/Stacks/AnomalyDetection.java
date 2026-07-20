package Collections.Stacks;

import java.util.Deque;
import java.util.ArrayDeque;

class AnomalyDetection {
    public int[] loadSpan(int[] load) {
        int n = load.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}
