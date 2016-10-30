package dp;

import array.ArrayUtils;
import tree.LeftView;

/*
https://leetcode.com/problems/burst-balloons/

Given node balloons, indexed from 0 to node-1. Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons.
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[node] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ node ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

*/
public class BirstBalloons {


    public static int maxCoinsDC(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            int c = nums[left] * nums[i] * nums[right];
            int l = burst(memo, nums, left, i);
            int r = burst(memo, nums, i, right);
            ans = Math.max(ans, c + l + r);
        }
        memo[left][right] = ans;
        return ans;
    }

    // https://www.youtube.com/watch?v=IFNibRVgFBo
    public static int maxCoins2(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int left = 1;
                    int right = 1;
                    if (i != 0) left = nums[i - 1];
                    if (j != n - 1) right = nums[j + 1];

                    int before = 0;
                    int after = 0;
                    if (i != k) before = a[i][k - 1];
                    if (j != k) after = a[k + 1][j];
                    a[i][j] = Math.max(left * nums[k] * right + before + after, a[i][j]);
                }
            }
        }
        ArrayUtils.print(a);
        return a[0][n - 1];
    }

    // Let's use dp[i][j] to denote maximum gain from balloon range i to j. We try out each balloon as last burst in
    // this range. Then the subproblem relation would be:
    //
    //  foreach k in i to j:
    //      dp[j][i] = max(
    //                   array[j-1]*array[k]*array[i+1] + dp[j][k-1] + dp[k+1][i],
    //                   dp[j][i]
    //      );

    public static int maxCoins(int[] nums) {
        // Extend list with head and tail (both are 1), index starts at 1
        int n = nums.length;
        int array[] = new int[nums.length + 2];
        array[0] = 1;
        array[array.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = nums[i];
        }

        // Initialize DP arrays, 1 index based
        int dp[][] = new int[array.length][array.length]; //dp[i][j] stands for max coins at i step, burst j
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i; j >= 1; j--) {
                // k as last
                for (int k = j; k <= i; k++) {
                    dp[j][i] = Math.max(array[j - 1] * array[k] * array[i + 1] + dp[j][k - 1] + dp[k + 1][i], dp[j][i]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
//        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(maxCoinsDC(new int[]{3, 1, 5, 8}));
        System.out.println(maxCoins2(new int[]{3, 1, 5, 8}));
    }
}
