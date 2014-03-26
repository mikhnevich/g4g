package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZag {
    public int[] longestZigZag(int[] seq) {
        int N = seq.length;
        int[] maxP = new int[N];
        int[] maxN = new int[N];
        int[] fromP = new int[N];
        int[] fromN = new int[N];

        Arrays.fill(maxP, 1);
        Arrays.fill(maxN, 1);

        for (int i = 0; i < N; i++) {
            fromP[i] = i;
            fromN[i] = i;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    if (maxP[j] + 1 > maxN[i]) {
                        maxN[i] = maxP[j] + 1;
                        fromN[i] = j;
                    }
                } else if (seq[j] > seq[i]) {
                    if (maxN[j] + 1 > maxP[i]) {
                        maxP[i] = maxN[j] + 1;
                        fromP[i] = j;
                    }

                }
            }
        }

        int idx = 0;
        int max = 0;
        boolean negative = true;
        for (int i = 0; i < N; i++) {
            if (max < maxN[i]) {
                max = maxN[i];
                idx = i;
                negative = true;
            }
            if (max < maxP[i]) {
                max = maxP[i];
                idx = i;
                negative = false;
            }
        }

        System.out.println(max);
        List<Integer> list = new ArrayList<>();
        list.add(seq[idx]);

        negative = !negative;
        while (negative ? fromP[idx] != idx : fromN[idx] != idx) {
            negative = !negative;
            list.add(negative ? seq[fromN[idx]] : seq[fromP[idx]]);
            idx = negative ? fromN[idx] : fromP[idx];
        }

        int[] result = new int[list.size()];
        int k = result.length - 1;
        for (Integer t : list) {
            result[k--] = t;
        }
        return result;
    }

    public int longestZigZag2(int[] sequence) {
        if (sequence.length == 1) return 1;
        int[] v = new int[sequence.length - 1];
        for (int i = 1; i < sequence.length; i++) {
            v[i - 1] = sequence[i] - sequence[i - 1];
        }
        System.out.println(Arrays.toString(v));
        //    dir is first nonzero
        int ii = 0;
        while (ii < v.length && v[ii] == 0) {
            ii++;
        }
        if (ii == v.length) {
            return 1;
        }
        int dir = v[ii];
        int len = 2;
        for (int i = ii + 1; i < v.length; i++) {
            if (v[i] * dir < 0) {
                dir *= -1;
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        ZigZag z = new ZigZag();
        System.out.println(z.longestZigZag2(new int[]{19, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(Arrays.toString(z.longestZigZag(new int[]{45, 55, 63, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32})));
    }
}
