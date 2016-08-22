package tree;

/*

http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/

Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property (For every node, data data must be equal to sum of data values in left and right children).
 You can only increment data values in any node (You cannot change structure of tree and cannot decrement data of any node).


You can only increment data values in any node
(You cannot change structure of tree and cannot decrement data of any node).
 */
public class ConvertToChildrenSumProperty {

    private static int convert(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int left = convert(root.left);
        int right = convert(root.right);
        int sum = left + right;
        if (sum >= root.data) {
            root.data = sum;
        } else {
            if (root.left != null) {
                increase(root.left, root.data - sum);
            } else {
                increase(root.right, root.data - sum);
            }
        }
        return root.data;
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
        node.data += amount;
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
