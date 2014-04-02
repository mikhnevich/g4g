package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user2 on 3/18/14.
 */
public class DistanceBetweenKeys {

    public int distance(Node root, Node n1, Node n2) {
        List<Node> path1 = new LinkedList<>();
        List<Node> path2 = new LinkedList<>();
        findNodes(root, n1, n2, path1, path2);
        int lcaDist = findLcaDiff(path1, path2);
        return path1.size() + path2.size() - 2*lcaDist;
    }

    private int findLcaDiff(List<Node> path1, List<Node> path2) {
        int i = 0;
        int j = 0;
        while (i < path1.size() && j < path2.size() && path1.get(i).equals(path2.get(j))) {
            i++;
            j++;
        }
        return i - 1;
    }

    public void findNodes(Node root, Node n1, Node n2, List<Node> path1, List<Node> path2) {
        // dist = dist(root, n1) + dist(root, n2) - 2*dist(root, lca)
        if (root == null) {
            return;
        }
        boolean n1Found = found(path1, n1);
        boolean n2Found = found(path2, n2);
        if (!n1Found) {
            path1.add(root);
        }
        if (!n2Found) {
            path2.add(root);
        }
        if (!n1Found || !n2Found) {
            findNodes(root.left, n1, n2, path1, path2);
            findNodes(root.right, n1, n2, path1, path2);
        }
    }

    private boolean found(List<Node> path1, Node n1) {
        return !path1.isEmpty() && path1.get(path1.size() - 1).equals(n1);
    }
}
