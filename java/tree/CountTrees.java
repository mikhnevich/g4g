package tree;


public class CountTrees {

    public static int countTrees(int nodeCount) {
        if (nodeCount <= 1) {
            return 1;
        }
        int sum = 0;
        int left, right;
        for (int root = 1; root <= nodeCount; root++) {
            left = countTrees(root - 1);
            right = countTrees(nodeCount - root);
            sum += left*right;
        }
        return sum;
    }
}
