package list;

/**
 * Created on 3/27/2014.
 * http://yucoding.blogspot.com.au/2013/12/leetcode-question-reorder-list.html
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}


 Another solution (not mine):

 So the algorithm implemented below can be summarized as:
 Step 1  Find the middle pointer of the linked list (you can use the slow/fast pointers)
 Step 2  Reverse the second part of the linked list (from middle->next to the end)
 Step 3  Do the reordering. (inset every element in the second part in between the elements in the first part)


 */
public class ReorderList {

    public static void reorder(Node node) {
        int length = getNodeLength(node);
        int mid = length / 2;
        int start = length % 2 == 0 ? mid : mid + 1;
        Node startNode = getNode(node, start);
        Node endNode = getNode(node, start - 1);
        endNode.next = null;
        reorderHelper(startNode, node);

    }

    private static Node getNode(Node n, int start) {
        while (start != 0 && n != null) {
            n = n.next;
            start--;
        }
        return n;
    }

    private static Node reorderHelper(Node node, Node first) {
        Node n;
        if (node != null) {
            n = reorderHelper(node.next, first);
        } else {
            return null;
        }
        if (n == null) {
            n = first;
        }
        Node next = n.next;
        n.next = node;
        node.next = next;
        return next;
    }

    private static int getNodeLength(Node node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    public static void main(String[] args) {
        Node n = ListUtils.makeList(1, 2, 3, 4,5 ,6,7,8);
        ListUtils.printList(n);
        reorder(n);
        ListUtils.printList(n);

        n = ListUtils.makeList(1, 2, 3, 4,5);
        ListUtils.printList(n);
        reorder(n);
        ListUtils.printList(n);
    }
}
