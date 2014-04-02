package array;

import java.util.Arrays;

/**
 * Created on 4/1/2014.
 *
 * Given an array of numbers find all such triplets that satisfy a[i] < a[j] < a[k] where i < j < k.
 *
 */
public class LargerSmallerTriple {
    public static int[] findTriplet(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        int[] c = new int[len];
        b[0] = 0;
        for (int i = 1; i < len; i++) {
            if (a[i] > a[b[i-1]] && a[b[i-1]] <= a[i - 1]) {
                b[i] = b[i - 1];
            } else if (a[i] > a[b[i-1]] && a[b[i-1]] > a[i - 1]) {
                b[i] = i - 1;
            } else {
                b[i] = i;
            }
        }
        c[len - 1] = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (a[i] < a[c[i+1]] && a[c[i+1]] >= a[i+1]) {
                c[i] = c[i + 1];
            } else if (a[i] < a[c[i+1]] && a[c[i+1]] < a[i+1]) {
                c[i] = i + 1;
            } else {
                c[i] = i;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        for (int i : a) {
            if (b[i] < i && i < c[i]) {
                System.out.println(a[b[i]] + " " + a[i] + " " + a[c[i]]);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,0,5,6,7,0};
        findTriplet(a);
    }
}
