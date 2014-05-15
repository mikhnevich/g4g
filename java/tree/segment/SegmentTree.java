package tree.segment;

/**
 * Created by user @ 2/7/14 5:04 PM
 */
public class SegmentTree {
    private int[] tree;

    public SegmentTree(int size) {
        this.tree = new int[(int) Math.ceil(Math.log(size))];
    }

    public void split(){}
}
