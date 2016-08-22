package tree;

/**
 * Created @ 4/29/2014
 *
 * http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
 */
public class AVL {
    private Node root;

    public AVL() {
    }

    public AVL(Node root) {
        this.root = root;
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(root, value);
        }
    }

    private Node add(Node n, int value) {
        if (n == null) {
            return new Node(value);
        } else if (value < n.data) {
            n.left = add(n.left, value);
        } else if (value > n.data) {
            n.right = add(n.right, value);
        }
        n.height = Math.max(height(n.left), height(n.right)) + 1;

        return balance(n, value);
    }

    private Node balance(Node n, int value) {
        int balance = getBalance(n);
        if (balance > 1 && value < n.left.data) {
            return rightRotate(n);
        }

        if (balance < -1 && value > n.right.data) {
            return leftRotate(n);
        }

        if (balance > 1 && value > n.left.data) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        if (balance < -1 && value < n.right.data) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }

    private int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    private int height(Node n) {
        return n != null ? n.height : 0;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return x;
    }


    public void remove(int value) {
        if (root != null) {
            root = remove(root, value);
        }
    }

    private Node remove(Node n, int value) {
        if (n == null) {
            return null;
        } else if (value < n.data) {
            n.left = remove(n.left, value);
        } else if (value > n.data) {
            n.right = remove(n.right, value);
        } else {
            if (n.left == null || n.right == null) {
                n = n.left != null ? n.left : n.right;
            } else {
                Node t = inorderSuccessor(n.right);
                n.data = t.data;
                n.right = remove(n.right, t.data);
            }
        }
        if (n == null) {
            return n;
        }
        n.height = Math.max(height(n.left), height(n.right)) + 1;

        return balance(n, value);
    }

    private Node inorderSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.add(9);
        tree.add(5);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(11);
        tree.add(2);
        tree.add(3);
        tree.add(0);

        BST_Utils.printNode(tree.root);

        tree.remove(10);
        BST_Utils.printNode(tree.root);
    }
}
