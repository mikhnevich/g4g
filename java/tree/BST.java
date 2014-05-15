package tree;

/**
 * Created by user @ 2/21/14 10:43 AM
 */
public class BST<T extends Comparable<T>> {
    class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }

    }

    public void deleteMin() {
        root = deleteMin(root);
    }


    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }


    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node delete(Node x, T data) {
        if (x == null) {
            return null;
        }
        final int cmp = data.compareTo(x.data);
        if (cmp < 0) {
            x.left = delete(x.left, data);
        } else if (cmp > 0) {
            x.right = delete(x.right, data);
        } else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public void insert(Node parent, T data) {
        Node node = parent;
        while (node != null) {
            if (node.data == data) {
                throw new RuntimeException();
            }
            if (data.compareTo(node.data) < 0) {
                Node tmp = node;
                node = node.left;
                parent = tmp;
            } else {
                Node tmp = node;
                node = node.right;
                parent = tmp;
            }
        }
        if (data.compareTo(parent.data) < 0) {
            parent.left = new Node(data);
        } else {
            parent.right = new Node(data);
        }
    }

    public Node find(T data) {
        Node start = root;
        while (start != null && start.data.compareTo(data) != 0) {
            if (data.compareTo(start.data) < 0) {
                start = start.left;
            } else {
                start = start.right;
            }
        }
        return start;
    }

    public Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public Node max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node successor(Node node) {
        if (node.right != null) {
            return min(node.right);
        } else {
            Node currentRoot = root;
            Node successor = root;
            while (currentRoot != null) {
                if (node.data.compareTo(currentRoot.data) < 0) {
                    successor = currentRoot;
                    currentRoot = currentRoot.left;
                } else if (node.data.compareTo(currentRoot.data) < 0) {
                    successor = currentRoot;
                    currentRoot = currentRoot.right;
                } else {
                    break;
                }
            }
            return successor;
        }
    }



}

