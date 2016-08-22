package array;

/**
 * Created @ 6/11/2014
 * <p>
 * http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 * <p>
 * Given two sorted arrays A, B of n m and n respectively. Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.
 */
public class KthElementOfUnionOfSortedArrays {

    // O(k) solution
    public static int kThSmallest(int[] a, int[] b, int k) {
        // corner cases
        if (k <= 0) {
            throw new RuntimeException();
        }
        int aLen = length(a);
        int bLen = length(b);
        if (aLen + bLen < k) {
            throw new RuntimeException();
        }
        if (aLen == 0) {
            return b[k - 1];
        }
        if (bLen == 0) {
            return a[k - 1];
        }
        //

        int iA = 0;
        int iB = 0;
        while (k != 1) {
            if (a[iA] < b[iB]) {
                iA++;
                k--;
            } else {
                iB++;
                k--;
            }
            if (iA == aLen) {
                return b[iB + k - 1];
            }
            if (iB == bLen) {
                return a[iA + k - 1];
            }
        }
        return Math.min(a[iA], b[iB]);
    }

    //
    // todo http://stackoverflow.com/questions/4607945/how-to-find-the-kth-smallest-element-in-the-union-of-two-sorted-arrays
    // todo http://stackoverflow.com/questions/19184298/k-th-smallest-element-in-the-union-of-two-sorted-arrays
    // todo http://aleph.nu/blog/kth-smallest-in-sorted-union.html
    // todo https://coderwall.com/p/gumhbg
    // todo http://www.slyar.com/us/leetcode-median-of-two-sorted-arrays.html
    // todo http://apps.topcoder.com/forums/?module=Thread&threadID=750818&start=15&mc=21#1597302
    // todo https://cloris1000.wordpress.com/2013/06/10/find-kth-smalllargest-element-in-two-sorted-array/
    //
    public static int kThSmallestLog(int[] a, int[] b, int k) {
        return kThSmallestLog(a, 0, a.length - 1, b, 0, b.length - 1, k);
    }

    public static int kThSmallestLog(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k) {
        if (aStart > aEnd) {
            return b[bStart + k - 1];
        }
        if (bStart > bEnd) {
            return a[aStart + k - 1];
        }

        int aMid = aStart + (aEnd - aStart) / 2;
        int bMid = bStart + (bEnd - bStart) / 2;
        int p = aMid - aStart + bMid - bStart + 2;

        if (a[aMid] > b[bMid]) {
            if (k < p) {
                return kThSmallestLog(a, aStart, aMid - 1, b, bStart, bEnd, k);
            } else {
                return kThSmallestLog(a, aStart, aEnd, b, bMid + 1, bEnd, k - (bMid + 1 - bStart));
            }
        } else {
            if (k < p) {
                return kThSmallestLog(a, aStart, aMid - 1, b, bStart, bMid - 1, k);
            } else {
                return kThSmallestLog(a, aMid + 1, aEnd, b, bStart, bEnd, k - (aMid + 1 - aStart));
            }
        }
    }


    private static int length(int[] a) {
        return a == null ? 0 : a.length;
    }

    public static void main(String[] args) {
        System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 1)); // 1
        System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 2)); // 2
        System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 3)); // 3
        try {
            System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 8)); // exception
        } catch (Exception e) {
            System.out.println("expected exception");
        }
        try {
            System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 0)); // exception
        } catch (Exception e) {
            System.out.println("expected exception");
        }
        try {
            System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, -1)); // exception
        } catch (Exception e) {
            System.out.println("expected exception");
        }
        System.out.println(kThSmallestLog(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 4)); // 4
    }
}
