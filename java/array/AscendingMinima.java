package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created @ 4/28/2014
 */
public class AscendingMinima {
    private static final class Entry {
        int value;
        int index;

        private Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<Integer> minima(int[] a, int k) {
        List<Entry> window = new LinkedList<>();
        List<Integer> result = new ArrayList<>(a.length);
        for (int i = 0; i < a.length; i++) {
            while (!window.isEmpty() && window.get(window.size() - 1).value >= a[i]) {
                window.remove(window.size() - 1);
            }
            window.add(new Entry(a[i], i));

            while (window.get(0).index <= i - k) {
                window.remove(0);
            }

            result.add(window.get(0).value);
        }
        return result;

/*
remove from the queue all items with value greater than the incoming item,
append the incoming item to the end of the queue, along with its “death index,” and
remove the head of the queue if it is beyond its death index.
 */
    }

    public static void main(String[] args) {
        int[] a = new int[] {4,3,2,1,5,7,6,8,9};
        System.out.println(Arrays.toString(a));
        List<Integer> result = minima(a, 3);
        System.out.println(result);
    }
}
