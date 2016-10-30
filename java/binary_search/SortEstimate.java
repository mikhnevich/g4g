package binary_search;

/**
 * Created by user2 on 2/25/14.
 */
public class SortEstimate {
    public static double howMany(int c, int time) {
        // You have implemented a sorting algorithm that requires exactly c*node*lg(node) nanoseconds to sort node integers.
        // Here lg denotes the base-2 logarithm. Given time nanoseconds, return the largest double node such that c*node*lg(node) <= time.
        // Your return value must have a relative or absolute error less than 1e-9.

        double lo = 0;
        double hi = time / c;
        double n = 0;
        double t0 = time;
        while (true) {
            n = lo + (hi - lo) / 2;
            double t = c * n * Math.log(n) / Math.log(2);
            if (Math.abs(t0 - t) < 1e-9) {
                return n;
            }
            t0 = t;
            if (t > time) {
                hi = n;
            } else {
                lo = n;
            }
        }
    }

    public static double howMany2(int c, int time) {
        double n0 = 0, n1 = 4e+9, t1 = 2000000000;
        while (true) {
            double m0 = (n0 + n1) / 2;
            double t0 = calc(m0, c);

            if (Math.abs(t1 - t0) < 1e-9) {
                return m0;
            }
            t1 = t0;

            if (t0 < time) {
                n0 = m0;
            } else {
                n1 = m0;
            }
        }
    }

    static double calc(double n, double c) {
        return n * Math.log(n) * c / Math.log(2);
    }

    public static void main(String[] args) {
        System.out.println(howMany(1, 2000000000));
    }
}
