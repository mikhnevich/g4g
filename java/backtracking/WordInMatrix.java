package backtracking;

/**
 * Created @ 4/23/2014
 
  Given a matrix of characters and a string, find whether the string can be obtained from the matrix. 
 From each character in the matrix, we can move up/down/right/left. for example, 
 if the matrix[3][4] is

 o f a s

 l l q w

 z o w k

 and the string is "follow", then the function should return true.

 */
public class WordInMatrix {
    public static boolean solve(String word, char[][] a) {
        if (a == null) {
            return false;
        }
        int m = a.length;
        if (m == 0) {
            return false;
        }
        int n = a[0].length;
        if (m * n < word.length()) {
            return false;
        }

        boolean found = false;
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (a[i][j] == word.charAt(0)) {
                    found = findWord(i, j, word, a);
                }
            }
        }
        return found;
    }

    private static boolean findWord(int i, int j, String word, char[][] a) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        return findWord(a, word, 0, i, j, visited);
    }

    private static boolean findWord(char[][] a, String word, int position, int i, int j, boolean[][] visited) {
        if (position == word.length()) {
            return true;
        }
        if (i >= a.length || i < 0 || j < 0 || j >= a[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        final char c = word.charAt(position);
        if (c != a[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result;
        return
                findWord(a, word, position + 1, i - 1, j, visited)
                || findWord(a, word, position + 1, i, j + 1, visited)
                || findWord(a, word, position + 1, i + 1, j, visited)
                || findWord(a, word, position + 1, i, j - 1, visited);
    }


    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'o', 'f', 'a', 's', },
                {'l', 'l', 'q', 'w', },
                {'z', 'o', 'w', 'k', }
        };
        String st = "follow";

        System.out.println(solve(st, a));
    }
}
