package misc;


import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalsTest {
    @Test
    public void singleRange() {
        MergeIntervals sr = new MergeIntervals();
        sr.addNum(0);
        sr.addNum(0);
        Assert.assertArrayEquals(new MergeIntervals.Interval[]{
                        new MergeIntervals.Interval(0, 0)
                },
                sr.getIntervals().toArray());
    }

    @Test
    public void range1() {
        MergeIntervals sr = new MergeIntervals();
        sr.addNum(0);
        sr.addNum(4);
        sr.addNum(3);
        Assert.assertArrayEquals(new MergeIntervals.Interval[]{
                        new MergeIntervals.Interval(0, 0), new MergeIntervals.Interval(3, 4)
                },
                sr.getIntervals().toArray());
    }

    @Test
    public void range2() {
        MergeIntervals sr = new MergeIntervals();
        sr.addNum(4);
        sr.addNum(3);
        sr.addNum(4);
        Assert.assertArrayEquals(new MergeIntervals.Interval[]{
                        new MergeIntervals.Interval(3, 4)
                },
                sr.getIntervals().toArray());
    }
    @Test
    public void range3() {
        MergeIntervals sr = new MergeIntervals();
        sr.addNum(6);
        sr.addNum(6);
        sr.addNum(0);
        sr.addNum(4);
        sr.addNum(8);
        sr.addNum(7);
        sr.addNum(6);
        sr.addNum(4);
        sr.addNum(7);
        sr.addNum(5);
        Assert.assertArrayEquals(new MergeIntervals.Interval[]{
                        new MergeIntervals.Interval(0, 0), new MergeIntervals.Interval(4, 8),
                },
                sr.getIntervals().toArray());
    }
}
