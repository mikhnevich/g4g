package string;

/**
 * Created by sm84878 @ 3/31/2014 17:42
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 *
 * Given a string, find the longest substring which is palindrome. For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 */
public class LongestPalindrome {

    //todo 2 solutions: DP +

    public static int solve(String s) {
        return solve(s, 0, s.length() - 1);
    }

    private static int solve(String s, int start, int end) {
        if (end - start < 0) {
            return 0;
        } else if (end - start == 0) {
            return 1;
        } else if (end - start == 1) {
            return 1;
        } else if (s.charAt(start) == s.charAt(end)) {
            return solve(s, start + 1, end - 1) + 2;
        } else {
            return Math.max(
                    solve(s, start + 1, end),
                    solve(s, start, end - 1)
            );
        }
    }

    //todo
    /*
    A simpler approach, O(N2) time and O(1) space:
    In fact, we could solve it in O(N2) time without any extra space.
    We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2N-1 such centers.
    You might be asking why there are 2N-1 but not N centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as “abba”) and its center are between the two ‘b’s.
    Since expanding a palindrome around its center could take O(N) time, the overall complexity is O(N2).

    */

    public static void main(String[] args) {
        System.out.println(solve("BBABCBCAB"));
    }
}
