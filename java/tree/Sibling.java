package tree;

/*
Each node has addition pointer - sibling.
Populate it.

1 solution will be to use queue and do level-order traversal, putting e.g. null to indicate end of the level.
Then setting sibling pointer is trivial.

 */
public class Sibling {

    public static void setSibling(Node root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.right != null) {
                root.left.rightSibling = root.right;
            }
        }
        if (root.right != null) {
            if (root.rightSibling != null) {
                if (root.rightSibling.left != null) {
                    root.right.rightSibling = root.rightSibling.left;
                } else if (root.rightSibling.rightSibling != null) {
                    root.right.rightSibling = root.rightSibling.right;
                }
            }
        } else if (root.left != null) {
            if (root.rightSibling != null) {
                if (root.rightSibling.left != null) {
                    root.left.rightSibling = root.rightSibling.left;
                } else if (root.rightSibling.right != null) {
                    root.left.rightSibling = root.rightSibling.right;
                }
            }
        }

        setSibling(root.left);
        setSibling(root.right);
    }

    public static void main(String[] args) {
        Node r1 = new Node(10,
                new Node(5),
                new Node(100,
                        new Node(50,
                                new Node(40), null),
                        new Node(150)));
        BST_Utils.printNode(r1);
//        setSibling(r1);
        BST_Utils.printNode(r1);

        Node r2 = new Node(10,
                new Node(5,
                        new Node(6,
                                new Node(7), null
                        ), null),
                new Node(100,
                        null,
                        new Node(50,
                                null,
                                new Node(40)
                        )
                )
        );
        BST_Utils.printNode(r2);
        setSibling(r2);
        BST_Utils.printNode(r2);
    }
}
