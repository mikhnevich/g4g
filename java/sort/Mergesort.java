package sort;

import java.util.Arrays;

/**
 * Created by user @ 2/26/14 12:54 PM
 */
public class Mergesort {

    public void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    private void mergesort(int[] array, int[] helper, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergesort(array, helper, lo, mid);
            mergesort(array, helper, mid + 1, hi);
            merge(array, helper, lo, mid, hi);
        }
    }

    private void merge(int[] array, int[] helper, int lo, int mid, int hi) {
        System.arraycopy(array, lo, helper, lo, hi + 1 - lo);

        int hL = lo;
        int hR = mid + 1;
        int current = lo;

        while (hL <= mid && hR <= hi) {
            if (helper[hL] <= helper[hR]) {
                array[current] = helper[hL];
                hL++;
            } else {
                array[current] = helper[hR];
                hR++;
            }
            current++;
        }
        while (hL <= mid) {
            array[current] = helper[hL];
            hL++;
            current++;
        }
    }

    public static void main(String[] args) {
        final int[] a = {2, 3, 1};
        new Mergesort().mergesort(a);
        System.out.println(Arrays.toString(a));
    }
}
