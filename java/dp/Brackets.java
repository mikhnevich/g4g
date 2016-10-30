package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-74/
 * <p>
 * 2) given a number node, print all pairs of valid parenthesis
 * <p>
 * eg: node=2 -> (()), ()()
 * node=3 -> ()()(), (())(),()(()), ((()))
 */
public class Brackets {

    // ony type only
    public static void printBrackets(int pairs) {
        char[] value = new char[pairs * 2];
        Arrays.fill(value, ' ');
        printBrackets(value, 0, pairs, pairs);
    }

    private static void printBrackets(char[] value, int index, int leftP, int rightP) {
        if (leftP == 0 && rightP == 0) {
            System.out.println(value);
            return;
        }
        if (leftP > 0) {
            value[index] = '(';
            printBrackets(value, index + 1, leftP - 1, rightP);
            value[index] = ' ';
        }
        if (leftP < rightP) {
            value[index] = ')';
            printBrackets(value, index + 1, leftP, rightP - 1);
            value[index] = ' ';
        }
    }

    public static void printMultipleBrackets(String opening, String closing, int[] count) {
        if (opening.length() != closing.length()) {
            throw new IllegalArgumentException();
        }
        if (opening.length() != count.length) {
            throw new IllegalArgumentException();
        }
        if (opening.length() == 0) {
            return;
        }
        int totalLength = 0;
        for (int i : count) {
            totalLength += i * 2;
        }
        if (totalLength == 0) {
            return;
        }

        char[] value = new char[totalLength];
        Arrays.fill(value, ' ');
        Stack<Character> current = new Stack<>();
        int[] closedCount = new int[count.length];
        System.arraycopy(count, 0, closedCount, 0, count.length);
        printMultipleBrackets(value, 0, opening.toCharArray(), closing.toCharArray(), count, closedCount, current, totalLength);
    }

    private static void printMultipleBrackets(char[] value, int index, char[] open, char[] closed, int[] openCount, int[] closedCount, Stack stack, int length) {
        if (length == index) {
            System.out.println(value);
            return;
        }

        for (int i = 0; i < openCount.length; i++) {
            if (openCount[i] > 0) {
                value[index] = open[i];
                stack.push(open[i]);
                int oldCount = openCount[i];
                openCount[i]--;
                printMultipleBrackets(value, index + 1, open, closed, openCount, closedCount, stack, length);
                openCount[i] = oldCount;
                empty(value, index, stack);
            }
        }
        for (int i = 0; i < openCount.length; i++) {
            if (closedCount[i] > openCount[i] && (stack.isEmpty() || stack.peek().equals(open[i]))) {
                value[index] = closed[i];
                stack.pop();
                int oldCount = closedCount[i];
                closedCount[i]--;
                printMultipleBrackets(value, index + 1, open, closed, openCount, closedCount, stack, length);
                closedCount[i] = oldCount;
                stack.push(open[i]);
                empty(value, index, stack);
            }
        }
    }

    private static void empty(char[] value, int index, Stack stack) {
        if (!stack.isEmpty() && stack.peek().equals(value[index])) {
            stack.pop();
        }
        value[index] = ' ';
    }


    private static class Combination {
        String value;
        int leftP;
        int rightP;
        int leftC;
        int rightC;

        private Combination(String value, int leftP, int rightP, int leftC, int rightC) {
            this.value = value;
            this.leftP = leftP;
            this.rightP = rightP;
            this.leftC = leftC;
            this.rightC = rightC;
        }

        @Override
        public String toString() {
            return "{" + value +
                    ", leftP=" + leftP +
                    ", rightP=" + rightP +
                    ", leftC=" + leftC +
                    ", rightC=" + rightC +
                    '}';
        }
    }


    private static void printBracketsIterative(int parenthesis, int square) {
        int len = parenthesis * 2 + square * 2;
        List<Combination> q = new LinkedList<>();
        q.add(new Combination("", parenthesis, parenthesis, square, square));
        while (!q.isEmpty()) {
            Combination s = q.remove(0);
            if (s.value.length() == len) {
                System.out.println(s.value);
                continue;
            }
            if (s.leftP > 0) {
                q.add(new Combination(s.value + '(', s.leftP - 1, s.rightP, s.leftC, s.rightC));
            }
            if (s.leftC > 0) {
                q.add(new Combination(s.value + '{', s.leftP, s.rightP, s.leftC - 1, s.rightC));
            }
            //todo ({())}
            //todo ({()})
            if (s.leftP < s.rightP && !s.value.endsWith("{")) {
                q.add(new Combination(s.value + ')', s.leftP, s.rightP - 1, s.leftC, s.rightC));
            }
            if (s.leftC < s.rightC && !s.value.endsWith("(")) {
                q.add(new Combination(s.value + '}', s.leftP, s.rightP, s.leftC, s.rightC - 1));
            }
        }
    }

