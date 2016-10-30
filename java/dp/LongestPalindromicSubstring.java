package dp;

import array.ArrayUtils;

/*
http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

The time complexity can be reduced by storing results of subproblems. The idea is similar to this post.
We maintain a boolean table[node][node] that is filled in bottom up manner. The value of table[i][j] is true,
if the substring is palindrome, otherwise false. To calculate table[i][j], we first check the value of
table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
Otherwise, the value of table[i][j] is made false.
O(node^2) time and space.

O(node^2) time and O(1) space:
The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.
Step to generate odd length palindrome:
Fix a centre and expand in both directions for longer palindromes.
Step to generate even length palindrome
Fix two centre ( low and high ) and expand in both directions for longer palindromes

better algo: http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/


*/
public class LongestPalindromicSubstring {
    public static String lps(String s) {
        int n = s.length();
        boolean[][] c = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            c[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                c[i][i + 1] = true;
            }
        }
        int start = 0;
        int end = 0;
        int max = 1;
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && c[i + 1][j - 1]) {
                    c[i][j] = true;
                    if (k > max) {
                        max = k;
                        start = i;
                        end = j;
                    }
                }

            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
//        System.out.println(lps("civic"));
        System.out.println(lps("character"));
    }
}
