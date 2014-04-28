package array;

/**
 * Created @ 4/28/2014
 * http://leetcode.com/2010/10/searching-2d-sorted-matrix-part-ii.html
 * <p>
 * Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array). This table is sorted along the rows and columns — that is,
 * <p>
 * Table[i][j] ≤ Table[i][j + 1],
 * Table[i][j] ≤ Table[i + 1][j]
 * (sorted rowwise and columnwise)
 */
public class FindInSortedMatrix {

    public static boolean find(int[][] a, int value) {
        int m = a.length;
        int n = a[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0 && a[i][j] != value) {
            if (value < a[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return (i < m && j >= 0 && a[i][j] == value);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(find(a, 10));
        System.out.println(find(a, 20));
    }
}
