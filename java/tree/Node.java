package tree;

/**
 * Created by user @ 3/18/14 4:52 PM
 */
public class Node {
    public enum Color {
        Red,
        Black
    }

    int data;
    Node left;
    Node right;

    // for AVL trees
    int height = 1;

    // for RB tree
    Color color = Color.Red;
    Node p;

    Node rightSibling;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", height=" + height +
                ", color=" + color +
                '}';
    }
}
