package tree;


import com.google.common.primitives.Ints;
import util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreTreeFromTraversal {
    public static Node restoreFromInPre(List<Integer> inorder, List<Integer> preorder) {
        inorder = new ArrayList<>(inorder);
        preorder = new ArrayList<>(preorder);
        return restoreFromInPreInternal(inorder, preorder);
    }

  public static Node restoreFromInPreInternal(List<Integer> inorder, List<Integer> preorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        int value = preorder.remove(0);
        Pair<List<Integer>, List<Integer>> children = split(inorder, value);
        final List<Integer> left = children.getLeft();
        final List<Integer> right = children.getRight();
        System.out.print("root: " + value);
        System.out.print(", left: " + left);
        System.out.print(", right: " + right);
        System.out.println();
        return new Node(value,
                restoreFromInPreInternal(left, preorder),
                restoreFromInPreInternal(right, preorder)
                );
    }

  public static Node restoreFromLevelPreInternal(List<Integer> inorder, List<Integer> levelorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        int value = levelorder.remove(0);
        Pair<List<Integer>, List<Integer>> children = split(inorder, value);
        final List<Integer> left = children.getLeft();
        final List<Integer> right = children.getRight();
        System.out.print("root: " + value);
        System.out.print(", left: " + left);
        System.out.print(", right: " + right);
        System.out.println();
        return new Node(value,
                restoreFromLevelPreInternal(left, levelorder),
                restoreFromLevelPreInternal(right, levelorder)
                );
    }

    private static Pair<List<Integer>, List<Integer>> split(List<Integer> inorder, int value) {
        int i = 0;
        for (i = 0; i < inorder.size() && inorder.get(i) != value; i++) {}
        List<Integer> left = inorder.subList(0, i);
        List<Integer> right = inorder.subList(i + 1, inorder.size());
        return new Pair<>(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(8,
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(6,
                                new Node(5),
                                new Node(7))
                ),
                new Node(10,
                        new Node(9),
                        new Node(11))
        );
        //                    8
        //                  /   \
        //                4      10
        //              /  \     / \
        //            2     6  9   11
        //          / \    / \
        //         1   3  5  7
        //
        //
        //
        BST_Utils.printNode(root);

        int[] inorderTraversal = Traversal.inorder(root);
        int[] preorderTraversal = Traversal.preorder(root);
        int[] postorderTraversal = Traversal.postorder(root);
        int[] levelorderTraversal = Traversal.levelorder(root);
        System.out.println("inorder: " + Arrays.toString(inorderTraversal));
        System.out.println("postorder: " + Arrays.toString(preorderTraversal));
        System.out.println("postorder: " + Arrays.toString(postorderTraversal));
        System.out.println("levelorder: " + Arrays.toString(levelorderTraversal));

        Node restoredRoot = restoreFromInPre(Ints.asList(inorderTraversal), Ints.asList(preorderTraversal));
        BST_Utils.printNode(restoredRoot);
    }


}
