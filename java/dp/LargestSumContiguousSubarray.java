package dp;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class LargestSumContiguousSubarray {

    public static int[] find(int... a) {
        int maxSoFar = a[0];
        int currentMax = a[0];
        int startSoFar = 0;
        int endSoFar = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxSoFar + a[i]) {
                start = i;
                end = i;
                currentMax = a[i];
            } else {
                currentMax = currentMax + a[i];
                end++;
            }
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
                startSoFar = start;
                endSoFar = end;
            }
        }

        // return sum + the sequence.
        final int length = endSoFar - startSoFar + 1;
        int[] result = new int[length + 1];
        System.arraycopy(a, startSoFar, result, 1, length);
        result[0] = maxSoFar;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(-2, -3, 4, -1, -2, 1, 5, -3)));
    }
}
