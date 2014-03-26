package list;

/**
 * Created by user2 on 2/16/14.
 */
public class Node {
    private int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node reverse(Node n) {
        if (n == null) {
            return null;
        }
        Node prev = new Node(n.data, null);
        Node next = n.next;
        while (next != null) {
            Node newNode = new Node(next.data, prev);
            prev = newNode;
            next = next.next;
        }
        return prev;
    }

    public static boolean isPalindrome(Node node) {
        return isPalindrome(node, listSize(node)).eq;
    }

    private static int listSize(Node node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    private static Result isPalindrome(Node node, int length) {
        if (node == null || length == 0) {
           return new Result(null, true);
        }
        if (length == 1) {
           return new Result(node.next, true);
        }

        if (length == 2) {
           return new Result(node.next.next, node.data == node.next.data);
        }

        Result r = isPalindrome(node.next, length - 2);
        if (!r.eq || r.node == null) {
            return r;
        } else {
            return new Result(r.node.next, node.data == r.node.data);
        }

    }

    private static final class Result {
        Node node;
        boolean eq;

        private Result(Node node, boolean eq) {
            this.node = node;
            this.eq = eq;
        }
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print("[]\n");
    }

    public static void main(String[] args) {
        Node n = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        print(n);
        System.out.println(isPalindrome(n));
        n = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1, null)))));
        System.out.println(isPalindrome(n));
    }
}
