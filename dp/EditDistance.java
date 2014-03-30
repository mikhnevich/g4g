package dp;

import array.ArrayUtils;

/**
 * Created on 3/28/2014.
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *
 * Problem: Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost. Find minimum number of edits (operations) required to convert one string into another.
 *
 */
public class EditDistance {
    public static int editDistance(String s1, String s2)  {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] S = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            S[0][i] = i;
        }
        for (int i = 0; i <= len1; i++) {
            S[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                S[i][j] = min(
                        S[i][j - 1] + 1,
                        S[i-1][j] + 1,
                        S[i-1][j-1] + d(s1.charAt(i - 1), s2.charAt(j - 1))
                );
            }
        }
        ArrayUtils.print(S);
        return S[s1.length()][s2.length()];
    }

    private static int d(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    private static int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }

    public static void main(String[] args) {
        System.out.println(editDistance("spake", "park"));
    }
}
