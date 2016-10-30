package dp;

import array.ArrayUtils;

/*

In fact the problem can be reduced to using LCS on the "string" and "string.reverse".


http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

1) Optimal Substructure:
Let X[0..node-1] be the input sequence of length node and L(0, node-1) be the length of the longest palindromic subsequence of X[0..node-1].

If last and first characters of X are same, then L(0, node-1) = L(1, node-2) + 2.
Else L(0, node-1) = MAX (L(1, node-1), L(0, node-2)).

Following is a general recursive solution with all cases handled.

*/
public class LongestPalindromicSubsequence {

    public static String lpsRecursive(String s) {
        String[] a = lpsRecursive(s.toCharArray(), 0, s.length() - 1);
        return a[0] + new StringBuffer(a[1]).reverse().toString();
    }

    public static String[] lpsRecursive(char[] c, int i, int j) {
        if (i > j) {
            return new String[]{"", ""};
        } else if (i == j) {
            return new String[]{String.valueOf(c[i]), ""};
        } else if (c[i] == c[j]) {
            String[] s = lpsRecursive(c, i + 1, j - 1);
            return new String[]{String.valueOf(c[i]) + s[0], String.valueOf(c[i]) + s[1]};
        } else {
            String[] s1 = lpsRecursive(c, i + 1, j);
            String[] s2 = lpsRecursive(c, i, j - 1);
            return (s1[0].length() + s1[1].length()) > (s2[0].length() + s2[1].length()) ? s1 : s2;
        }
    }

    public static int lps(String s) {
        int n = s.length();
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            c[i][i] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && k == 2) {
                    c[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    c[i][j] = c[i+1][j-1] + 2;
                } else {
                    c[i][j] = Integer.max(c[i+1][j], c[i][j-1]);
                }
            }
        }
        int i = 0;
        int j = n - 1;
        while (i < n && j >=0) {

        }
        ArrayUtils.print(c);
        return c[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(lpsRecursive("civic"));
        System.out.println(lpsRecursive("character"));
        System.out.println(lps("civic"));
        System.out.println(lps("character"));
        System.out.println(lps("erttre"));
    }
}
