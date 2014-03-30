package binary_search;

import java.util.function.Predicate;

/**
 * Created on 3/29/2014.
 */
public class BinarySearchUtils {
    public static int binarySearch(int[] a, Predicate p) {
        return binarySearch(a, 0, a.length - 1, p);
    }

    public static int binarySearch(int[] a, int lo, int hi, Predicate p) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (p.test(a[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (!p.test(a[lo])) {
            return -1;
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] a = {0, 3};
        System.out.println(binarySearch(a, equalOrGreater(2)));
    }

    public static Predicate<Integer> equalOrGreater(final int value) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i >= value;
            }
        };
    }

    public static Predicate<Integer> greater(final int value) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i > value;
            }
        };
    }
}
