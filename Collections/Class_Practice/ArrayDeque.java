import java.util.Deque;

public class ArrayDeque {
    public static void main(String[] args) {
        Deque<String> stack = new java.util.ArrayDeque<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);

        Deque<String> queue = new java.util.ArrayDeque<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
    }
}
