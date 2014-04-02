package geometry;

/**
 * Created @ 3/28/2014 17:32
 */
public class OverlappingRectangles {
    public boolean overlap(Rectangle r1, Rectangle r2) {
        return !(r2.topLeftX > r1.bottomRightX
                || r2.bottomRightY > r1.topLeftY
                || r2.bottomRightX < r1.topLeftX
                || r2.topLeftY < r1.bottomRightY);
    }

    public static class Rectangle {
        public final int topLeftX;
        public final int topLeftY;
        public final int bottomRightX;
        public final int bottomRightY;

        public Rectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
            this.topLeftX = topLeftX;
            this.topLeftY = topLeftY;
            this.bottomRightX = bottomRightX;
            this.bottomRightY = bottomRightY;
        }
    }
}
