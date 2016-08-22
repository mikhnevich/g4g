package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493

Problem Statement

A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate
between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence
with fewer than two elements is trivially a zig-zag sequence.

For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and
negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences
 are positive and the second because its last difference is zero.

Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag
 sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence,
 leaving the remaining elements in their original order.


Definition

Class:	ZigZag
Method:	longestZigZag
Parameters:	int[]
Returns:	int
Method signature:	int longestZigZag(int[] sequence)
(be sure your method is public)


Constraints
-	sequence contains between 1 and 50 elements, inclusive.
-	Each element of sequence is between 1 and 1000, inclusive.

Examples
0)

{ 1, 7, 4, 9, 2, 5 }
Returns: 6
The entire sequence is a zig-zag sequence.
1)

{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }
Returns: 7
There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8.
2)

{ 44 }
Returns: 1
3)

{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }
Returns: 2
4)

{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }
Returns: 8
5)

{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }
Returns: 36

 */
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
