package tree;

// http://www.eternallyconfuzzled.com/tuts/datastructures/jsw_tut_andersson.aspx
public class AATree {
    private static Node Nil = new Node();

    public static class Node {
        int value;
        int level = 0;
        Node right;
        Node left;

        private Node() {
            this.level = 0;
            this.left = Nil;
            this.right = Nil;
        }

        public Node(int value, int level) {
            this();
            this.level = level;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + value + ", " + level + ')';
        }
    }

    /*

         d,2               b,2
        /   \             /   \
     b,2     e,1  -->  a,1     d,2
    /   \                     /   \
 a,1     c,1               c,1     e,1

     */
    public static Node skew(Node root) {
        Node r = root;
        if (r.level != 0) {
            if (r.level == r.left.level) {
                Node tmp = root;
                r = root.right;
                tmp.left = r.right;
                r.right = tmp;
            }
            r.right = skew(r.right);
        }
        return r;
    }

    /*

     b,2                     d,3
    /   \                   /   \
 a,1     d,2     -->     b,2     e,2
        /   \           /   \
     c,1     e,2     a,1     c,1

     */
    public static Node split(Node root) {
        Node r = root;
        if (root.level != 0) {
            if (root.level == root.right.level && root.level == root.right.right.level) {
                Node tmp = root;
                r = root.right;
                r.level = r.level + 1;
                tmp.right = r.left;
                r.left = tmp;
            }
        }
        return r;
    }

    public static Node insert(Node root, int value) {
        Node r = root;
        if (root == Nil) {
            r = new Node(value, 1);
        } else {
            if (root.value > value) {
                r.left = insert(root.left, value);
            } else {
                r.right = insert(root.right, value);
            }
            r = skew(r);
            r = split(r);
        }
        return r;
    }

    public static Node delete(Node root, int value) {
        Node r = root;
        if (r != Nil) {
            if (value < r.value) {
                r.left = delete(r.left, value);
            } else if (value > r.value) {
                r.right = delete(r.right, value);
            } else {
                if (r.left != Nil && r.right != Nil) {
                    Node heir = r.left;
                    while (heir.right != Nil) {
                        heir = heir.right;
                    }
                    root.value = heir.value;
                    root.left = delete(root.left, heir.value);
                } else if (r.left == Nil) {
                    r = r.right;
                } else {
                    r = r.left;
                }
            }
        }
        if (r.left.level < r.level - 1 || root.right.level < r.level - 1) {
            r.level--;
            if (r.right.level > r.level) {
                r.right.level = r.level;
            }
            r = skew(r);
            r = split(r);
        }
        return r;
    }

    public static void main(String[] args) {
        Node r = Nil;
        for (int i = 0; i <= 6; i++) {
            r = insert(r, i);
            System.out.println(r);
        }
    }
}
