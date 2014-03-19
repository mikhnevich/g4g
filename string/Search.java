package string;

/**
 * Created by sm84878 @ 2/12/14 10:39 AM
 */
public class Search {
    public static int search2(String pattern, String text) {
        int j, M = pattern.length();
        int i, N = text.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i =- j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        }
        return -1;
    }

    public static int search1(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++)
        {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            if (j == M) return i; // found
        }
        return -1; // not found
    }
}
