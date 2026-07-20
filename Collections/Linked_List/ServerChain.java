package Collections.Linked_List;

public class ServerChain {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}