    /*
    http://discuss.joelonsoftware.com/default.asp?interview.11.437754.20

    A bit pattern like:   10101100
    Can be intepreted as: ()()(())

    The function cycles through all bit patterns of the appropriate length and eliminates those that fail the three tests described below.
    The tests depend on calculating the sums of the bit patterns, with 0 being replaced by -1.
    e.g. sum(1100) = 1 + 1 - 1 - 1 = 0

    Here are the tests:
    (1) sum(bitpattern) = 0

    Here is an example which fails:
    sum(1110) = 1 + 1 + 1 - 1 = 2

    (2) All partial sums must be >= 0.
    Here is an example which fails:
    bitpattern = 1001

    sum(1) = 1
    sum(10) = 1 - 1 = 0
    sum(100) = 1 - 1 - 1 = -1 *
    sum(1001) = 1 - 1 - 1 + 1 = 0

    (3) All partial sums must <= pairs/2

    Here is an exmple which fails:
    bitpattern = 1110

    sum(1) = 1
    sum(11) = 1 + 1 = 2
    sum(111) 1 + 1 + 1 = 3 *
    sum(111) = 1 + 1 + 1 - 1 = 2

    To make the code a little bit more efficient, we ignore the first and last parentheses,
    because the first will always be '(' and the last will always be ')'.


    Unfortunately I'm not at work and don't have MS-Dev on this computer else I'd tell you for certain but I think that
    with a length of 2 (4 brackets totals) 5 / 16 work. With a length of 3 (6 brackets total) 15 / 64 work. I didn't
    triple check this but I'm wondering whether it's a downward slope and the algorithm will become sub-optimal for
    large values of N.


    Mike, you're right, the proportion is:
    (2n)!/(node + 1)!node!4^node
    Which tends to 0 as node gets larger.
    So the algorithm isn't anywhere near optimal.


     */
    private static void printBracketsIterative(int pairs) {
        int i, j, s, n = 2 * (pairs - 1);

        for (i = 0; i < 1 << n; i++) {
            for (s = 1, j = 0; (j < n) && (s >= 0) && (s <= pairs); j++) {
                s += ((i >> j) & 1) > 0 ? 1 : -1;
            }
            if ((j != n) || (s != 1)) {
                continue;
            }
            System.out.print('(');
            for (j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    System.out.print('(');
                } else {
                    System.out.print(')');
                }
            }
            System.out.println(")");
        }
    }

    private static class CombinationOptimized {
        String value;
        int leftP;
        int rightP;
        int leftC;
        int rightC;
        int state = 0;

        private CombinationOptimized(int state, String value, int leftP, int rightP, int leftC, int rightC) {
            this.state = state;
            this.value = value;
            this.leftP = leftP;
            this.rightP = rightP;
            this.leftC = leftC;
            this.rightC = rightC;
        }

    }


    /**
     * State 0 -
     */
    private static void printBracketsIterativeOptimized(int parenthesis, int square) {
        int len = parenthesis * 2 + square * 2;
        Stack<CombinationOptimized> q = new Stack<>();
        q.push(new CombinationOptimized(0, "", parenthesis, parenthesis, square, square));
        while (!q.isEmpty()) {
            CombinationOptimized s = q.peek();
            int state = s.state;
            if (s.value.length() == len) {
                System.out.println(s.value);
                q.pop();
                s = q.peek();
                s.state++;
            }
            switch (state) {
                case 0:

                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

            }

         /*   if (s.leftP > 0 && state == 0) {
                q.add(new CombinationOptimized(1, s.value + '(', s.leftP - 1, s.rightP, s.leftC, s.rightC));
            }
            if (s.leftC > 0) {
                q.add(new CombinationOptimized(s.value + '{', s.leftP, s.rightP, s.leftC - 1, s.rightC));
            }
            if (s.leftP < s.rightP && !s.value.endsWith("{")) {
                q.add(new CombinationOptimized(s.value + ')', s.leftP, s.rightP - 1, s.leftC, s.rightC));
            }
            if (s.leftC < s.rightC && !s.value.endsWith("(")) {
                q.add(new CombinationOptimized(s.value + '}', s.leftP, s.rightP, s.leftC, s.rightC - 1));
            }*/
        }
    }

    public static void main(String[] args) {
        printMultipleBrackets("([<{", ")]>}", new int[]{1, 1, 1, 1});
//        printBrackets(3);
//        printBrackets(3, 2);
//        printBrackets(2, 1);
//        printBracketsIterative(2, 1);
    }
}
