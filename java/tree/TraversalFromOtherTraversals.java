package tree;

/**
 * Created @ 3/31/2014 14:53
 *
 * http://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 *
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.

 Example:

 Input:
 Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
 Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

 Output:
 Postorder traversal is {4, 5, 2, 6, 3, 1}
 Trversals in the above example represents following tree

         1
      /     \
     2       3
   /   \      \
  4     5      6


 Time: O(n)

 */
public class TraversalFromOtherTraversals {

    public static void postorder(int[] pre, int[] in) {
        printTree(pre, 0, in, 0, in.length - 1);
    }

    private static int printTree(int[] pre, int preIndex, int[] in, int inStart, int inEnd) {
        if (preIndex >= pre.length) {
            return preIndex;
        }
        if (inStart == inEnd) {
            System.out.println(in[inStart]);
            return preIndex;
        }
        int root = pre[preIndex];

        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root) {
                rootIndex = i;
                break;
            }
        }
        preIndex++;
        preIndex = printTree(pre, preIndex, in, inStart, rootIndex - 1);
        preIndex++;
        preIndex = printTree(pre, preIndex, in, rootIndex + 1, inEnd);
        System.out.println(root);
        return preIndex;
    }

    public static void main(String[] args) {
        int[] in = new int[] {4, 2, 5, 1, 3, 6};
        int[] pre = new int[] {1, 2, 4, 5, 3, 6};
        postorder(pre, in);
    }

}
