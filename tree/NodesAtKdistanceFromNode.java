package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * There are two types of nodes to be considered.
 1) Nodes in the subtree rooted with target node. For example if the target node is 8 and k is 2, then such nodes are 10 and 14.
 2) Other nodes, may be an ancestor of target, or a node in some other subtree. For target node 8 and k is 2, the node 22 comes in this category.

 Finding the first type of nodes is easy to implement. Just traverse subtrees rooted with the target node and decrement k in recursive call. When the k becomes 0, print the node currently being traversed (See this for more details). Here we call the function as printkdistanceNodeDown().

 How to find nodes of second type? For the output nodes not lying in the subtree with the target node as the root, we must go through all ancestors. For every ancestor, we find its distance from target node, let the distance be d, now we go to other subtree (if target was found in left subtree, then we go to right subtree and vice versa) of the ancestor and find all nodes at k-d distance from the ancestor.


 Time Complexity: At first look the time complexity looks more than O(n), but if we take a closer look, we can observe that no node is traversed more than twice. Therefore the time complexity is O(n).


 Note: the solution below could be simplified - to pass information whether node is found to up (distance from the node, so only one traversal
 is required, time complexity now is O(n) with constant == 2
 */
public class NodesAtKdistanceFromNode {

    public static void findNodes(Node root, Node node, int k) {
        List<Node> path = new ArrayList<>();
        findNodesInternal(root, node, path, k);
    }

    public static boolean findNodesInternal(Node root, Node node, List<Node> path, int k) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (node == root) {
            if (k == 0) {
                System.out.println(node.value);
            } else {
                final int pathSize = path.size();
                int length = Math.min(pathSize - 1, k);
                for (int i = 1; i <= length; i++) {
                    final int index = pathSize - i - 1;
                    Node n = path.get(index);
                    int distance = k - i;
                    findAtKdistanceFrom(n, path.get(index + 1), distance);
                }
                findAtKdistanceFrom(node.left, null, k - 1);
                findAtKdistanceFrom(node.right, null, k - 1);
            }
        }

        boolean found = findNodesInternal(root.left, node, path, k);
        if (!found) {
            found = findNodesInternal(root.right, node, path, k);
        }
        path.remove(path.size() - 1);
        return found;
    }

    private static Node getAnotherChild(Node root, Node notTheChild) {
        if (root.left == notTheChild) {
            return root.right;
        }
        return root.left;
    }

    private static void findAtKdistanceFrom(Node node, Node excluded, int distance) {
        if (node == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(node.value);
        } else {
            if (node.left != excluded) {
                findAtKdistanceFrom(node.left, null, distance - 1);
            }
            if (node.right != excluded) {
                findAtKdistanceFrom(node.right, null, distance - 1);
            }
        }

    }

    public static void main(String[] args) {
        final Node n7 = new Node(7);
        final Node n8 = new Node(8);
        final Node n6 = new Node(6, null, n8);
        final Node n3 = new Node(3, n6, n7);
        final Node n5 = new Node(5);
        final Node n4 = new Node(4);
        final Node n2 = new Node(2, n4, n5);
        final Node n1 = new Node(1, n2, n3);
        Node[] nodes = new Node[] {n1, n2, n3, n4, n5, n6, n7, n8};
        Node root = n1;
        for (Node node : nodes) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Node: " + node.value + ", distance: " + i);
                findNodes(root, node, i);
            }
        }
    }
}
