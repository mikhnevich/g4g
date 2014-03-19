package bowl;

/**
 * Created by sm84878 @ 1/17/14 11:27 AM
 */
public class Frame {
    private int itsScore;
    public int getScore() {
        return itsScore;
    }

    public void add(int pins) {
        itsScore += pins;
    }
}
