package tree;

import java.util.Arrays;

/**
 * Created on 4/29/2014.
 */
public class Flatten {

    public static Node flatten(Node root) {
        if (root == null) return root;
        Node rtree = root.right;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            root = flatten(root.right);
        }
        if (rtree != null) {
            root.right = rtree;
            root = flatten(root.right);
        }
        return root;

    }

    public static void main(String[] args) {
        Node r = new Node(1,
                new Node(2),
                new Node(3)
        );
        Node r3 = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8),
                                new Node(9,
                                        null,
                                        new Node(0))
                        ),
                        new Node(5,
                                new Node(10),
                                new Node(11)
                        )
                ),
                new Node(3,
                        new Node(6,
                                new Node(12),
                                new Node(13)
                        ),
                        new Node(7,
                                new Node(14),
                                new Node(15)
                        )
                )
        );
        BST_Utils.printNode(r3);
        Node n = flatten(r3);
        System.out.println(n);
    }

}
