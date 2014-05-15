package tree;


public class LCA {
    public static Integer lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.value == n1) {
            return n1;
        }
        if (root.value == n2) {
            return n1;
        }

        Integer left = lca(root.left, n1, n2);
        Integer right = lca(root.right, n1, n2);
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left == null) {
            return null;
        }
        return root.value;
    }

    public static Integer lcaBST(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (n1 < root.value && n2 < root.value) {
            return lcaBST(root.left, n1, n2);
        }
        if (n1 > root.value && n2 > root.value) {
            return lcaBST(root.left, n1, n2);
        }
        return root.value;
    }

    public static void main(String[] args) {
        Node root = new Node(8,
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(6,
                                new Node(5),
                                new Node(7))
                ),
                new Node(10,
                        new Node(9),
                        new Node(11,
                                new Node(12),
                                null)
                )
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
        System.out.println(lca(root, 4, 12));
        System.out.println(lca(root, 4, 1));
        System.out.println(lca(root, 5, 7));
        System.out.println(lca(root, 6, 2));
    }
}
