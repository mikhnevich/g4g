package tree;


public class Traversal {

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        print(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    private static void print(int value) {
        System.out.print(value);
        System.out.print(" ");
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        print(root.value);
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        print(root.value);
    }

    public static void main(String[] args) {
        Node r3 = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5)),
                new Node(3,
                        new Node(6,
                                null,
                                new Node(8)),
                        new Node(7)
                )
        );
        preorder(r3);
        System.out.println();
        inorder(r3);
        System.out.println();
        postorder(r3);
        System.out.println();

    }
}
