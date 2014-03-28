package array;

import java.util.Arrays;

/**
 * Created by user @ 3/11/14 4:33 PM
 */
public class KthStatistics {

    public int statistics(int[] a, int k) {
        return statistics(a, 0, a.length - 1, k);
    }

    public int statistics(int[] a, int left, int right, int k) {
        if (left == right) {
            return a[left];
        }
        int pivotIndex = selectPivot(left, right);
        pivotIndex = partition(a, left, right, pivotIndex);
        int rank = pivotIndex - left + 1;
        if (rank == k) {
            return a[pivotIndex];
        } else if (k < rank) {
            return statistics(a, left, pivotIndex - 1, k);
        } else {
            return statistics(a, pivotIndex + 1, right, k - rank);
        }
    }

    private int partition(int[] a, int left, int right, int pivotIndex) {
        int swapIndex = left;
        int pivotValue = a[pivotIndex];
        swap(a, right, pivotIndex);
        for (int i = left; i < right; i++) {
            if (a[i] <= pivotValue) {
                swap(a, i, swapIndex);
                swapIndex++;
            }
        }
        swap(a, right, swapIndex);
        return swapIndex;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int selectPivot(int left, int right) {
        return (left + right) / 2;
    }


    public int statistics2(int[] a, int k) {
        return statistics2(a, 0, a.length - 1, k);
    }

    public int statistics2(int[] a, int left, int right, int k) {
        int length = right - left + 1;
        if (length <= 5) {
            Arrays.sort(a, left, right + 1);
            final int index = left + k;
            return a[index];
        }
        int numMedians = length / 5;
        numMedians += (length % 5 > 0 ? 1: 0);
        int[] medians = new int[numMedians];
        for (int i = 0; i < numMedians; i++) {
            int start = left + 5*i;
            int end = start + 4;
            if (end > right) {
                end = right;
            }
            medians[i] = statistics2(a, start, end, (end - start + 1)/2);
        }
        int pivot = statistics2(medians, 0, medians.length - 1, medians.length/2);
        int pivotIndex = partition2(a, left, right, pivot);
        int rank = pivotIndex - left + 1;
        if (k == rank) {
            return a[pivotIndex];
        }
        else if (k < rank) {
            return statistics2(a, 0, pivotIndex - 1, k);
        } else {
            return statistics2(a, pivotIndex + 1, right, k - rank);
        }
    }

    private int partition2(int[] a, int left, int right, int pivotValue) {
        int swapIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] <= pivotValue) {
                swap(a, i, swapIndex);
                swapIndex++;
            }
        }
        return swapIndex - 1;
    }

    public static void main(String[] args) {
        KthStatistics s = new KthStatistics();
        int[] a;
        int result;
/*
        a = new int[] {10,9,8,7,6,5,4,3,2,1};
        result = s.statistics2(a, 4);
        System.out.println(result + ": " + Arrays.toString(a));

        a = new int[] {10,9,8,7,6,5,4,3,2,1};
        result = s.statistics2(a, 7);
        System.out.println(result + ": " + Arrays.toString(a));
*/

        a = new int[] {1,2,3,4,5,6,7,8,9,10};
        result = s.statistics2(a, 4);
        System.out.println(result + ": " + Arrays.toString(a));

        a = new int[] {1,2,3,4,5,6,7,8,9,10};
        result = s.statistics2(a, 7);
        System.out.println(result + ": " + Arrays.toString(a));
    }
}
