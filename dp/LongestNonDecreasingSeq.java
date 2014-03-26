package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user2 on 2/25/14.
 */
public class LongestNonDecreasingSeq {
    int[] calculate(int[] seq) {
        int min[] = new int[seq.length];
        int from[] = new int[seq.length];
        Arrays.fill(min, 1);
        for (int i = 0; i < from.length; i++) {
            from[i] = i;
        }

        for (int i = 1; i < seq.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] >= seq[j] && (min[i] < min[j] + 1)) {
                    min[i] = min[j] + 1;
                    from[i] = j;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int max = from[0];
        for (int i = 0; i < from.length; i++) {
            if (from[i] > max) {
                max = from[i];
                idx = i;
            }
        }

        list.add(seq[idx]);
        while (from[idx] != idx) {
            list.add(seq[from[idx]]);
            idx = from[idx];
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer t : list) {
            result[k++] = t;
        }
        return result;
    }


    public static void main(String[] args) {
        LongestNonDecreasingSeq q = new LongestNonDecreasingSeq();
        System.out.println(Arrays.toString(q.calculate(new int[] {5, 3, 4, 8, 6, 7})));
    }
}
