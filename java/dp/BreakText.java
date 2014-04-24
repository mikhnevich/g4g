package dp;

import array.ArrayUtils;

import java.util.Arrays;

/**
 * Created on 4/22/2014.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 *
 */
public class BreakText {
    public static int solve(int lineLength, String... words) {

        int n = words.length;
        int[][] S = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int wordsLength = calculateLength(words, i, j);
                if (wordsLength > lineLength) {
                    S[i][j] = Integer.MAX_VALUE / 3;
                } else {
                    S[i][j] = (int) Math.pow(lineLength - wordsLength, 3);
                }
            }
        }
        ArrayUtils.print(S);

        int[] parent = new int[n];
        int[] DP = new int[n + 1];
        DP[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cost = Integer.MAX_VALUE / 3;
            for (int j = i; j < n; j++) {
                if (cost > DP[j + 1] + S[i][j]) {
                    cost = DP[j + 1] + S[i][j];
                    parent[i] = j + 1;
                }
            }
            DP[i] = cost;
        }
        System.out.println(Arrays.toString(DP));
        System.out.println(Arrays.toString(parent));
        printSolution(parent, lineLength);
        return DP[0];
    }

    private static int printSolution(int p[], int n) {
        int k;
        if (p[n] == 1)
            k = 1;
        else
            k = printSolution(p, p[n] - 1) + 1;
        System.out.format("Line number %d: From word no. %d to %d \n", k, p[n], n);
        return k;
    }

    public static void main(String[] args) {
        System.out.println(solve(5, "abc", "b", "de", "k", "sdf", "df", "sdf"));
        // "abc", "b", "de", 1 = 9
    }

    private static int calculateLength(String[] words, int i, int j) {
        int result = 0;
        for (int k = i; k <= j && k < words.length; k++) {
            result += words[k].length();
        }
        result += i < words.length ? (j - i) : 0; // spaces
        return result;
    }
}
