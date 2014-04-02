package dp;

import array.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 *
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

 Example:

 Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 Output: 3 (1-> 3 -> 8 ->9)
 First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

 */
public class JumpsToEndOfArray {

    // todo is there better than O(n^2)? looks like it exists...
    public int minJumps(int[] a) {
        int len = a.length;
        if (len == 0 || a[0] == 0) {
            return -1;
        }
        Arrays.fill(a, Integer.MAX_VALUE);

        int[] S = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] + j >= i && S[j] != Integer.MAX_VALUE) {
                    S[i] = Math.min(S[i], S[j] + 1);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(S));
        return S[len - 1];
    }

    public static void main(String[] args) {

    }

}
