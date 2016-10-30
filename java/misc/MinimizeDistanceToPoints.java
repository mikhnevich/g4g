package misc;

import java.util.function.DoubleUnaryOperator;

/*
http://www.geeksforgeeks.org/optimum-location-point-minimize-total-distance/
Given a set of points as and a line as ax+by+c = 0. We need to find a point on given line for which sum of distances from given set of points is minimum.

If we take one point on given line at infinite distance then total distance cost will be infinite, now when we move this point on line towards given points the total distance cost starts decreasing and after some time, it again starts increasing which reached to infinite on the other infinite end of line so distance cost curve looks like a U-curve and we have to find the bottom value of this U-curve.
As U-curve is not monotonically increasing or decreasing we can’t use binary search for finding bottom most point, here we will use ternary search for finding bottom most point, ternary search skips one third of search space at each iteration, you can read more about ternary search here.
So solution proceeds as follows, we start with low and high initialized as some smallest and largest values respectively, then we start iteration, in each iteration we calculate two mids, mid1 and mid2, which represent 1/3rd and 2/3rd position in search space, we calculate total distance of all points with mid1 and mid2 and update low or high by comparing these distance cost, this iteration continues untill low and high become approximately equal.

*/
public class MinimizeDistanceToPoints {

    public static class Point {
        public final double x;
        public final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }
    }

    public Point[] points = new Point[]{
            new Point(-3, -2),
            new Point(-1, 0),
            new Point(-1, 2),
            new Point(1, 2),
            new Point(3, 4)
    };

    public DoubleUnaryOperator y = (x) -> x - 3;

    public DoubleUnaryOperator distance = (x) -> {
        double d = 0;
        for (Point p : points) {
            d += Math.sqrt(Math.pow(y.applyAsDouble(x) - p.y, 2) + Math.pow(x - p.x, 2));
        }
        return d;
    };

    public Point ternarySearch(double l, double r) {
        return ternarySearch(l, r, distance);
    }

    private Point ternarySearch(double l, double r, DoubleUnaryOperator f) {
        double epsilon = 0.000001d;

        while (r - l > epsilon) {
            System.out.println("" + l + ", " + r);
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            double v1 = f.applyAsDouble(m1);
            double v2 = f.applyAsDouble(m2);
            if (v2 < v1) {
                l = m1;
            } else if (v2 > v1) {
                r = m2;
            }
        }
        double x = ((l+r)/2);
        return new Point(x, y.applyAsDouble(x));
    }

    public static void main(String[] args) {
        System.out.println((new MinimizeDistanceToPoints().ternarySearch(-1000, 1000)));
    }
}
