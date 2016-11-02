package misc;

import tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
https://github.com/BlueRaja/Weighted-Item-Randomizer-for-C-Sharp/blob/master/Weighted%20Randomizer/DynamicWeightedRandomizer.cs
http://www.eternallyconfuzzled.com/tuts/datastructures/jsw_tut_andersson.aspx

*/
public class WeightedRandomizer {


    private Random random = new Random();

    public interface PrintableNode {
        PrintableNode getLeft();


        PrintableNode getRight();


        String getText();
    }

    public static class Node implements PrintableNode {
        private static Node Nil = new Node() {
            @Override
            public String toString() {
                return "";
            }
        };

        private int level = 0;
        private String key;
        private Node left = Nil;
        private Node right = Nil;
        private int weight = 0;
        private int subtreeWeight = 0;

        public Node() {
        }

        @Override
        public PrintableNode getLeft() {
            return left;
        }

        @Override
        public PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key + ":" + weight + ":" + level + ":" + subtreeWeight;
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
        if (root == null || root == Node.Nil) {
            return new Node(key, weight);
        } else if (key.compareTo(root.key) < 0) {
            int leftWeight = root.left.subtreeWeight;
            root.left = insert(root.left, key, weight);
            root.subtreeWeight += (root.left.subtreeWeight - leftWeight);
            root = skew(root);
            root = split(root);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            int rightWeight = root.right.subtreeWeight;
            root.right = insert(root.right, key, weight);
            root.subtreeWeight += (root.right.subtreeWeight - rightWeight);
            root = skew(root);
            root = split(root);
            return root;
        } else {
            root.weight = weight;
            return root;
        }
    }

    public String random(Node root) {
        int w = random.nextInt(root.subtreeWeight) + 1;
        System.out.println("Probability: " + w);
        Node t = root;
        String result = null;
        while (true) {
            if (t.left.subtreeWeight > w) {
                t = t.left;
            } else if (w > (t.left.subtreeWeight + t.weight)) {
                w = w - t.left.subtreeWeight - t.weight;
                t = t.right;
            } else {
                result = t.key;
                break;
            }
        }
        return result;
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

    public static class Printer {

        public static void print(PrintableNode root)
        {
            List<List<String>> lines = new ArrayList<List<String>>();

            List<PrintableNode> level = new ArrayList<PrintableNode>();
            List<PrintableNode> next = new ArrayList<PrintableNode>();

            level.add(root);
            int nn = 1;

            int widest = 0;

            while (nn != 0) {
                List<String> line = new ArrayList<String>();

                nn = 0;

                for (PrintableNode n : level) {
                    if (n == null) {
                        line.add(null);
                        next.add(null);
                        next.add(null);
                    } else {
                        String aa = n.getText();
                        line.add(aa);
                        if (aa.length() > widest) widest = aa.length();

                        next.add(n.getLeft());
                        next.add(n.getRight());

                        if (n.getLeft() != null) nn++;
                        if (n.getRight() != null) nn++;
                    }
                }

                if (widest % 2 == 1) widest++;

                lines.add(line);

                List<PrintableNode> tmp = level;
                level = next;
                next = tmp;
                next.clear();
            }

            int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
            for (int i = 0; i < lines.size(); i++) {
                List<String> line = lines.get(i);
                int hpw = (int) Math.floor(perpiece / 2f) - 1;

                if (i > 0) {
                    for (int j = 0; j < line.size(); j++) {

                        // split node
                        char c = ' ';
                        if (j % 2 == 1) {
                            if (line.get(j - 1) != null) {
                                c = (line.get(j) != null) ? '┴' : '┘';
                            } else {
                                if (j < line.size() && line.get(j) != null) c = '└';
                            }
                        }
                        System.out.print(c);

                        // lines and spaces
                        if (line.get(j) == null) {
                            for (int k = 0; k < perpiece - 1; k++) {
                                System.out.print(" ");
                            }
                        } else {

                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? " " : "─");
                            }
                            System.out.print(j % 2 == 0 ? "┌" : "┐");
                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? "─" : " ");
                            }
                        }
                    }
                    System.out.println();
                }

                // print line of numbers
                for (int j = 0; j < line.size(); j++) {

                    String f = line.get(j);
                    if (f == null) f = "";
                    int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                    int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                    // a number
                    for (int k = 0; k < gap1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(f);
                    for (int k = 0; k < gap2; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                perpiece /= 2;
            }
        }
    }

    public static void main(String[] args) {
        WeightedRandomizer w = new WeightedRandomizer();
        Node root = w.insert(null, "M", 5);
        root = w.insert(root, "D", 7);
        root = w.insert(root, "Q", 3);
        System.out.println(w.random(root));
    }
}
