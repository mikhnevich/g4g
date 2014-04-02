package tree;

/**
 *
 */
public class TreeFromArray {
    public static Node fromArray(int[] array) {
        return fromArray(array, 0, array.length - 1);
    }

    public static Node fromArray(int[] array, int start, int end) {
        int length = end - start;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new Node(array[0]);
        }
        int median = length / 2;
        Node left = fromArray(array, start, median - 1);
        Node right = fromArray(array, start, median - 1);
        return new Node(array[median], left, right);
    }


}
