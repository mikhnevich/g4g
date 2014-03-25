package tree;

/*
You can only increment data values in any node
(You cannot change structure of tree and cannot decrement value of any node).
 */
public class ConvertToChildrenSumProperty {

    private static int convert(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.value;
        }
        int left = convert(root.left);
        int right = convert(root.right);
        int sum = left + right;
        if (sum >= root.value) {
            root.value = sum;
        } else {
            if (root.left != null) {
                increase(root.left, root.value - sum);
            } else {
                increase(root.right, root.value - sum);
            }
        }
        return root.value;
    }

    private static void increase(Node node, int amount) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            increase(node.left, amount);
        } else {
            increase(node.right, amount);
        }
        node.value += amount;
    }


    public static void main(String[] args) {
        Node r3 = new Node(10,
                new Node(8,
                        new Node(3),
                        new Node(5)),
                new Node(2,
                        new Node(2),
                        new Node(1)
                )
        );
        BST_Utils.printNode(r3);

        convert(r3);
        BST_Utils.printNode(r3);
    }
}
