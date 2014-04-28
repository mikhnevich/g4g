package array;

/**
 * Created @ 4/28/2014
 *
 * http://csjobinterview.wordpress.com/2012/03/30/array-stable-partition/
 *
 * Given an array of positive and negative integers, re-arrange it so that you have positives on one end and negatives on the other. BUT retain the original order of appearance. do it in-place  e.g. 1, 7, -5, 9, -12, 15 => -5, -12, 1, 7, 9, 15

 */
public class StablePartition {
   /* public static void partition(int[] a) {
        int countPositive = 0;
        int startPositive = -1;
        int endPositive;
        int endNegative = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (endNegative == -1) {
                    startPositive = startPositive == -1 ? i : startPositive;
                    countPositive++;
                } else {
                    reverse(a, startPositive, endNegative);
                    reverse(a, startPositive, endNegative - countPositive);
                    reverse(a, endNegative - countPositive + 1, endNegative);
                    startPositive = -1;
                    countPositive = 0;
                    endNegative = -1;
                }
            } else if (startPositive > -1) {
                endNegative = i;
            }
        }

        startPositive = 0;
        while (i < a.length && a[i] > 0) {
            i++;
            count++;
        }
        endPositive = i - 1;
        while (i < a.length && a[i] < 0) {
            i++;
        }
        endNegative = i - 1;

    }*/
}
