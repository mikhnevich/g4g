package tree;

/**
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 */
public class TreeEquals {

    public static boolean treeEquals(Node root1, Node root2) {
        if (root1 != null && root2 == null) {
            return false;
        } else if (root1 == null && root2 != null) {
            return false;
        } else if (root1 == null && root2 == null) {
            return true;
        }
        return root1.data == root2.data
                && treeEquals(root1.left, root2.left)
                && treeEquals(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Node r1 = new Node(10,
                new Node(5),
                new Node(100,
                        new Node(50,
                                new Node(40), null),
                        new Node(150)));

        Node r2 = new Node(10,
                new Node(5),
                new Node(100,
                        new Node(50,
                                new Node(40), null),
                        null));

        System.out.println(treeEquals(r1, r2));
    }

}
