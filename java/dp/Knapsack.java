package dp;

import array.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-71-sde-2/
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 */
public class Knapsack {
 /*   public int solve(int[] value, int[] weight, int capacity) {
        int[][] S = new int[capacity][value.length];
        for (int i = 0; i <= capacity; i++) {

        }

        for (int i = 0; i <= capacity; i++) {

        }

    }*/

    public static int solveDP(int[] value, int[] weight, int capacity) {
        int[][] S = new int[capacity + 1][value.length + 1];
        for (int j = 1; j <= value.length; j++) {
            for (int w = 1; w <= capacity; w++) {
                if (weight[j - 1] > w) {
                    S[w][j] = S[w][j - 1];
                } else {
                    S[w][j] = Math.max(
                            S[w][j - 1],
                            S[w - weight[j - 1]][j - 1] + value[j - 1]
                    );
                }
            }
        }
        ArrayUtils.print(S);
        Set<Integer> items = new HashSet<>();
        int w = capacity;
        int n = value.length;
        while (w > 0 && n >= 0) {
            if (S[w][n] != S[w][n - 1]) {
                items.add(value[n - 1]);
                w = w - weight[n - 1];
                n = n - 1;
            } else {
                n = n - 1;
            }
        }
        System.out.println(items);
        return S[capacity][value.length];
    }

    public static int solveRecursive(int n, int[] value, int[] weight, int capacity) {

        if (n == -1 || capacity == 0) {
            return 0;
        }
        if (weight[n] > capacity) {
            return solveRecursive(n - 1, value, weight, capacity);
        } else {
            final int v1 = value[n] + solveRecursive(n - 1, value, weight, capacity - weight[n]);
            final int v2 = solveRecursive(n - 1, value, weight, capacity);
            return Math.max(v1, v2);
        }
    }

    public static void main(String[] args) {
//        final int[] value = {60, 100, 120};
//        final int[] weight = {10, 20, 30};
//        final int capacity = 50;
        final int capacity = 8;
        final int[] value = {15, 10, 9, 5};
        final int[] weight = {1, 5, 3, 4};
        System.out.println(solveRecursive(value.length - 1, value, weight, capacity));
        System.out.println(solveDP(value, weight, capacity));
    }
}
