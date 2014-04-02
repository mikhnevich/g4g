package list;

/**
 * Created @ 3/31/2014
 */
public class MergeSortedLists {

    public static Node merge(Node h1, Node h2) {
        Node current;
        if (h1.value < h2.value) {
            current = h1;
            h1 = h1.next;
        } else {
            current = h2;
            h2 = h2.next;
        }
        Node head = current;

        while (h1 != null && h2 != null) {
            if (h1.value < h2.value) {
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        if (h1 == null) {
            while (h2 != null) {
                current.next = h2;
                h2 = h2.next;
                current = current.next;
            }
        } else {
            while (h1 != null) {
                current.next = h1;
                h1 = h1.next;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = ListUtils.makeList(1,5,9,13,15);
        Node n2 = ListUtils.makeList(2,6,8,9,14,18,20,23,27);
        Node h = merge(n1, n2);
        ListUtils.printList(h);
    }
}