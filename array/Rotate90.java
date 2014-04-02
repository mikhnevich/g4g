package array;

/**
 * Created on 4/1/2014.
 */
public class Rotate90 {
    public static void rotate90(int[][] a) {
        int len = a.length;
        if (len != a[0].length) {
            throw new RuntimeException();
        }

        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < len/2 + 1; j++) {
                shift(i, j, i, n - j - 1, )
            }
        }
    }
}
