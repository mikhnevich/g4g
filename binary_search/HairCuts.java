package binary_search;

import java.util.Arrays;

/**
 * Created by user2 on 2/25/14.
 */
public class HairCuts {

    double maxCut(String[] enter, String lastExit) {
        int N = enter.length;
        int[] m = parse(enter);
        Arrays.sort(m);
        int last = parseTime(lastExit);
        for (int i = 0; i < m.length; i++)
            while (last <= m[i])
                last += 12 * 60;

        double[] d = new double[N];

        double lo = 0, hi = 100000, mid = 0;
        while (Math.abs(hi - lo) > 1e-12) {
            mid = (lo + hi) / 2;
            for (int i = 0; i < N; i++) {
                double start = i == 0 || m[i] > d[i - 1] ? m[i] : d[i - 1];
                d[i] = start + mid;
            }

            if (d[N - 1] > last)
                hi = mid;
            else
                lo = mid;
        }
        double k = mid;
        mid = (lo + hi) / 2;
        System.out.println(k);
        System.out.println(mid);

        return mid + 1e-9 < 5 ? -1 : mid;
    }

    private int[] parse(String[] enter) {
        int[] result = new int[enter.length];
        int i = 0;
        for (String s : enter) {
            result[i++] = parseTime(s);
        }
        return result;
    }

    private int parseTime(String s) {
        String[] time = s.split(":");
        int h = Integer.parseInt(time[0]);
        if (h < 9) h += 12;
        int m = Integer.parseInt(time[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) {
        HairCuts t = new HairCuts();
        System.out.println(t.maxCut(new String[] {"04:55", "04:50", "04:45", "04:40", "04:35", "04:30", "04:25", "04:20", "04:15", "04:10", "04:05", "04:00", "03:55"}, "05:00"));
    }
}
