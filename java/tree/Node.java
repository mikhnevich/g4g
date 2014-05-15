package tree;

/**
 * Created by user @ 3/18/14 4:52 PM
 */
public class Node {
    public enum Color {
        Red,
        Black
    }

    int value;
    Node left;
    Node right;

    // for AVL trees
    int height = 1;

    // for RB tree
    Color color = Color.Red;
    Node p;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", height=" + height +
                ", color=" + color +
                '}';
    }
}
