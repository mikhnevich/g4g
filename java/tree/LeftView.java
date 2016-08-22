package tree;

/**
 * Created on 3/27/2014.
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side. Left view of following tree is 12, 10, 25.

         12
       /   \
     10     30
   /   \
 25     40
 The left view contains all nodes that are first nodes in their levels. A simple solution is to do level order traversal and print the first node in every level.

Solution: level order traversal, insert null to indicate start of the level.

 Below is another (recursive) solution.
 */
public class LeftView {


    public static void leftView(Node root) {
        leftView(root, 1, 0);
    }

    private static int leftView(Node root, int level, int levelPrinted) {
        if (root == null) {
            return levelPrinted;
        }
        int maxLevelPrinted = levelPrinted;
        if (level > maxLevelPrinted) {
            maxLevelPrinted = level;
            System.out.print(root.data);
            System.out.print(' ');
        }
        maxLevelPrinted = leftView(root.left, level + 1, maxLevelPrinted);
        maxLevelPrinted = leftView(root.right, level + 1, maxLevelPrinted);
        return maxLevelPrinted;
    }

    public static void main(String[] args) {
        final Node n16 = new Node(16);
        final Node n15 = new Node(15, null, n16);
        final Node n7 = new Node(14, null, n15);
        final Node n8 = new Node(11);
        final Node n6 = new Node(10, null, n8);
        final Node n3 = new Node(12, n6, n7);
        final Node n5 = new Node(7);
        final Node n4 = new Node(4);
        final Node n2 = new Node(6, n4, n5);
        final Node n1 = new Node(8, n2, n3);
        Node root = n1;
        BST_Utils.printNode(root);
        leftView(root);
    }
}
