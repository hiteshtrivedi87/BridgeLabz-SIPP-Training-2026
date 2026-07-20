package Collections.Trees;

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

    private static int diameter = 0;

    public static int longestCommunicationPath(Node root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    private static int heightAndUpdateDiameter(Node node) {
        if (node == null) return -1;

        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
