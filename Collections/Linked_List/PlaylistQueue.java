package Collections.Linked_List;

public class PlaylistQueue {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void insertAfter(Node current, int trackId) {
        if (current == null) return;
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }
}
