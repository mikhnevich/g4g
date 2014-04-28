package list;

/**
 * Created on 3/30/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-65-off-campus-for-sde-2amazon-interview-set-65-campus-sde/
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 *
 * Given a linked list, write a function to reverse every k nodes.
 * Initially I told him solution with help of Stack ,
 * then he asked without using extra space,
 * With his clue, I could able to tell him using recursive logic to solve it.
 Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3
 Output: 3->2->1->6->5->4->8->7->NULL.
 */
public class ReverseKNodes {

    public static Node reverse(Node head, int k) {
        Node start = head;
        Node end = head;
        Node[] prev = null;
        Node result = null;

        while (end != null) {
            int count = k - 1;
            Node prevNode = end;
            while (end != null && count > 0) {
                prevNode = end;
                end = end.next;
                count--;
            }
            if (end == null) {
                end = prevNode;
            }
            Node next = end.next;
            Node[] pair = reverse(start, end);
            if (prev != null) {
                prev[1].next = pair[0];
            } else {
                result = pair[0];
            }
            prev = pair;
            start = next;
            end = start;
        }
        return result;
    }

    private static Node[] reverse(Node start, Node end) {
        Node prev = null;
        Node current = start;
        while (current != end) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return new Node[] {end, start};
    }

    public static void main(String[] args) {
        Node list = ListUtils.makeList(1,2,3,4,5,6,7);
        Node reversed = reverse(list, 3);
        ListUtils.printList(reversed);
    }
}
