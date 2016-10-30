package tree;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/path-sum-iii/
http://massivealgorithms.blogspot.com/2016/10/leetcode-437-path-sum-iii.html

You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
Example:


root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11



for each parent node in the tree, we have 2 choices:
1. include it in the path to reach sum.
2. not include it in the path to reach sum.

for each child node in the tree, we have 2 choices:
1. take what your parent left you.
2. start from yourself to form the path.

one little thing to be careful:
every node in the tree can only try to be the start point once.

for example, When we try to start with node 1, node 3, as a child, could choose to start by itself.
             Later when we try to start with 2, node 3, still as a child,
             could choose to start by itself again, but we don't want to add the count to result again.
     1
      \
       2
        \
         3

*/
public class PathSumCount {

    public static int pathsCount(Node root, int k) {
        return pathsCountHelper(root, k, 0, new HashSet<>());
    }

    public static int pathsCountHelper(Node node, int k, int parentSum, Set<Node> visited) {
        if (node == null) return 0;
        System.out.println("Node: " + node.data + ", parentSum: " + parentSum + ", visited: " + visited);
        int newParentSum = parentSum + node.data;
        int nodeWithParentSum = newParentSum == k ? 1 : 0;
        int leftSum = pathsCountHelper(node.left, k, newParentSum, visited);
        int rightSum = pathsCountHelper(node.right, k, newParentSum, visited);
        int leftSumNew = 0;
        int rightSumNew = 0;
        if (!visited.contains(node)) {
            leftSumNew = pathsCountHelper(node.left, k, 0, visited);
            rightSumNew = pathsCountHelper(node.right, k, 0, visited);
            visited.add(node);
        }
        return nodeWithParentSum + leftSum + rightSum + leftSumNew + rightSumNew;
    }

    // https://discuss.leetcode.com/topic/64415/easy-to-understand-java-solution-with-comment
    public static int pathSum(Node root, int sum) {
        Set visited = new HashSet<Node>();  // to store the nodes that have already tried to start path by themselves.
        return pathSumHelper(root, sum, false, sum, visited);
    }

    public static int pathSumHelper(Node root, int sum, boolean hasParent, int target, Set<Node> visited) {
        if(root == null) return 0;
        //the hasParent flag is used to handle the case when parent path sum is 0.
        //in this case we still want to explore the current node.
        if(sum == target && visited.contains(root) && !hasParent) return 0;
        if(sum == target && !hasParent) visited.add(root);
        int count = (root.data == sum)?1:0;
        count += pathSumHelper(root.left, sum - root.data, true, target, visited);
        count += pathSumHelper(root.right, sum - root.data, true, target, visited);
        count += pathSumHelper(root.left, target , false, target, visited);
        count += pathSumHelper(root.right, target, false, target, visited);
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(10,
                new Node(5,
                        new Node(3,
                                new Node(3),
                                new Node(-2)),
                        new Node(2,
                                null,
                                new Node(1))),
                new Node(-3,
                        null,
                        new Node(11))
        );

//        System.out.println(pathsCount(root, 8));

        root = new Node(1,
                null,
                new Node(2,
                        null,
                        new Node(3))
        );
        System.out.println(pathsCount(root, 3));
    }

}
