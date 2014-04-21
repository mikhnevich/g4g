package dp;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *
 * http://www.geeksforgeeks.org/amazon-interview-set-70-on-campus/
 * <p>
 * Given a string find the length of longest substring which has none of its character repeated?
 * for eg:
 * i/p string:
 * abcabcbb
 * length of longest substring with no repeating charcters: 3 (abc)
 */
public class LongestNonRepeatingSequence {
    private static String solve(String input) {
        int[] occurence = new int[26]; // english alphabet
        int start = 0;
        int end = 0;
        occurence[Character.toLowerCase(input.charAt(0)) - 97] = 1;
        int maxStart, maxEnd;
        maxStart = 0;
        maxEnd = 0;

        for (int i = 1; i < input.length(); i++) {
            int idx = Character.toLowerCase(input.charAt(i)) - 97;
            if (occurence[idx] != 0) {
                while (input.charAt(start) != input.charAt(i)) {
                    occurence[Character.toLowerCase(input.charAt(start)) - 97]--;
                    start++;
                }
                occurence[Character.toLowerCase(input.charAt(start)) - 97]--;
                start++;
            }
            occurence[idx]++;
            end = i;
            if (end - start > maxEnd - maxStart) {
                maxStart = start;
                maxEnd = end;
            }
        }
        return input.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(solve("GEEKSFORGEE"));
        System.out.println(solve("ABDEFGABEF"));
        System.out.println(solve("BBBB"));
        System.out.println(solve("abcabcbb"));
    }

}
