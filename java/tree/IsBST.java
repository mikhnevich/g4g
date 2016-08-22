package tree;

/*

*/
public class IsBST {

    public static boolean isBST(Node root) {
       return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        boolean result = root.data > min && root.data < max;
        result &= isBST(root.left, min, root.data) &&
                isBST(root.right, root.data, max);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(7,
                new Node(4,
                        null,
                        new Node(8)
                ),
                new Node(9)
        );
/*
        Node root = new Node(7,
                new Node(4,
                        null,
                        new Node(6)
                ),
                new Node(9)
        );
*/
        System.out.println(isBST(root));
    }

}
