package geometry;

/**
 * Created by user on 6/5/14.
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2));
    }
}
