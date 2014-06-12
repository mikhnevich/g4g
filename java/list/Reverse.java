package list;

/**
 * Created @ 6/11/2014
 *
 * Reverse single-linked list
 *
 * http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
 */
public class Reverse {

    public static Node reverse(Node head) {
        Node previous = null;
        while (head != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }


    public static Node reverseRecursive2(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // 2nd element
        Node second = head.next;
        // fix "next" pointer
        head.next = null;

        Node rest = reverse(second);
        second.next = head;

        return rest;
    }

    public static Node reverseRecursive(Node head) {
        Node[] result = reverseRecursiveHelper(head);
        if (result != null) {
            return result[1];
        }
        return null;
    }

    private static Node[] reverseRecursiveHelper(Node head) {
        if (head == null) {
            return null;
        }
        Node next = head.next;
        head.next = null;
        Node[] prev = reverseRecursiveHelper(next);
        Node newHead;
        if (prev != null) {
            prev[0].next = head;
            newHead = prev[1];
        } else {
            newHead = head;
        }
        return new Node[] {head, newHead};
    }


    public static void main(String[] args) {
        ListUtils.printList(reverse(null));
        ListUtils.printList(reverse(ListUtils.makeList(1)));
        ListUtils.printList(reverse(ListUtils.makeList(1,2)));
        ListUtils.printList(reverse(ListUtils.makeList(1,2,3)));
        ListUtils.printList(reverse(ListUtils.makeList(1,2,3,4,5)));

        ListUtils.printList(reverseRecursive(null));
        ListUtils.printList(reverseRecursive(ListUtils.makeList(1)));
        ListUtils.printList(reverseRecursive(ListUtils.makeList(1,2)));
        ListUtils.printList(reverseRecursive(ListUtils.makeList(1,2,3)));
        ListUtils.printList(reverseRecursive(ListUtils.makeList(1,2,3,4,5)));

        ListUtils.printList(reverseRecursive2(null));
        ListUtils.printList(reverseRecursive2(ListUtils.makeList(1)));
        ListUtils.printList(reverseRecursive2(ListUtils.makeList(1,2)));
        ListUtils.printList(reverseRecursive2(ListUtils.makeList(1,2,3)));
        ListUtils.printList(reverseRecursive2(ListUtils.makeList(1,2,3,4,5)));
    }
}
