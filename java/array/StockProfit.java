package array;

/*
http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

Maximum profit by buying and selling a share at most twice
In a daily share trading, a buyer buys shares in the morning and sells it on same day. If the trader is allowed to make at most 2 transactions in a day, where as second transaction can only start after first one is complete (Sell->buy->sell->buy). Given stock prices throughout day, find out maximum profit that a share trader could have made.

Examples:

Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.

Input:   price[] = {90, 80, 70, 60, 50}
Output:  0
Not possible to earn.

1) ) Create a table profit[0..node-1] and initialize all values in it 0.

2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..node-1]

3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from two transactions in subarray price[0..i].

4) Return profit[node-1]

To do step 1, we need to keep track of maximum price from right to left side and to do step 2, we need to keep track of minimum price from left to right. Why we traverse in reverse directions? The idea is to save space, in second step, we use same array for both purposes, maximum with 1 transaction and maximum with 2 transactions. After an iteration i, the array profit[0..i] contains maximum profit with 2 transactions and profit[i+1..node-1] contains profit with two transactions.

*/
public class StockProfit {
    public static int day1(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
    }

    public static int day2(int[] prices) {
        int n = prices.length;

        int profit[] = new int[n];
        int maxPrice = prices[n-1];
        for (int i = n-2; i >=0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            profit[i] = Math.max(profit[i+1], maxPrice - prices[i]);
        }

        int minPrice = prices[0];
        int day1Profit = 0;
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            day1Profit = Math.max(day1Profit, prices[i] - minPrice);
            profit[i] = Math.max(profit[i-1], profit[i] + day1Profit);
        }

        return profit[n-1];
    }

    public static void main(String[] args) {
        System.out.println(day2(new int[] {12, 11, 13, 9, 12, 8, 14, 13, 15}));
        System.out.println(day2(new int[] {10, 22, 5, 75, 65, 80}));
        System.out.println(day2(new int[] {2, 30, 15, 10, 8, 25, 80}));
        System.out.println(day2(new int[] {100, 30, 15, 10, 8, 25, 80}));
        System.out.println(day2(new int[] {90, 80, 70, 60, 50}));
    }
}
