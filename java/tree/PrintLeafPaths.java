package tree;


import java.util.LinkedList;
import java.util.List;

public class PrintLeafPaths {

    public static void printLeafPaths(Node root) {
        List<Node> path = new LinkedList<>();
        List<Boolean> printed = new LinkedList<>();
        printLeafPaths(root, path, printed);
    }

    public static void printLeafPaths(Node root, List<Node> path, List<Boolean> printed) {
        if (root == null) {
            if (!printed.get(path.size() - 1)) {
                for (Node node : path) {
                    System.out.print(node.data + ", ");
                }
                System.out.println();
                printed.set(path.size() - 1, true);
            }
            return;
        }
        path.add(root);
        printed.add(false);
        printLeafPaths(root.left, path, printed);
        printLeafPaths(root.right, path, printed);
        final int lastIdx = path.size() - 1;
        path.remove(lastIdx);
        printed.remove(lastIdx);
    }

    public static void main(String[] args) {
        Node root = new Node(8,
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(6,
                                new Node(5),
                                new Node(7))
                ),
                new Node(10,
                        new Node(9),
                        new Node(11,
                                new Node(12),
                                null))
        );
        //                    8
        //                  /   \
        //                4      10
        //              /  \     / \
        //            2     6  9   11
        //          / \    / \     /
        //         1   3  5  7    12
        //
        //
        //
        printLeafPaths(root);
    }

}
