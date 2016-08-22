package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created @ 4/23/2014
 * if we encode A-1 , B-2 , C-3 , I send a word CAMP encoded as 311316.
 * It can be decoded as
 * 3 1 1 3 1 6 (CAACAF)
 * 3 1 1 3 16  (CAACP),
 * 3 1 13 1 6  (CAMAF)
 * 3 1 13 16   (CAMP)
 * 3 11 3 1 6  (CKCAF),
 * 3 11 3 16   (CKCP),
 *
 given a input encoded string find the no. ways it can be decoded. (ACODE prob. in Spoj)

 ->Could n’t come up with DP solution at first so gave a solution with recursion tree.
 He asked me to optimise to avoid unnecessary computations.. Finally Solved it using DP.

 */
public class Encoding {

    public static int solveRecursive(String s, char[] mapping) {
        return 0;
//        return solveRecursive(s, 0, mapping, new ArrayList<>());
    }

    private static int solveRecursive(String s, int start, char[] mapping, List<Integer> decoded) {
        if (start == s.length()) {
            System.out.println(decoded);
            return 1;
        }
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            int value = Integer.valueOf(s.substring(start, i + 1));
            if (value < mapping.length) {
                decoded.add(value);
                count += solveRecursive(s, i + 1, mapping, decoded);
                decoded.remove(decoded.size() - 1);
            } else {
                return count;
            }
        }
        return count;
    }

    public static int solve(String s, char[] mapping) {
        int[] ways = new int[] {0, 1};

        for (int i = 1; i < s.length(); i++) {
            int value2 = Integer.valueOf(s.substring(i - 1, i + 1));
            int w;
            if (value2 > mapping.length) {
                w = ways[1];
            } else {
                w = ways[0] + ways[1];
            }
            ways[0] = ways[1];
            ways[1] = w;
        }
        return ways[1];
    }

    public static String encode(String s, char[] mapping) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result.append(c - 96);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        char[] mapping = " abcdefghijklmnoprstuvwxyz".toCharArray();
        String s = "campariaaaaaaaa";
        String encoded = encode(s, mapping); // 311316
        System.out.println(encoded);
        System.out.println(solveRecursive(encoded, mapping));
        System.out.println(solve(encoded, mapping));
    }
}
