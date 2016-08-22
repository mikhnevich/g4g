package tree;

/**
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 */
public class MirrorTree {

    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        return new Node(root.data, right, left);
    }

    public static void main(String[] args) {
        Node r1 = new Node(10,
                new Node(5),
                new Node(100,
                        new Node(50,
                                new Node(40), null),
                        new Node(150)));
        BST_Utils.printNode(r1);
        Node m = mirror(r1);
        BST_Utils.printNode(m);
    }

}
