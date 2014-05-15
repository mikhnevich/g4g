package list;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-70-on-campus/
 *
 * Given a link list with right pointers and each element of the list has a down link contains another link list with down pointers as:

 5 -> 7 -> 9 -> 18
 |    |    |    |
 10    6    14   20
 |    |    |    |
 11    8    19   22
 |    |         |
 12    13        24
 |
 15
 each right and down list are sorted.
 Write a function flatten() which flattens this link list to a single link list with all the elements in sorted order as:
 5->6->7->8->9->10->11->12->13->14->15->18->19->20->22->24

 */
public class Flatten {
    private static class Node {
        int value;
        Node next;
        Node down;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node flatten(Node head) {
        return null;
    }
}
