package tree;


import java.util.HashSet;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * The idea is to traverse the tree. Keep storing all ancestors till we hit a leaf node. When we reach a leaf node, we print the ancestor at distance k. We also need to keep track of nodes that are already printed as output. For that we use a boolean array visited[].
 */
public class PrintNodesAtKdistanceFromLeaf {

    public static void printNodes(Node root, int k) {
        int height = getHeight(root);
        Node[] path = new Node[height];
        Set<Node> printed = new HashSet<>();
        printNodesInternal(path, printed, 0, root, k);
    }

    private static int getHeight(Node root) {
        return 100;
    }


    public static void printNodesInternal(Node path[], Set<Node> printed, int level, Node root, int k) {
        if (root == null) {
            if (level >= k) {
                final int idx = level - k - 1;
                Node n = path[idx];
                if (!printed.contains(n)) {
                    System.out.println(n.value);
                    printed.add(n);
                }
            }
            return;
        }
        path[level] = root;

        printNodesInternal(path, printed, level + 1, root.left, k);
        printNodesInternal(path, printed, level + 1, root.right, k);
        printed.remove(root);
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
        printNodes(r3, 2);

    }
}
