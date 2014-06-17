package list;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-70-on-campus/
 * <p>
 * Given a link list with right pointers and each element of the list has a down link contains another link list with down pointers as:
 * <p>
 * 5    ->  7 -> 9 -> 18
 * |
 * 10->6->14
 * |
 * 11
 * |
 * 12->13->24
 * |
 * 15
 * each right and down list are sorted.
 * Write a function flatten() which flattens this link list to a single link list with all the elements in sorted order as:
 * 5->6->7->8->9->10->11->12->13->14->15->18->19->20->22->24
 */
public class Flatten {
    private static class DownNode extends Node {
        DownNode down;

        private DownNode(int value, DownNode next, DownNode down) {
            super(value, next);
            this.down = down;
        }

        public DownNode(int value) {
            super(value);
        }

        public DownNode(int value, DownNode next) {
            super(value, next);
        }
    }

    public static DownNode flatten(DownNode head) {
        DownNode result = head;
        while (head != null) {
            // relink node pointer:
            // a1 -> a2 -> a3
            //  |
            //  b1->b2
            // becomes
            //a1 -> b1->b2 -> a2 -> a3
            if (head.down != null) {
                DownNode last = head.down;
                while (last.next != null) {
                    last = (DownNode) last.next;
                }

                DownNode next = (DownNode) head.next;
                head.next = head.down;
                head.down = null;
                last.next = next;
            }
            head = (DownNode) head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        DownNode bb1 = new DownNode(10, new DownNode(20));
        DownNode aa1 = new DownNode(1, new DownNode(2, new DownNode(3)), bb1);

        ListUtils.printList(flatten(aa1));


        /*
   1->13->14->15
 * |
 * 2->11->12
 * |
 * 3
 * |
 * 4->7->8
 * |     |
 * |     9->10
 * 5->6
         */
        DownNode e1 = new DownNode(5, new DownNode(6));
        DownNode g1 = new DownNode(9, new DownNode(10));
        DownNode d1 = new DownNode(4, new DownNode(7, new DownNode(8, null, g1)), e1);
        DownNode c1 = new DownNode(3, null, d1);
        DownNode b1 = new DownNode(2, new DownNode(11, new DownNode(12)), c1);
        DownNode a1 = new DownNode(1, new DownNode(12, new DownNode(14, new DownNode(15))), b1);
        ListUtils.printList(flatten(a1));

    }
}
