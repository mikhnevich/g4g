package tree;

import util.Pair;

/**
 * http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
 An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 1) Left subtree of T is balanced
 2) Right subtree of T is balanced
 3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class IsBalanced {
    public static boolean isBalanced(Node root) {
        return isBalancedInternal(root).getLeft();
    }

    public static Pair<Boolean, Integer> isBalancedInternal(Node root) {
        if (root == null) {
            return new Pair<>(true, 0);
        }
        Pair<Boolean, Integer> left = isBalancedInternal(root.left);
        if (!left.getLeft()) {
            return new Pair<>(false, 0);
        }
        Pair<Boolean, Integer> right = isBalancedInternal(root.right);
        if (!right.getLeft()) {
            return new Pair<>(false, 0);
        }
        final Integer leftPath = left.getRight();
        final Integer rightPath = right.getRight();
        return new Pair<>(Math.abs(leftPath - rightPath) <= 1, Math.max(leftPath, rightPath) + 1);
    }

    public static void main(String[] args) {

        Node r = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(7),
                                null
                        )
                ),
                new Node(3,
                        new Node(6),
                        null
                )
        );

        Node r2 = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(7),
                                new Node(8,
                                        new Node(10,
                                                new Node(13),
                                                new Node(14)),
                                        null
                                )
                        ),
                        new Node(5,
                                null,
                                new Node(9,
                                        new Node(11),
                                        new Node(12,
                                                null,
                                                new Node(15))
                                )
                        )
                ),
                new Node(3,
                        null,
                        new Node(6)
                )
        );

        BST_Utils.printNode(r);

        System.out.println(isBalanced(r));
        System.out.println(isBalanced(r2));
    }
}
