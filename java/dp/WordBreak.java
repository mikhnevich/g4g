package dp;

import array.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 3/29/2014.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 * http://www.geeksforgeeks.org/amazon-interview-set-73-for-sde-1/
 *
 * Given a stream of characters, convert it to a sentence with valid words.
 * Assume you have a function IsWord which returns true if the passed string is a word
 */
public class WordBreak {
    public static boolean solve(String s, Set<String> dictionary) {
        final int n = s.length();
        boolean S[][] = new boolean[n][n];
        int parent[] = new int[n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String word = s.substring(i, i + len);
//                System.out.println(word);
                if (dictionary.contains(word)) {
                    S[i][i + len - 1] = true;
                    parent[i + len - 1] = i + len - 1;
                } else {
                    for (int x = i + 1; x < i + len; x++) {
                        if (S[i][x] && S[x + 1][i + len - 1]) {
                            S[i][i + len - 1] = true;
                            parent[i + len - 1] = x;
                            break;
                        }
                    }
                }
            }
        }
        ArrayUtils.print(S);
        System.out.println(Arrays.toString(parent));
        return S[0][n-1];
    }

    public static boolean solve2(String s, Set<String> dictionary) {
        final int n = s.length();
        boolean S[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            final String prefix = s.substring(0, i);
            if (!S[i] && dictionary.contains(prefix)) {
                S[i] = true;
            }

            if (S[i]) {
                if (i == n) {
                    return true;
                }

                for (int j = i + 1; j <= n; j++) {
                    final String suffix = s.substring(i, j);
//                    System.out.println(prefix + ":" + suffix);
                    if (!S[j] && dictionary.contains(suffix)) {
                        S[j] = true;
                    }

                    if (j == n && S[j]) {
                        return true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(S));
        return S[n];
    }

    public static boolean solveAll(String s, Set<String> dictionary) {
        final int n = s.length();
        boolean S[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
//            Arrays.fill(S, false);
            final String prefix = s.substring(0, i);
            if (!S[i] && dictionary.contains(prefix)) {
                S[i] = true;
            }

            if (S[i]) {
                if (i == n) {
                    ArrayUtils.print(S);
                    return true;
                }

                for (int j = i + 1; j <= n; j++) {
                    final String suffix = s.substring(i, j);
                    if (!S[j] && dictionary.contains(suffix)) {
                        S[j] = true;
                    }

                    if (j == n && S[j]) {
                        ArrayUtils.print(S);
                        return true;
                    }
                }
            }
        }
        ArrayUtils.print(S);
        return S[n];
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
//                "convert", "it", "to", "a", "sentence", "with", "valid", "words"
                "a", "ajax"
        ));
        System.out.println(solveAll("aajax", dictionary));
//        System.out.println(solve("convertittoasentencewithvalidwords", dictionary));
    }
}
