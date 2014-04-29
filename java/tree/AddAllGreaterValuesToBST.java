package tree;

/**
 * Created on 3/27/2014.
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 Given a Binary Search Tree (BST), modify it so that all greater values in the given BST are added to every node. For example, consider the following BST.

          50
       /      \
     30        70
   /   \      /  \
 20    40    60   80

 The above tree should be modified to following

          260
       /      \
     330        150
   /   \       /  \
 350   300    210   80

 We can do it using a single traversal. The idea is to use following BST property. If we do reverse Inorder traversal of BST, we get all nodes in decreasing order. We do reverse Inorder traversal and keep track of the sum of all nodes visited so far, we add this sum to every node.

 */
public class AddAllGreaterValuesToBST {

    public static void add(Node node) {
        add(node, 0);
    }

    private static int add(Node node, int toAdd) {
        if (node == null) {
            return 0;
        }
        int right = add(node.right, toAdd);
        int oldNodeValue = node.value;
        node.value += right + toAdd;
        int left = add(node.left, oldNodeValue + right + toAdd);
        return oldNodeValue + left + right;
    }

    public static void main(String[] args) {
        Node r = new Node(50,
                new Node(30,
                        new Node(20),
                        new Node(40)
                ),
                new Node(70,
                        new Node(60),
                        new Node(80)
                ));
        BST_Utils.printNode(r);
        add(r);
        BST_Utils.printNode(r);
    }

}
