package sort;

import java.util.Arrays;

/**
 * Created by user @ 3/6/14 4:45 PM
 */
public class Quicksort {

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int l, int r) {
        if (l < r) {
            int m = partition(data, l, r);
            sort(data, l, m - 1);
            sort(data, m + 1, r);
        }
    }

    private int partition(int[] data, int l, int r) {
        int x = data[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (data[j] < x) {
                swap(data, i, j);
                i++;
            }
        }
        swap(data, i, r);
        return i;
    }

    private void swap(int[] data, int i, int j) {
        if (i != j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Quicksort sort = new Quicksort();
        int[] data = new int[]{3, 6, 9, 2, 77, 3, 8, 2};
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
