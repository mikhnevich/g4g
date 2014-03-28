package array;

public class ArrayUtils {
    public static void print(int[][] a) {
        final int rows = a.length;
        final int cols = a[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
