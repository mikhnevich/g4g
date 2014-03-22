package treap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sm84878 @ 2/28/14 12:31 PM
 */
public class TreapUtils {

    private static int maxLevel(Treap node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<Treap> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public static void printTreap(Treap root) {
        int maxLevel = maxLevel(root);

        printTreapInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printTreapInternal(List<Treap> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Treap> newTreaps = new ArrayList<Treap>();
        for (Treap node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                System.out.print(':');
                System.out.print(node.priority);
                newTreaps.add(node.left);
                newTreaps.add(node.right);
            } else {
                newTreaps.add(null);
                newTreaps.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printTreapInternal(newTreaps, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

}
