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


    private static void appendNonNull(List<Node> queue, Node node) {
        if (node != null) {
            queue.add(node);
        }
    }

    private static void prependNonNull(List<Node> queue, Node node) {
        if (node != null) {
            queue.add(0, node);
        }
    }

    public static int[] levelorderSpiral(Node root) {
        List<Integer> traversal = new ArrayList<>();
        if (root != null) {
            List<Node> forward = new LinkedList<>();
            List<Node> backward = new LinkedList<>();
            traversal.add(root.value);
            forward.add(root.left);
            forward.add(root.right);
            while (!forward.isEmpty() || !backward.isEmpty()) {
                for (Node n : forward) {
                    traversal.add(n.value);
                    prependNonNull(backward, n.left);
                    prependNonNull(backward, n.right);
                }
                forward.clear();

                for (Node n : backward) {
                    traversal.add(n.value);
                    prependNonNull(forward, n.right);
                    prependNonNull(forward, n.left);
                }
                backward.clear();
            }
        }

        return Ints.toArray(traversal);
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
        Node r3 = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8),
                                new Node(9)
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
                ));
        int[] traversal;
        traversal = preorder(r3);
        System.out.println("preorder: " + Arrays.toString(traversal));

        traversal = inorder(r3);
        System.out.println("inorder: " + Arrays.toString(traversal));

        traversal = postorder(r3);
        System.out.println("postorder: " + Arrays.toString(traversal));

        traversal = levelorder(r3);
        System.out.println("levelorder: " + Arrays.toString(traversal));

        BST_Utils.printNode(r3);

        traversal = levelorderSpiral(r3);
        System.out.println("levelorderSpiral: " + Arrays.toString(traversal));
    }
}
