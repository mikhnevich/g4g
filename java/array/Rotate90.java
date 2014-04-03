package array;

/**
 * Created on 4/1/2014.
 */
public class Rotate90 {
    public static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }
    }

    public static void rotate90(int[][] a) {
        int n = a.length;
        if (n != a[0].length) {
            throw new RuntimeException();
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                shift(a,
                        new Point(i, j),
                        new Point(j, n - i - 1),
                        new Point(n - i - 1, n - j - 1),
                        new Point(n - j - 1, i)
                );
//                ArrayUtils.print(a);
//                System.out.println();
            }
        }
    }

    private static void shift(int[][] a, Point p1, Point p2, Point p3, Point p4) {
        System.out.println("Shifting " + p1 + " -> " + p2 + " -> " + p3 + " -> " + p4);
        int tmp = a[p1.x][p1.y];
        a[p1.x][p1.y] = a[p4.x][p4.y];
//        ArrayUtils.print(a);
//        System.out.println();

        a[p4.x][p4.y] = a[p3.x][p3.y];
//        ArrayUtils.print(a);
//        System.out.println();

        a[p3.x][p3.y] = a[p2.x][p2.y];
//        ArrayUtils.print(a);
//        System.out.println();

        a[p2.x][p2.y] = tmp;
//        ArrayUtils.print(a);
//        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2},
                {3, 4}
        };
/*
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
*/
/*
        int[][] a = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
*/
        ArrayUtils.print(a);
        System.out.println();
        rotate90(a);
        ArrayUtils.print(a);
    }
}
