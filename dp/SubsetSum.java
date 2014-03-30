package dp;

import array.ArrayUtils;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * <p>
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * <p>
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {


    public static boolean hasSubset(int[] a, int M) {
        return hasSubset(a, a.length - 1, M);
    }

    private static boolean hasSubset(int[] a, int nUpTo, int M) {
        if (M == 0) {
            return true;
        }
        if (M < 0) {
            return false;
        }
        if (nUpTo == 0) {
            return false;
        }
        return hasSubset(a, nUpTo - 1, M - a[nUpTo])
                || hasSubset(a, nUpTo - 1, M);
    }

    public static boolean hasSubsetIterative(int[] a, int sum) {
        return hasSubsetIterative(a, a.length, sum);
    }

    private static boolean hasSubsetIterative(int[] a, int n, int sum) {
        boolean[][] S = new boolean[sum+1][n+1];
        for (int j = 0; j <= n; j++) {
            S[0][j] = true;
        }
        for (int i = 0; i <= sum; i++) {
            S[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                S[i][j] = S[i][j - 1];
                if (i >= a[j - 1]) {
                   S[i][j] |= S[i - a[j - 1]][j - 1];
                }
            }
        }
//        ArrayUtils.print(S);
        return S[sum][n];
    }

    public static void main(String[] args) {
        int[] set = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(hasSubset(set, 13));
        System.out.println(hasSubsetIterative(set, 13));
        System.out.println(hasSubset(set, 11));
        System.out.println(hasSubsetIterative(set, 11));
    }
}

