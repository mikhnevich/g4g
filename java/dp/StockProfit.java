package dp;

import array.ArrayUtils;

/*
http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

Maximum profit by buying and selling a share at most K
In a daily share trading, a buyer buys shares in the morning and sells it on same day. If the trader is allowed to make 
at most K transactions in a day, where as second transaction can only start after first one is complete (Sell->buy->sell->buy). Given stock prices throughout day, find out maximum profit that a share trader could have made.

T[i, j] = max         1) T[i, j-1] - no transaction on day j
i - transaction       2) best you can get by doing a transaction on day j: (price[j] - price[m]) + T[i-1][m], m=0..j-1
j - day                  meaning you sell on j-th day, implies you have to buy on m-th date

optimized:
T[i, j] = max  1) T[i, j-1] - no transaction on day j
               2) price[j] + maxDiff, maxDiff = max(maxDiff, T[i-1, j] - price[j]

day   0  1  2  3  4  5  6  7
price 2  5  7  1  4  3  1  3
    |-------------------------
  0 | 0  0  0  0  0  0  0  0
  1 | 0  3  5  5  5  5  5  5
  2 | 0  3  5  5  8  8  8  8
  3 | 0  3  5  5  8  8  8  10

10 didn't come from a(3, 6) -> means there was a sell on day 7
10 - price[7] = 10 - 3 = 7
looking at previous row - find where diff: a(i,j) - price(j) = 7. This is column 6 => buy on day 6
now by the same token 8 - the sell was made on day 4. Then, 8 - 4 = 4
previous row (1) - find diff=4: column 3 - buy was done there
on day 2 - there was a sell (5 didn't come from previous column). 5 - 7 = -2 => buy was on day 0

Space: O(node*k)
Time:  O(node*k) optimized, O(node^2 * k) - non-optimized

*/
public class StockProfit {
    public static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int a[][] = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max = 0;
                for (int m = 0; m < j; m++) {
                    max = Math.max(a[i-1][m] + prices[j] - prices[m], max);
                }
                a[i][j] = Math.max(a[i][j-1], max);
            }
        }
        ArrayUtils.print(a);
        return a[k][n-1];
    }

    // removing m loop. If you write formula for e.g. row 2 - it becomes clear
    public static int maxProfitOptimized(int[] prices, int k) {
        int n = prices.length;
        int a[][] = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = 0;
            for (int j = 1; j < n; j++) {
                int diff = a[i-1][j-1] - prices[j-1];
                maxDiff = Math.max(maxDiff, diff);
                a[i][j] = Math.max(a[i][j-1], maxDiff + prices[j]);
            }
        }
        ArrayUtils.print(a);
        return a[k][n-1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {2, 5, 7, 1, 4, 3, 1, 3}, 3));
    }
}
