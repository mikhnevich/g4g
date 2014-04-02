package tree;

import util.Pair;

/**
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 */
public class Diameter {
    public static int diameter(Node root) {
        return diameterInternal(root).getRight();
    }

    public static Pair<Integer, Integer> diameterInternal(Node root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> left = diameterInternal(root.left);
        Pair<Integer, Integer> right = diameterInternal(root.right);
        final Integer leftPath = left.getLeft();
        final Integer rightPath = right.getLeft();
        final Integer leftDiameter = left.getRight();
        final Integer rightDiameter = right.getRight();

        int maxPath = Math.max(leftPath, rightPath);
        int maxDiameter = Math.max(leftDiameter, rightDiameter);
        int currentDiameter = leftPath + rightPath + 1;
        return new Pair<>(maxPath + 1, Math.max(currentDiameter, maxDiameter));
    }

    public static void main(String[] args) {

        Node r = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(7),
                                new Node(8)
                        )
                ),
                new Node(3,
                        null,
                        new Node(6,
                                null,
                                new Node(9,
                                        new Node(10,
                                                new Node(12),
                                                new Node(13)),
                                        new Node(11)
                                )
                        )
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

        int d = diameter(r);
        System.out.println(d);

        int d2 = diameter(r2);
        System.out.println(d2);
    }
}
