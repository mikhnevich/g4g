package list;

/**
 * Created by user2 on 3/18/14.
 */
public class DNode {
    public final int value;
    public DNode previous;
    public DNode next;

    public DNode(int value, DNode previous, DNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}
