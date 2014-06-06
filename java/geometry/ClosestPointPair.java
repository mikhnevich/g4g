package geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by user on 6/5/14.
 * <p>
 *
 *     closest pair sweep line java
 *
 * http://baptiste-wicht.com/posts/2010/04/closest-pair-of-point-plane-sweep-algorithm.html
 * http://apps.topcoder.com/forums/?module=Thread&threadID=684537
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lineSweep
 */
public class ClosestPointPair {

    public static Point[] closestPair(Point[] points) {
        Point[] closestPair = new Point[2];
        Point[] sortedByX = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedByX, HORIZONTAL_COMPARATOR);

        SortedSet<Point> candidates = new TreeSet<>(VERTICAL_COMPARATOR);

        int leftMostCandidateIndex = 0;

        Double minDistance = Double.POSITIVE_INFINITY;

        for (Point current : sortedByX) {
            while (current.x - sortedByX[leftMostCandidateIndex].x > minDistance) {
                candidates.remove(sortedByX[leftMostCandidateIndex]);
                leftMostCandidateIndex++;
            }
            Point head = new Point(current.x, (int)(current.y - minDistance));
            Point tail = new Point(current.x, (int)(current.y + minDistance));

            for (Point point : candidates.subSet(head, tail)) {
                double distance = current.distance(point);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = current;
                    closestPair[1] = point;
                }
            }

            candidates.add(current);
        }
        return closestPair;
    }

    private static final Comparator<Point> HORIZONTAL_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return (int) Math.signum(o1.x - o2.x);
        }
    };

    private static final Comparator<Point> VERTICAL_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return (int) Math.signum(o1.y - o2.y);
        }
    };
}
