package dp;

/*
https://www.quora.com/Are-there-any-good-resources-or-tutorials-for-dynamic-programming-besides-the-TopCoder-tutorial

Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, let's number the wines
from left to right as they are standing on the shelf with integers from 1 to N, respectively. The price of the i-th
wine is pi (prices of different wines can be different).

Because the wines get better every year, supposing today is the year 1, on year y the price of the i-th wine will be
 y*pi, i.e. y-times the value that current year.

You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One
 more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf
 and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the
 beginning).

You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order.

So for example, if the prices of the wines are (in the order as they are placed on the shelf, from left to right):
p1=1, p2=4, p3=2, p4=3
The optimal solution would be to sell the wines in the order p1, p4, p3, p2 for a total profit
1*1 + 3*2 + 2*3 + 4*4 = 29

*/
public class SellWineMaxProfit {
    // current = 1
    public static int profitBackTracking(int[] winePrices, int year, int left, int right, int[][] cache) {
        if (cache[left][right] != 0) {
            return cache[left][right];
        }
        if (left == right) {
            return winePrices[left] * year;
        } else {
            int n1 = winePrices[left] * year + profitBackTracking(winePrices, year + 1, left + 1, right, cache);
            int n2 = winePrices[right] * year + profitBackTracking(winePrices, year + 1, left, right - 1, cache);
            cache[left][right] = Integer.max(n1, n2);
            return cache[left][right];
        }
    }

    public static void main(String[] args) {
        int[] winePrices = new int[]{2, 3, 5, 1, 4};
        int[][] cache = new int[winePrices.length][winePrices.length];
        System.out.println(profitBackTracking(winePrices, 1, 0, winePrices.length - 1, cache));
    }
}
