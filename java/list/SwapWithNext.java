package list;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-72-campus-sde-1/
 *
 * Swap all nodes of a linked list with their next nodes.
 */
public class SwapWithNext {
    public static Node swap(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            Node nextNext = head.next.next;
            Node next = head.next;
            next.next = head;
            head.next = swap(nextNext);
            return next;
        }
        return head;
    }

    public static Node swapIterative(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = head.next != null ? head.next : head;
        Node previous = null;
        while (head != null && head.next != null) {
            Node nextNext = head.next.next;
            Node next = head.next;
            next.next = head;
            if (previous != null) {
                previous.next = next;
            }
            previous = head;
            head = nextNext;
        }
        if (previous != null) {
            previous.next = head;
        }
            return newHead;
    }

    public static void main(String[] args) {
        ListUtils.printList(swapIterative(ListUtils.makeList(1, 2, 3, 4)));
        ListUtils.printList(swapIterative(ListUtils.makeList(1, 2, 3, 4, 5)));
    }
}
