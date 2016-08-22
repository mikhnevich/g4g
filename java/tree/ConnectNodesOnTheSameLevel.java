package tree;

/**
 * Created @ 6/9/2014
 *
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 * TODO iterative
 *
 * Write a function to connect all the adjacent nodes at the same level in a binary tree.
 *
 Input Tree
     A
    / \
   B   C
  / \   \
 D   E   F

 Output Tree
     A--->NULL
    / \
   B-->C-->NULL
  / \   \
 D-->E-->F-->NULL
 *
 */
public class ConnectNodesOnTheSameLevel {
    public static void connect(Node root) {
        root.rightSibling = null;
        connectInternal(root);
    }

    private static void connectInternal(Node p) {
        if (p == null) {
            return;
        }
        if (p.rightSibling != null) {
            connectInternal(p.rightSibling);
        }

        if (p.left != null) {
            if (p.right != null) {
                p.left.rightSibling = p.right;
                p.right.rightSibling = getNextRight(p);
            } else {
                p.left.rightSibling = getNextRight(p);
            }
            connectInternal(p.left);
        } else if (p.right != null) {
            p.right.rightSibling = getNextRight(p);
            connectInternal(p.right);
        }
        connectInternal(getNextRight(p));
    }

    private static Node getNextRight(Node p) {
        Node t = p.rightSibling;
        while (t != null) {
            if (t.left != null) {
                return t.left;
            }
            if (t.right != null) {
                return t.right;
            }
            t = t.rightSibling;
        }
        return null;
    }

    public static void main(String[] args) {
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

    }

}
