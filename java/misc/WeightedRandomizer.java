package misc;

import java.util.Random;

/*

*/
public class WeightedRandomizer {
    private Random random = new Random();
    public static class Node {
        private static Node Nil = new Node();

        private int level = 0;
        private String key;
        private Node left = Nil;
        private Node right = Nil;
        private int weight = 0;
        private int subtreeWeight = 0;

        public Node() {
        }

        public Node(String key, int weight) {
            this.key = key;
            this.weight = weight;
            this.subtreeWeight = weight;
            this.level = 1;
        }
    }

    private Node skew(Node root) {
        Node r = root;
        if (root.level != 0 && root.level == root.left.level) {
            int tmp = root.subtreeWeight;
            root.subtreeWeight = tmp - root.left.subtreeWeight + root.left.right.subtreeWeight;
            root.left.subtreeWeight = tmp;
            r = root.left;
            root.left = r.right;
            r.right = root;
        }
        return r;
    }


    private Node split(Node root) {
        Node r = root;
        if (root.level != 0 && root.level == root.right.level && root.level == root.right.right.level) {
            int tmp = root.subtreeWeight;
            root.subtreeWeight = tmp - root.right.subtreeWeight + root.right.left.subtreeWeight;
            root.right.subtreeWeight = tmp;
            r = root.right;
            root.right = r.left;
            r.left = root;
            r.level++;
        }
        return r;
    }

    public Node insert(Node root, String key, int weight) {
        if (root == null) {
            return new Node(key, weight);
        } else if (key.compareTo(root.key) < 0) {
            int leftWeight = root.left.weight;
            root.left = insert(root.left, key, weight);
            root.weight += (root.left.weight - leftWeight);
            root = skew(root);
            root = split(root);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            int rightWeight = root.right.weight;
            root.right = insert(root.right, key, weight);
            root.weight += (root.right.weight - rightWeight);
            root = skew(root);
            root = split(root);
            return root;
        } else {
            root.weight = weight;
            return root;
        }
    }

    public String random(Node root) {
        int w = random.nextInt(root.weight) + 1;
        return random(root, w);
    }

    public String random(Node root, int w) {
        int l = root.left.weight;
        int r = l + root.weight;
        if (w > l && w <= r) {
            return root.key;
        } else if (w < l) {
            return random(root.left, w);
        } else {
            return random(root.right, w);
        }

    }

}
