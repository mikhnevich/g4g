package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created on 3/29/2014.
 * http://stackoverflow.com/questions/9493853/given-an-array-find-out-the-next-minimum-element-for-each-element
 * <p>
 * Given an array find the next smaller element in array for each element without changing the original order
 * of the elements.
 * <p>
 * For example, suppose the given array is 4,2,1,5,3.
 * <p>
 * The resultant array would be 2,1,-1,3,-1.
 */
public class NextMinimum {
    public static int[] nextMin(int... a) {
        int len = a.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && a[i] < a[st.peek()]) {
                result[st.pop()] = a[i];
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextMin(4, 2, 1, 5, 3)));
    }
}
