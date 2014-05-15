package tree;

/**
 * http://www.geeksforgeeks.org/check-given-binary-tree-follows-height-property-red-black-tree/
 */
public class IsRBTree {
    //    For every node, length of the longest leaf to node path has not more than twice the nodes on shortest path from node to leaf
    public static boolean check(Node root) {
        Result r = checkInternal(root);
        return r.valid;
    }


    public static Result checkInternal(Node root) {
        if (root == null) {
            return new Result(true, 0, 0);
        }
        Result lr = checkInternal(root.left);
        if (!lr.valid) {
            return lr;
        }
        Result rr = checkInternal(root.right);
        if (!rr.valid) {
            return rr;
        }
        int min = Math.min(lr.min, rr.min) + 1;
        int max = Math.max(lr.max, rr.max) + 1;
        return new Result(min * 2 >= max, min, max);
    }

    private static class Result {
        boolean valid;
        int min;
        int max;

        private Result(boolean valid, int min, int max) {
            this.valid = valid;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Node r1 = new Node(12, null, new Node(14, null, new Node(16)));
        System.out.println(check(r1));

        Node r2 = new Node(40,
                new Node(10),
                new Node(100,
                        new Node(60), new Node(150)));
        System.out.println(check(r2));

        Node r3 = new Node(10,
                new Node(5),
                new Node(100,
                        new Node(50,
                                new Node(40), null),
                        new Node(150)));
        System.out.println(check(r3));


    }
}
