package tree;


public class DoubleTree {

    public static void main(String[] args) {
        Node root = new Node(2,
                new Node(1),
                new Node(3)
        );
        //                    8
        //                  /   \
        //                4      10
        //              /  \     / \
        //            2     6  9   11
        //          / \    / \     /
        //         1   3  5  7    12
        //
        //
        //
        doubleTree(root);
        BST_Utils.printNode(root);
    }

    /*
          2                2
         / \    ->        / \
        1   3            2   3
                        /    /
                       1    3
                      /
                     1
     */

    public static Node doubleTree(Node root) {
        if (root == null) {
            return null;
        }
        root.left = new Node(root.value,
                doubleTree(root.left),
                null);
        root.right = doubleTree(root.right);
        return root;
    }

}
