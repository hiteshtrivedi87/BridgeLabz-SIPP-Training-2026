package Collections.BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class Scenario5 {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k out of range");
    }
}
