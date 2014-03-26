package binary_search;

/**
 * Created by user2 on 2/25/14.
 */
public class UnionOfIntervals {
    int nthElement(int[] lowerBound, int[] upperBound, int n) {
        int min = 2000000000;
        int max = -2000000000;

        for (int i = 0; i < lowerBound.length; i++) {
            if (lowerBound[i] < min) {
                min = lowerBound[i];
            }
            if (upperBound[i] > max) {
                max = upperBound[i];
            }
        }
        int mid = 0;
        while (min <=max) {
            mid = min + (max - min) / 2;
            int count = 0;
            int k = 0;
            for (int i = 0; i < lowerBound.length; i++) {
                if (mid >= lowerBound[i]) {
                    if (mid <= upperBound[i]) {
                        count += mid - lowerBound[i] + 1;
                    } else {
                        count += upperBound[i] - lowerBound[i] + 1;
                    }
                }
            }
            if (count > n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        UnionOfIntervals t = new UnionOfIntervals();
        System.out.println(t.nthElement(new int[] {1, 1, 1, 1, 1, 1}, new int[] {2, 2, 2, 2, 2, 100}, 5));
        System.out.println(t.nthElement(new int[] {1, 100000000, 1, 100000000}, new int[] {100000000, 200000000, 100000000, 200000000}, 222222222));
    }
}
