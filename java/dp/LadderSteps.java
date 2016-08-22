package dp;

import java.util.Arrays;

/*
 ladder with n steps, you can jump by 1, 2 or 3 steps.
 How many different sequences exist to climb the ladder?
 */
public class LadderSteps {

    public int count(int N) {
        if (N <= 1) {
            return 1;
        }
        return count(N - 1) + count(N - 2) + count(N - 3);
    }

    // use only 2 previous steps - O(1) space, O(n) time
    public int countCached(int N) {
        int[] cache = new int[N + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        cache[1] = 1;
        return countCachedInternal(N, cache);
    }

    private int countCachedInternal(int N, int[] cache) {
        if (N < 0) {
            return 0;
        }
        int cached = getCache(N, cache);
        if (cached != -1) {
            return cached;
        }
        int newValue = countCachedInternal(N - 1, cache)
                + countCachedInternal(N - 2, cache);
        setCache(cache, N, newValue);
        return newValue;
    }

    // use only 2 previous steps - O(1) space, O(n) time
    // do bottom-up instead of up-bottom
    public int countCachedOptimized(int N) {
        int[] cache = new int[2];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            int value = cache[0] + cache[1];
            cache[i % 2] = value;
        }
        return cache[N % 2];
    }

    // use only 2 previous steps - O(1) space, O(n) time
    // do bottom-up instead of up-bottom
    public int countTimur(int N) {
        int f = 1;
        int f1 = 1;
        for (int j = 2; j <= N; j++) {
            f = f + f1;
            f1 = f - f1;
        }
        return f;
    }


    int getCache(int i, int[] cache) {
        return cache[i];
    }

    void setCache(int[] cache, int index, int value) {
        cache[index] = value;
    }

    public static void main(String[] args) {
        LadderSteps s = new LadderSteps();
        int cnt = 0;
        long start, time;
        int N = 40;

/*
        start = System.currentTimeMillis();
        cnt = s.n(N);
        time = System.currentTimeMillis() - start;
        System.out.println(cnt + ", " + time);
*/
        System.out.println(s.countCached(N));
        System.out.println(s.countCachedOptimized(N));
        System.out.println(s.countTimur(N));

    }
}
