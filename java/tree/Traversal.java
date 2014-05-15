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

    public static int[] preorderIterative(Node root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> q = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.pop();
            if (n != null) {
                traversal.add(n.value);
                q.push(n.right);
                q.push(n.left);
            }
        }
        return Ints.toArray(traversal);
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

    public static int[] inorderIterative(Node root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> t = new Stack<>();
        Stack<Node> q = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.pop();
            if (n != null) {
                t.push(n);
                q.push(n.right);
                q.push(n.left);
            } else {
                if (!t.isEmpty()) {
                    traversal.add(t.pop().value);
                }
            }
        }
        while (!t.isEmpty()) {
            traversal.add(t.pop().value);
        }
        return Ints.toArray(traversal);
    }

    public static int[] inorderIterativeLeetCode(Node root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> q = new Stack<>();
        Node current = root;
        while (!q.isEmpty() || current != null) {
            if (current != null) {
                q.push(current);
                current = current.left;
            } else {
                Node n = q.pop();
                traversal.add(n.value);
                current = n.right;
            }
        }
        return Ints.toArray(traversal);
    }

    // morris travel
    public static int[] inorderConstantSpace(Node root) {
        Node cur = root;
        List<Integer> values = new ArrayList<>();

        while (cur != null) {
            if (cur.left != null) {
                Node pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) { // set right to successor
                    pre.right = cur;
                    cur = cur.left;
                } else { // visit and revert the change
                    pre.right = null;
                    values.add(cur.value);
                    cur = cur.right;
                }
            } else {
                values.add(cur.value);
                cur = cur.right;
            }
        }
        return Ints.toArray(values);
    }

    public static int[] postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
        postorder(root, traversal);
        return Ints.toArray(traversal);
    }

    /*
    http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
     */
    public static int[] postorderIterative(Node root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Node> q = new Stack<>();
        if (root != null) {
            Node previous = null;
            q.add(root);
            while (!q.isEmpty()) {
                Node current = q.peek();
                if (previous == null || previous.right == current || previous.left == current) {
                    if (current.left != null) {
                        q.push(current.left);
                    } else if (current.right != null) {
                        q.push(current.right);
                    } else {
                        traversal.add(current.value);
                        q.pop();
                    }
                } else if (previous == current.left) {
                    if (current.right == null) {
                        traversal.add(current.value);
                        q.pop();
                    } else {
                        q.push(current.right);
                    }
                } else if (previous == current.right) {
                    traversal.add(current.value);
                    q.pop();
                }
                previous = current;

            }
        }
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

        int[] traversal;
        traversal = preorder(r3);
        System.out.println("preorder: " + Arrays.toString(traversal));

        traversal = preorderIterative(r3);
        System.out.println("preorder iterative: " + Arrays.toString(traversal));

        traversal = inorder(r3);
        System.out.println("inorder: " + Arrays.toString(traversal));

        traversal = inorderIterative(r3);
        System.out.println("inorder iterative: " + Arrays.toString(traversal));

        traversal = inorderIterativeLeetCode(r3);
        System.out.println("inorder iterative leet: " + Arrays.toString(traversal));

        traversal = inorderConstantSpace(r3);
        System.out.println("inorder constant space: " + Arrays.toString(traversal));

        traversal = postorder(r3);
        System.out.println("postorder: " + Arrays.toString(traversal));

        traversal = postorderIterative(r3);
        System.out.println("postorder iterative: " + Arrays.toString(traversal));

        traversal = levelorder(r3);
        System.out.println("levelorder: " + Arrays.toString(traversal));

        traversal = levelorderSpiral(r3);
        System.out.println("levelorderSpiral: " + Arrays.toString(traversal));
    }
}
