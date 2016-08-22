package hackerrank;


/**
 * re-solving the problem for hackerrank.HackerRank
 */
public class LCA2 {

    static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1 || root.data == v2) {
            return root;
        }

        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);

        if (left != null && right == null) {
            // both values are in the left tree, they are guaranteed to be there
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }
        return null;

    }

    public static void main(String[] args) {
        /*
                      4
                    /   \
                  2       7
                /  \
              1     3
         */

        Node n = new Node(4,
                new Node(2,
                        new Node(1),
                        new Node(3)
                        ),
                new Node(7,
                        null,
                        new Node(6)
                )
        );
        System.out.println(n);
        Node lca = LCA2.lca(n, 1, 7);
        System.out.println(lca.data);
    }
}
