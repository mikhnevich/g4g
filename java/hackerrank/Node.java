package hackerrank;

/**
 * Created by user on 8/12/2016.
 */
public class Node {
    int data;
    Node left;
    Node right;

    @Override
    public String toString() {
        return toString(0);
    }


    private String toString(int tabs) {
        String pad = new String(new char[tabs]).replace("\0", "\t");
        return "Node {" + data +
                "\n" + pad + "left=" + (left == null ? "" : left.toString(tabs + 1)) +
                "\n" + pad + "right=" + (right == null ? "" : right.toString(tabs + 1)) +
                "\n" + pad + '}';
    }

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
