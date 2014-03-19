package bowl;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sm84878 @ 1/17/14 2:08 PM
 */
public class TestFrame {
    @Test
    public void testScoreNoThrows() {
        Frame f = new Frame();
        Assert.assertEquals(0, f.getScore());
    }

    @Test
    public void testAddOneThrow() {
        Frame f = new Frame();
        f.add(5);
        assertEquals(5, f.getScore());
    }
}
