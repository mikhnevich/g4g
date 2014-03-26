package tree;

/**
 * Created on 3/25/2014.
 */
public class Diameter {
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        return left + right
    }

    public static Pair<Integer, Integer> diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        return left + right
    }

    public static void main(String[] args) {

        Node r = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8,
                                        new Node(16),
                                        new Node(17)),
                                new Node(9,
                                        new Node(18),
                                        new Node(19))
                        ),
                        new Node(5,
                                new Node(10,
                                        new Node(20),
                                        new Node(21)),
                                new Node(11,
                                        new Node(22),
                                        new Node(23))
                        )
                ),
                new Node(3,
                        new Node(6,
                                new Node(12,
                                        new Node(24),
                                        new Node(25)),
                                new Node(13,
                                        new Node(26),
                                        new Node(27))
                        ),
                        new Node(7,
                                new Node(14,
                                        new Node(28),
                                        new Node(29)),
                                new Node(15,
                                        new Node(30),
                                        new Node(31))
                        )
                ));

        BST_Utils.printNode(r);

        int d = diameter(r);
        System.out.println(d);
    }
}
