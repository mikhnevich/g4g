package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created @ 4/22/2014
 *
 http://finding-palindromes.blogspot.com/2012/05/finding-palindromes-efficiently.html
 */
public class Palindrome {

    public static boolean isPalindrome(String st) {
        return st.equals(new StringBuilder(st).reverse().toString());
    }

    public static List<String> inits(String s) {
        List<String> result = new ArrayList<>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) {
            result.add(s.substring(0, i));
        }
        return result;
    }

    public static List<String> tails(String s) {
        List<String> result = new ArrayList<>(s.length() + 1);
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, s.length()));
        }
        result.add("");
        return result;
    }

    public static List<String> substrings(String s) {
        List<String> sInits = inits(s);
        List<String> result = new ArrayList<>();
        for (String st : sInits) {
            result.addAll(tails(st));
        }
        return result;
    }

    public static List<String> palindromes(String s) {
        List<String> strings = substrings(s);
        List<String> result = new ArrayList<>();
        for (String st : strings) {
            if (isPalindrome(st)) {
                result.add(st);
            }
        }
        return result;
    }

    // this algorithm is naive is that lengthPalindromeAround calculates the maximal palindrome
    // around a center independently of the palindromes calculated previously.
    public static int[] maximalPalindromes(String s) {
        int centerCount = s.length() * 2 + 1;
        int[] result = new int[centerCount];
        for (int i = 0; i < centerCount; i++) {
            result[i] = lengthPalindromeAround(s, i);
        }
        return result;
    }

    private static int lengthPalindromeAround(String s, int center) {
        int c = center / 2;
        if (center % 2 == 0) {
            return lengthPalindrome(s, c-1, c);
        } else {
            return 1 + lengthPalindrome(s, c-1, c+1);
        }
    }

    private static int lengthPalindrome(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            len += s.charAt(left) == s.charAt(right) ? 2 : 0;
            left--;
            right++;
        }
        return len;
    }


    //  I now change this by calculating the maximal palindromes from left to right around the centers
    // of a string. In this calculation I either extend a palindrome around a center, or I move the
    // center around which I determine the maximal palindrome rightwards because I have found a maximal
    // palindrome around a center.
    public static int[] maximalPalindromes2(String s) {
        int centerCount = s.length() * 2 + 1;
        int[] result = new int[centerCount];
        for (int i = 0; i < centerCount; i++) {
            result[i] = lengthPalindromeAround(s, i);
        }
        return result;
    }

    public static void extendPalindrome(char[] st, int afterLongest, int longestLength, int[] maxLengthsReversed) {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximalPalindromes("abb")));
    }
}
