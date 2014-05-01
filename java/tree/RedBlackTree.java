package tree;

import static tree.Node.Color.Black;
import static tree.Node.Color.Red;

/**
 * Created @ 4/29/2014
 */
public class RedBlackTree {
    private static Node NIL;

    static {
        NIL = new Node(0);
        NIL.color = Black;
    }

    private Node root;

    public RedBlackTree() {
    }

    public void add(int value) {
        Node y = NIL;
        Node x = root;

        while (x != NIL) {
            y = x;
            if (value < x.value) {
                x = x.left;
            } else {
                x = x.right; // no duplicate check!!!
            }
        }
        Node z = new Node(value);
        z.p = y;
        if (y == NIL) {
            root = z;
        } else if (value < y.value) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = NIL;
        z.right = NIL;
        z.color = Red;
        fixRedBlack(z);
    }

    private void fixRedBlack(Node z) {
        while (z.p.color == Red) {
            if (z.p == z.p.p.left) {
                Node y = z.p.p.right;
                if (y.color == Red) {
                    z.p.color = Black;
                    y.color = Black;
                    z.p.p.color = Red;
                    z = z.p.p;
                }
            } else if (z == z.p.right) {
                z = z.p;
                leftRotate(z);
            }
        }
        root.color = Black;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == NIL) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
        return y;
    }


    private Node rightRotate(Node x) {
        return null;
    }


    private Node add(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else if (value < root.value) {
            root.left = add(root.left, value);
        } else if (value > root.value) {
            root.right = add(root.right, value);
        }
        return root;
    }
}
