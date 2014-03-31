package array;

import java.util.Arrays;

/**
 * Created @ 3/31/2014
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 *
 * Space: O(n)
 * Time: n*log(n)
 */
public class LIS {
    public static int lis(int[] a) {
        int len = a.length;
        if (len == 0) {
            return 0;
        }
        int[] ends = new int[len];
        Arrays.fill(ends, -1);
        int max = 0;
        ends[0] = a[0];

        for (int i = 1; i < len; i++) {
            int largest = findSmallestIndexWithGreaterValue(ends, max, a[i]);
            // smaller than all - start new list (replace one with length == 1)
            if (largest == -1) {
                largest = max + 1;
            }
            ends[largest] = a[i];
            max = Math.max(largest, max);
        }
        System.out.println(Arrays.toString(ends));
        return max + 1;
    }

    private static int findSmallestIndexWithGreaterValue(int[] a, int maxIndex, int value) {
        int lo = 0; int hi = maxIndex;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = a[mid];
            // predicate is value < a[mid]
            if (value <= midValue) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (value > a[lo]) {
            return -1;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestIndexWithGreaterValue(new int[]{0, 8}, 1, 4));
//        System.out.println(findSmallestIndexWithGreaterValue(new int[]{0, 8}, 1, 0));
        System.out.println(lis(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
