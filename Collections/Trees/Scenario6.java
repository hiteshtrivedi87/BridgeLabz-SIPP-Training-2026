package Collections.Trees;

public class Scenario6 {
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

    public static void deleteFolderTree(Node node) {
        if (node == null) return;

        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }

    private static void deleteNode(Node node) {
        System.out.println("Deleted node: " + node.val);
    }
}
