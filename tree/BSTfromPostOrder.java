package tree;

/**
 * http://stackoverflow.com/questions/13167536/how-to-construct-bst-given-post-order-traversal
 */
public class BSTfromPostOrder {

    public static Node fromPostOrder(int[] traversal) {
        return fromPostOrder(traversal, 0, traversal.length - 1);
    }

    private static Node fromPostOrder(int[] traversal, int start, int end) {
        int length = end - start + 1;
        if (length == 0) {
            return null;
        }
        int rootValue = traversal[end];
        int lastLeft = findLastLeft(traversal, start, end);
        Node left = fromPostOrder(traversal, start, lastLeft);
        Node right = fromPostOrder(traversal, lastLeft + 1, end - 1);
        return new Node(rootValue, left, right);
    }

    private static int findLastLeft(int[] traversal, int start, int end) {
        int idx = 0;
        while (traversal[idx] < traversal[end]) {
            idx++;
        }
        return idx < end ? idx - 1 : start - 1;
    }

    public static void main(String[] args) {
        final Node n7 = new Node(14);
        final Node n8 = new Node(11);
        final Node n6 = new Node(10, null, n8);
        final Node n3 = new Node(12, n6, n7);
        final Node n5 = new Node(7);
        final Node n4 = new Node(4);
        final Node n2 = new Node(6, n4, n5);
        final Node n1 = new Node(8, n2, n3);
        Node[] nodes = new Node[] {n1, n2, n3, n4, n5, n6, n7, n8};
        Node root = n1;
        BST_Utils.printNode(root);

        int[] traversal = Traversal.postorder(root);
        Node restored = fromPostOrder(traversal);
        BST_Utils.printNode(restored);



    }
}
