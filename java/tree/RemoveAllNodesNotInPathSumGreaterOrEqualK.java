package tree;

/**
 * Created on 3/27/2014.
 * http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
 * Remove all nodes which don’t lie in any path with sum>= k
 * <p>
 * Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
 * <p>
 * Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.
 * <p>
 * Consider the following Binary Tree
 * <p>
 * 1
 * /      \
 * 2        3
 * /   \     /  \
 * 4     5   6    7
 * / \    /       /
 * 8   9  12      10
 * / \              \
 * 13  14             11
 * /
 * 15
 * <p>
 * </p>
 * <p>
 * For input k = 20, the tree should be changed to following
 * (Nodes with values 6 and 8 are deleted)
 * <p>
 * 1
 * /      \
 * 2        3
 * /   \        \
 * 4     5        7
 * \    /       /
 * 9  12      10
 * / \           \
 * 13  14         11
 * /
 * 15
 * </p>
 * <p>
 * <p>
 * For input k = 45, the tree should be changed to following.
 * 1
 * /
 * 2
 * /
 * 4
 * \
 * 9
 * \
 * 14
 * /
 * 15
 */
public class RemoveAllNodesNotInPathSumGreaterOrEqualK {

    public static Node removeNodes(Node root, int k) {
        int sum = removeNodes(root, k, 0);
        if (sum < k) {
            return null;
        }
        return root;
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
        r = removeNodes(r, 45);
        BST_Utils.printNode(r);
    }


}
