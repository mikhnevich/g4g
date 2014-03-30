package dp;

import array.ArrayUtils;

import java.util.Arrays;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-73-for-sde-1/
 *
 * 1st Round – Online Coding
 Contiguous elements in an array whose sum is k.

 */
public class ContiguousSum {
    public static int[] elements(int[] a, int sum) {
        int len = a.length;
        int[][] S = new int[len][len];
        for (int i = 0; i < len; i++) {
            S[i][i] = a[i];
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                S[i][j] = S[i][j - 1] + a[j];
                if (S[i][j] == sum) {
                    start = i;
                    end = j;
                }
            }
        }
        int[] result;
        if (start != -1) {
            int resultLen = end - start + 1;
            result = new int[resultLen];
            System.arraycopy(a, start, result, 0, resultLen);
            ArrayUtils.print(S);
        } else {
            result = new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(elements(new int[] {4,8,7,6,5,1,2,4,4,3,1,2,1}, 10)));
    }
}
