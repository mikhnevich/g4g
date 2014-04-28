package array;

public class ArrayUtils {
    public static void print(int[][] a) {
        final int rows = a.length;
        final int cols = a[0].length;
        int max = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(String.valueOf(a[i][j]).length(), max);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int len = String.valueOf(a[i][j]).length();
                System.out.print(a[i][j]);
                for (int k = 0; k <= max - len; k++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void print(boolean[][] a) {
        final int rows = a.length;
        final int cols = a[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] ? 1 : 0);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void print(boolean[] a) {
        final int rows = a.length;
        for (int i = 0; i < rows; i++) {
            System.out.print(a[i] ? 1 : 0);
            System.out.print(' ');
        }
    }

    public static void swap(int[] a, int i, int j) {
        if (i >= 0 && j >= 0 && i < a.length && j < a.length) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
