package dp;

import array.ArrayUtils;

import java.util.Arrays;

/**
 * Created @ 4/21/2014
 * <p>
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * <p>
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a
 * palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are
 * needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.
 * If a string is palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
public class PalindromePartitioning {
    public static int solve(String s) {
        int[][] S = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(S[i], s.length() + 10);
        }
        for (int i = 0; i < s.length(); i++) {
            S[i][i] = 0;
        }

//        ArrayUtils.print(S);
        int length = 2;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - length; j++) {
                int start = j;
                int end = j + length - 1;
                String cut = substring(s, start, end);
//                System.out.println();
//                System.out.println(cut);
                if (Palindrome.isPalindrome(cut)) {
                    S[start][end] = 0;
                } else {
                    for (int k = start; k < end; k++) {
                        String s_i_k = substring(s, start, k);
                        String s_k_j = substring(s, k + 1, end);
//                        System.out.println(s_i_k + "|" + s_k_j);
                        S[start][end] = Math.min(
                                S[start][end],
                                1 + S[start][k] + S[k + 1][end]
                        );
                    }
                }
            }
            length++;
        }
       /* S[s.length()][s.length()] = Math.min(
                S[i][j],
                1 + Math.min(
                        S[i][k],
                        S[k + 1][j]
                )
        );*/
        ArrayUtils.print(S);
        return S[0][s.length() - 1];
    }

    private static String substring(String s, int start, int end) {
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
//        System.out.println(solve("ababbbab"));
        System.out.println(solve("ababbbabbababa"));
        // a|babbbab|b|ababa
        /**
         ababbba b babab a
         */

    }
}
