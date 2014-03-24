package tree;


import com.google.common.primitives.Ints;

import java.util.*;

public class Traversal {

    public static int[] preorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        preorder(root, traversal);
        return Ints.toArray(traversal);
    }

    private static void preorder(Node root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        traversal.add(root.value);
        preorder(root.left, traversal);
        preorder(root.right, traversal);
    }

    private static void print(int value) {
        System.out.print(value);
        System.out.print(" ");
    }

    public static int[] inorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        inorder(root, traversal);
        return Ints.toArray(traversal);
    }

    private static void inorder(Node root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        inorder(root.left, traversal);
        traversal.add(root.value);
        inorder(root.right, traversal);
    }

    public static int[] postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        postorder(root, traversal);
        return Ints.toArray(traversal);
    }

    private static void postorder(Node root, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        postorder(root.left, traversal);
        postorder(root.right, traversal);
        traversal.add(root.value);
    }

    public static int[] levelorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        if (root != null) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node n = q.remove();
                traversal.add(n.value);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return Ints.toArray(traversal);
    }


    public static void main(String[] args) {
        Node r3 = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5)),
                new Node(3,
                        new Node(6,
                                null,
                                new Node(8)),
                        new Node(7)
                )
        );
        int[] traversal;
        traversal = preorder(r3);
        System.out.println(Arrays.toString(traversal));

        traversal = inorder(r3);
        System.out.println(Arrays.toString(traversal));

        traversal = postorder(r3);
        System.out.println(Arrays.toString(traversal));

        traversal = levelorder(r3);
        System.out.println(Arrays.toString(traversal));
    }
}
