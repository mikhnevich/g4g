package array;

import java.util.Arrays;

import static array.ArrayUtils.swap;

/**
 * Created on 4/26/2014.
 *
 * http://www.geeksforgeeks.org/amazon-interview-set-79-sde-1/
 * Given an array that has positive numbers and negative numbers and zero in it. You need to separate the negative numbers and positive numbers in such a way that negative numbers lies to left of zero and positive numbers to the right and the original order of elements should be maintained
 *
 */
public class SeparateNumbers {
    public static void solve(int... a) {
        int negative = 0;
        int positive = 0;
        int zero = 0;
        int left = 0;
        int right = a.length - 1;


        while (left < right) {
            while (left < a.length && a[left] < 0) {
                left++;
            }
            while (right >= 0 && a[right] > 0) {
                right--;
            }
            if (left < a.length && right >= 0 && a[left] > 0 && a[right] < 0) {
                swap(a, left, right);
                left++;
                right--;
            } else if (left < a.length - 1 && a[left] == 0) {
                swap(a, left, left + 1);
                left++;
            } else if (right > 0 ) {
                swap(a, right, right - 1);
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, -2, -3, -4, 0, -1, -5};
        System.out.println(Arrays.toString(a));
        solve(a);
        System.out.println(Arrays.toString(a));
    }
}
