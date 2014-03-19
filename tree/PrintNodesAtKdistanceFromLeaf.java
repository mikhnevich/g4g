package tree;

import scala.actors.threadpool.Arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sm84878 @ 3/18/14 5:19 PM
 */
public class PrintNodesAtKdistanceFromLeaf {

    public static void printNodes(Node root, int k) {
        printNodesInternal(root, k);
    }


    public static Set<Integer> printNodesInternal(Node root, int k) {
        if (root == null) {
            return new HashSet<Integer>(Arrays.asList(new Integer[] {-1}));
        }
        Set<Integer> ll = printNodesInternal(root.left, k);
        Set<Integer> lr = printNodesInternal(root.right, k);


        Set<Integer> current = new HashSet<>();
        for (Integer i : ll) {
            current.add(i + 1);
        }
        for (Integer i : lr) {
            current.add(i + 1);
        }
        Iterator<Integer> it = current.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i == k) {
                System.out.println(root.value);
                it.remove();
            }
        }
        return current;
    }

    public static void printNodes2(Node root, int k) {
        printNodesInternal(root, k);
    }


    public static void main(String[] args) {
        Node r3 = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5)),
                new Node(3,
                        new Node(6,
                                null,
                                new Node(8)),
                        new Node(7)));
        printNodes(r3, 2);

    }
}
