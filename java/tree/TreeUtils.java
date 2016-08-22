package tree;

/**
 * Created on 4/26/2014.
 */
public class TreeUtils {
    public static Node copy(Node root) {
        if (root == null) {
            return null;
        }
        return new Node(root.data,
                copy(root.left),
                copy(root.right));
    }
}
