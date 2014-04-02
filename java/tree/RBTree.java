package tree;

/**
 * Created by user @ 2/21/14 3:16 PM
 */
public class RBTree<T extends Comparable<T>> {
    private Node root;

    public enum Color {
        Red,
        Black
    }

    private class Node {
        T key;
        Object data;
        Node left, right;
        int N;
        Color color;

        private Node(T key, Object data, int n, Color color) {
            this.key = key;
            this.data = data;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed (Node x) {
        return x != null && x.color == Color.Red;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.right;
        x.left = h;
        x.color = h.color;
        h.color = Color.Red;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }


    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.left;
        x.right = h;
        x.color = h.color;
        h.color = Color.Red;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
}
