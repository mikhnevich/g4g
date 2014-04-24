package list;

/**
 * Created by sm84878 @ 4/22/2014 16:09
 */
public class Numbers {
    public static Node add(Node n1, Node n2) {
        return null;
    }

    public static Node addReversed(Node n1, Node n2) {
        boolean carry = false;
        Node result = null;
        Node current = null;
        while (n1 != null || n2 != null) {
            int k = 0;
            k += (n1 != null ? n1.value : 0);
            k += (n2 != null ? n2.value : 0);
            k += carry ? 1 : 0;
            if (k >= 10) {
                k -= 10;
                carry = true;
            } else {
                carry = false;
            }
            Node tmp = new Node(k);
            if (result == null) {
                result = tmp;
                current = tmp;
            } else {
                current.next = tmp;
                current = tmp;
            }
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (carry) {
            current.next = new Node(1);
        }
        return result;
    }

    public static void main(String[] args) {
/*
        Node nr1 = ListUtils.makeList(3, 2, 9);
        Node nr2 = ListUtils.makeList(3, 9);
        ListUtils.printList(addReversed(nr1, nr2));

*/
        Node n1 = ListUtils.makeList(9, 2, 3);
        Node n2 = ListUtils.makeList(9, 3);
        ListUtils.printList(add(n1, n2));
    }
}
