package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/27/2014.
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/

 Print ancestors of a given binary tree node without recursion
 Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.

 For example, consider the following Binary Tree

             1
         /      \
        /        \
       2          3
     /   \      /   \
    4     5    6    7
   /       \       /
 8         9     10
 Following are different input keys and their ancestors in the above tree

 Input Key    List of Ancestors
 -------------------------
 1
 2            1
 3            1
 4            2 1
 5            2 1
 6            3 1
 7            3 1
 8            4 2 1
 9            5 2 1
 10           7 3 1

 */
public class AncestorsNoRecursive {

    public static void ancestors(Node root, int value) {
        if (root == null) {
            return;
        }
        List<Node> path = new ArrayList<>();
        List<Node> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove(0);
            if (n.data == value) {
//                printNodes(path);
                return;
            }

        }
    }

    private static int removeNodes(Node root, int k, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum + root.data;
        if (sum >= k) {
            return sum;
        }
        int left = removeNodes(root.left, k, sum);
        int right = removeNodes(root.right, k, sum);
        sum = Math.max(Math.max(left, right), sum);
        if (left < k && right < k) {
            root.left = null;
            root.right = null;
            return left;
        }
        if (left < k) {
            root.left = null;
        }
        if (right < k) {
            root.right = null;
        }
        return (left < k && right < k) ? 0 : sum;
    }


    public static void main(String[] args) {
        Node r = new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8),
                                new Node(9,
                                        new Node(13),
                                        new Node(14,
                                                new Node(15),
                                                null))),
                        new Node(5,
                                new Node(12),
                                null)
                ),
                new Node(3,
                        new Node(6),
                        new Node(7,
                                new Node(10,
                                        null,
                                        new Node(11)),
                                null)
                )
        );
        BST_Utils.printNode(r);
//        r = removeNodes(r, 45);
        BST_Utils.printNode(r);
    }


}
