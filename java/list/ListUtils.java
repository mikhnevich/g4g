package list;

/**
 * Created on 3/27/2014.
 */
public class ListUtils {
    public static Node makeList(int... values) {
        Node previous = null;
        for (int i = values.length - 1; i >= 0; i--) {
            Node n = new Node(values[i], previous);
            previous = n;
        }
        return previous;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print(' ');
            head = head.next;
        }
        System.out.println();
    }
}
