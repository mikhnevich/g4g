package dp;

import array.ArrayUtils;

import java.util.Arrays;

/**
 * Created on 3/28/2014.
 * <p>
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * <p>
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 * <p>
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.
 * <p>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {
    public static int lcs(String st1, String st2) {
        int[][] S = new int[st1.length() + 1][st2.length() + 1];
        for (int[] s : S) {
            Arrays.fill(s, -1);
        }
        return lcs(st1, st2, S);
    }

    private static int lcs(String st1, String st2, int[][] S) {
        int st1L = st1.length();
        int st2L = st2.length();
        if (st1L == 0 || st2L == 0) {
            return 0;
        }
        if (S[st1L][st2L] != -1) {
            return S[st1L][st2L];
        }
        int result;
        if (st1.charAt(st1L - 1) == st2.charAt(st2L - 1)) {
            result = 1 + lcs(st1.substring(0, st1L - 1), st2.substring(0, st2L - 1));
        } else {
            result = Math.max(lcs(st1, st2.substring(0, st2L - 1)), lcs(st1.substring(0, st1L - 1), st2));
        }
        S[st1L][st2L] = result;
        return result;
    }

    public static int lcsIterative(String st1, String st2) {
        int st1L = st1.length();
        int st2L = st2.length();
        int[][] S = new int[st1L + 1][st2L + 1];

        int max = 0;
        for (int i = 0; i <= st1L; i++) {
            for (int j = 0; j <= st2L; j++) {
                if (i == 0 || j == 0) {
                    S[i][j] = 0;
                } else if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    S[i][j] = 1 + S[i - 1][j - 1];
                } else {
                    S[i][j] = Math.max(S[i][j - 1], S[i - 1][j]);
                }
                if (max < S[i][j]) {
                    max = S[i][j];
                }
            }
        }
        ArrayUtils.print(S);
        return max;
    }

    public static void main(String[] args) {
        String st1 = "ABCDGH";
        String st2 = "AEDFHR";
        System.out.println(lcs(st1, st2));
        System.out.println(lcsIterative(st1, st2));
    }
}