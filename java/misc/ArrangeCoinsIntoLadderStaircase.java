package misc;

/*

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
Given n, find the total number of full staircase rows that can be formed.
n is a non-negative integer and fits within the range of a 32-bit signed integer.
Example 1:
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

*/
public class ArrangeCoinsIntoLadderStaircase {

    public static int kThSum(int k) {
        return (1 + k)*k / 2;
    }

    public static int count3(int n) {
        // x(x+1)/2 = n   => x = sqrt(2 * n + 1/4) - 1/2
        return (int)Math.floor(Math.sqrt(2 * n + 0.25) - 0.5);
    }

    public static int count2(int n) {
        int l = 0;
        int r = n + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (m * (m + 1) / 2 > n) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        return l - 1;
    }
    public static int count(int n) {
        // binary search - log n
        int min = 0;
        int max = n;
        int x = 0;
        while (min < max) {
            x = min + (max - min + 1)/2;
            int sum = kThSum(x);
            if (sum > n) {
                max = x-1;
            } else if (sum < n) {
                min = x;
            } else {
                min = x;
                max = min;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            int a = count(i);
            int b = count2(i);
            int c = count3(i);
            if (a != b || a != c) {
                System.out.println("" + i + ": " + a + " / " + b + " / " + c);
            }
        }
    }
}
