package dp;

import java.util.Arrays;

/**
 * Created @ 6/12/2014
 * TODO http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
 * <p>
 * Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. Elements should be removed either end of the array.
 * <p>
 * Number of removals should be minimum.
 * <p>
 * Examples:
 * <p>
 * arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
 * Output: 4
 * We need to remove 4 elements (4, 5, 100, 200)
 * so that 2*min becomes more than max.
 * <p>
 * <p>
 * arr[] = {4, 7, 5, 6}
 * Output: 0
 * We don't need to remove any element as
 * 4*2 > 7 (Note that min = 4, max = 8)
 * <p>
 * arr[] = {20, 7, 5, 6}
 * Output: 1
 * We need to remove 20 so that 2*min becomes
 * more than max
 * <p>
 * arr[] = {20, 4, 1, 3}
 * Output: 3
 * We need to remove any three elements from ends
 * like 20, 4, 1 or 4, 1, 3 or 20, 3, 1 or 20, 4, 1
 */
public class DoubleMinMoreThanMax {

    public static int[] solve(int[] a) {
        int[][] min = new int[a.length][a.length];
        int[][] max = new int[a.length][a.length];
        min[0][0] = a[0];
        max[0][0] = a[0];

        for (int i = 1; i < a.length; i++) {
            min[0][i] = Math.min(a[i], min[0][i - 1]);
            max[0][i] = Math.max(a[i], max[0][i - 1]);
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] <= min[i - 1][j - 1]) {
                    min[i][j] = min[i - 1][j];
                } else {
                    min[i][j] = a[j];
                }
                if (j > i) {
                    min[i][j] = Math.min(min[i][j], min[i][j - 1]);
                }

                if (a[j] >= max[i - 1][j - 1]) {
                    max[i][j] = max[i - 1][j];
                } else {
                    max[i][j] = a[j];
                }
                if (j > i) {
                    max[i][j] = Math.max(max[i][j], max[i][j - 1]);
                }
            }
        }

        int minRemovals = a.length;
        int start = -1;
        int end = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (min[i][j] * 2 > max[i][j]) {
                    int removedElements = a.length - (j - i + 1);
                    if (removedElements < minRemovals) {
                        minRemovals = removedElements;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        int len = end - start + 1;
        int[] result = new int[len];
        System.arraycopy(a, start, result, 0, len);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{4, 5, 100, 9, 10, 11, 12, 15, 200})));
        System.out.println(Arrays.toString(solve(new int[]{4, 7, 5, 6})));
        System.out.println(Arrays.toString(solve(new int[]{20, 7, 5, 6})));
        System.out.println(Arrays.toString(solve(new int[]{20, 4, 1, 3})));
    }
}
