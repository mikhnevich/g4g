package list;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * <p>
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * Created @ 4/22/2014
 */
public class Numbers {

    public static int length(Node n) {
        int result = 0;
        while (n != null) {
            result += 1;
            n = n.next;
        }
        return result;
    }

    public static class ValueWithCarry {
        public final Node node;
        public final boolean carry;

        public ValueWithCarry(Node node, boolean carry) {
            this.node = node;
            this.carry = carry;
        }
    }

    public static Node add(Node n1, Node n2) {
        int l1 = length(n1);
        int l2 = length(n2);
        ValueWithCarry v;
        if (l1 < l2) {
            v = addHelper(n2, n1, l2 - l1);
        } else {
            v = addHelper(n1, n2, l1 - l2);
        }
        if (v.carry) {
            return new Node(1, v.node);
        } else {
            return v.node;
        }
    }


    public static ValueWithCarry addHelper(Node n1, Node n2, int diff) {
        if (n1 == null) {
            return new ValueWithCarry(null, false);
        } else {
            ValueWithCarry n;
            if (diff > 0) {
                n = addHelper(n1.next, n2, diff - 1);
            } else {
                n = addHelper(n1.next, n2.next, 0);
            }
            int value;
            if (diff == 0) {
                value = n1.value + n2.value;
            } else {
                value = n1.value;
            }
            value += (n.carry ? 1 : 0);
            int normalized = value > 9 ? value - 10 : value;
            boolean carry = value > 9;
            return new ValueWithCarry(new Node(normalized, n.node), carry);
        }
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
        Node n1 = ListUtils.makeList(5, 6, 4);
        Node n2 = ListUtils.makeList(7, 2, 4, 3);
        ListUtils.printList(add(n1, n2));
    }
}
