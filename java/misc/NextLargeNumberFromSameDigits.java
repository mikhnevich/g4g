package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/31/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-61-internship/
 * Given a number design the algorithm to find the next greater number which contains exactly same digits. e.g. node= 123 next greater with same digits = 132
 * The number can be very large so its better to consider it as a sequence of characters.
 * <p>
 * If all the digits are in decreasing order from left to right, then no larger number is possible as that is the
 * largest number possible with those digits. If they are not in that order then a larger number is possible.
 * We need to find the rightmost digit which is larger than its immediate left. Then we can bring the larger digit
 * in place of the smaller digit and then arrange the remaining digits in increasing order. For example, if the number
 * is 3784, 8 is the right most digit which is larger than it's left (7). We first replace 7 with 8, so it becomes 38..,
 * then arrange the 7 and 4 in increasing order. so it becomes 3847
 */
public class NextLargeNumberFromSameDigits {


    private static String getNextLarger(int st) {
        return getNextLarger(String.valueOf(st));
    }

    private static String getNextLarger(String st) {
        char[] n = st.toCharArray();
        int digit = -1;
        for (int i = n.length - 1; i > 0; i--) {
            if (n[i] > n[i - 1]) {
                digit = i;
                break;
            }
        }
        if (digit != -1) {
            swap(n, digit, digit - 1);
            sort(n, digit);
        }
        return new String(n);
    }

    private static void sort(char[] n, int start) {
        for (int i = start; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] > n[j]) {
                    swap(n, i, j);
                }
            }
        }
    }

    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        System.out.println("5963=>" + getNextLarger(5963));
        System.out.println("3784=>" + getNextLarger(3784));
        System.out.println("9531=>" + getNextLarger(9531));
        System.out.println("1234=>" + getNextLarger(1234));
        System.out.println("3=>" + getNextLarger(3));
    }
}
