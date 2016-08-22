package tree;


import util.Pair;

public class CheckChildrenSumProperty {

    public static boolean check(Node root) {
        return checkInternal(root).getLeft();
    }


    private static Pair<Boolean, Integer> checkInternal(Node root) {
        if (root == null) {
            return new Pair<>(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new Pair<>(true, root.data);
        }
        Pair<Boolean, Integer> left = checkInternal(root.left);
        if (!left.getLeft()) {
            return new Pair<>(false, 0);
        }
        Pair<Boolean, Integer> right = checkInternal(root.right);
        if (!right.getLeft()) {
            return new Pair<>(false, 0);
        }
        final int childrenSum = left.getRight() + right.getRight();
        final boolean sumProperty = childrenSum == root.data;
        return new Pair<>(sumProperty, root.data);
    }



    public static void main(String[] args) {
        Node r3 = new Node(10,
                new Node(8,
                        new Node(3),
                        new Node(5)),
                new Node(2,
                        new Node(2),
                        null
                )
        );
        BST_Utils.printNode(r3);
        System.out.println(check(r3));
    }
}
