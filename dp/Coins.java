package dp;

import java.util.Arrays;

/**
 * Created by user2 on 2/25/14.
 */
public class Coins {

    public int count(int[] V, int sum) {
        int[] min = new int[sum + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int currentCoin : V) {
                int partialSum = i - currentCoin;
                if (partialSum >= 0) {
                    int partialMin = min[partialSum];
                    if (partialMin + 1 < min[i]) {
                        min[i] = partialMin + 1;
                    }
                }
            }
        }
        return min[sum];
    }

    public static void main(String[] args) {
        Coins c = new Coins();
        System.out.println(c.count(new int[]{1, 3, 5}, 11));
    }
}
