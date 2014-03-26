package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 * Question: Given a binary tree, find out if the tree can be folded or not.
 * <p>
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other.
 * An empty tree is considered as foldable.
 * <p>
 * Consider the below trees:
 * (a) and (b) can be folded.
 * (c) and (d) cannot be folded.
 * <p>
 * (a)
 *   10
 * /    \
 * 7      15
 * \      /
 * 9    11
 * <p>
 * (b)
 *    10
 *   /  \
 *  7    15
 * /      \
 * 9       11
 * <p>
 * (c)
 *      10
 *    /  \
 *   7   15
 *  /    /
 * 5   11
 * <p>
 * (d)
 * <p>
 *       10
 *     /   \
 *    7     15
 *  /  \    /
 * 9   10  12
 */
public class IsFoldable {

    public static boolean isFoldable(Node root) {
        if (root == null) {
            return true;
        }
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();
        left.add(root.left);
        right.add(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            Node ln = left.remove(0);
            Node rn = right.remove(0);
            if ((ln == null && rn != null) || (ln != null && rn == null)) {
                return false;
            }
            if (ln != null) {
                left.add(ln.left);
                left.add(ln.right);
                right.add(rn.right);
                right.add(rn.left);
            }
        }
        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        null,
                        new Node(4)),
                new Node(3,
                        new Node(5),
                        null));
        System.out.println(isFoldable(root));

        Node root2 = new Node(1,
                new Node(2,
                        new Node(4),
                        null),
                new Node(3,
                        null,
                        new Node(5)));
        System.out.println(isFoldable(root2));

        Node root3 = new Node(1,
                new Node(2,
                        new Node(4),
                        null),
                new Node(3,
                        new Node(5),
                        null));
        System.out.println(isFoldable(root3));

        Node root4 = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5)),
                new Node(3,
                        new Node(6),
                        null));
        System.out.println(isFoldable(root4));

    }
}
