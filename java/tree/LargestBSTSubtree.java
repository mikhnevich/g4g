package tree;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
where largest means subtree with largest number of nodes in it.
*/
public class LargestBSTSubtree {
    private static class BstInfo {
        public Node n;
        public int size;
        public int min;
        public int max;
        public BstInfo subtree;

        public BstInfo(Node n, int size, int min, int max) {
            this(n, size, min, max, null);
        }

        public BstInfo(Node n, int size, int min, int max, BstInfo subtree) {
            this.n = n;
            this.size = size;
            this.min = min;
            this.max = max;
            this.subtree = subtree;
        }
    }

    public int largestBSTSubtree2(Node root) {
        int[] result = helper(root);
        return result[1];
    }

    // (c) http://yuancrackcode.com/2016/02/23/largest-bst-subtree/
    // just size, not the node itself.
    public int[] helper(Node root) {
        int[] result = new int[5];
        //result[0]: is BST? result[2] : total number of nodes, result[3]: maximum value, result[4] minimum value
        result[0] = 1;
        result[3] = Integer.MIN_VALUE;
        result[4] = Integer.MAX_VALUE;
        if (root == null) return result;
        int[] result_left = helper(root.left);
        int[] result_right = helper(root.right);
        if (result_left[0] == 0 || result_right[0] == 0 || root.data >= result_right[4] || root.data <= result_left[3]) {
            result[0] = 0;
        }//root is larger than the biggest node in left subtree and smaller than smallest node in right subtree
        result[2] = result_left[2] + result_right[2] + 1;
        result[1] = result[0] == 1 ? result[2] : Math.max(result_left[1], result_right[1]);
        result[3] = Math.max(root.data, Math.max(result_left[3], result_right[3]));
        result[4] = Math.min(root.data, Math.min(result_left[4], result_right[4]));
        return result;
    }


    public static Node largestBST(Node root) {
        return largestBSTHelper(root).n;
    }

    public static BstInfo largestBSTHelper(Node root) {
        boolean isBst = true;
        BstInfo subtreeBst = null;
        int childrenSize = 0;
        int min = root.data;
        int max = root.data;
        if (root.left != null) {
            BstInfo leftBst = largestBSTHelper(root.left);
            // child itself - must be BST
            if (leftBst.n == root.left) {
                isBst &= leftBst.max < root.data;
                childrenSize += leftBst.size;
                min = Integer.min(min, leftBst.min);
                subtreeBst = leftBst;
            } else {
                isBst = false;
                if (leftBst.subtree != null) {
                    subtreeBst = leftBst.subtree;
                }
            }
        }
        if (root.right != null) {
            BstInfo rightBst = largestBSTHelper(root.right);
            // child itself - must be BST
            if (rightBst.n == root.right) {
                isBst &= rightBst.min > root.data;
                childrenSize += rightBst.size;
                max = Integer.max(max, rightBst.max);
                if (subtreeBst != null) {
                    if (subtreeBst.size < rightBst.size) {
                        subtreeBst = rightBst;
                    }
                } else {
                    subtreeBst = rightBst;
                }
            } else {
                isBst = false;
                if (subtreeBst != null) {
                    if (subtreeBst.size < rightBst.size) {
                        subtreeBst = rightBst.subtree;
                    }
                } else {
                    subtreeBst = rightBst.subtree;
                }
            }
            if (rightBst.subtree != null) {
                if (subtreeBst.size < rightBst.size) {
                    subtreeBst = rightBst.subtree;
                }
            }
        }
        if (isBst) {
            return new BstInfo(root, childrenSize + 1, min, max);
        } else {
            return subtreeBst;
        }

    }


    public static void main(String[] args) {
        // expected: node 2
        Node root = new Node(50,
                new Node(30,
                        new Node(5),
                        new Node(20)
                ),
                new Node(60,
                        new Node(45),
                        new Node(70,
                                new Node(65),
                                new Node(80)
                        )
                )
        );
/*
        // expected: node 2
        Node root = new Node(5,
                new Node(2,
                        new Node(1),
                        new Node(3)
                ),
                new Node(4)
        );
*/
        System.out.println(largestBST(root));
    }
}
