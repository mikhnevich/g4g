package misc;

import java.util.Stack;

/*
LeetCode 439 - Ternary Expression Parser
http://bookshadow.com/weblog/2016/10/23/leetcode-ternary-expression-parser/

Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
Note:
The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
Example 1:
Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:
Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:
Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"

*/
public class TernaryExpression {

    public static String parseTernary(String s) {
        int idx = s.length() - 1;
        Stack<Character> stack = new Stack<>();
        while (idx >= 0) {
            char current = s.charAt(idx);
            if (current == '?') {
                Character result;
                if (s.charAt(idx - 1) == 'F') {
                    stack.pop();
                }
                result = stack.pop();
                stack.push(result);
                idx -= 2;
            } else if (current == ':') {
                idx--;
            } else {
                stack.push(current);
                idx--;
            }
        }
        return "" + stack.pop();
    }

    public static class Node {
        public final char value;
        public final Node left;
        public final Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            if (left == null) {
                return "" + value ;
            } else {
                return "" + value + "(" + left.toString() + ", " + right.toString() + ")";
            }
        }
    }

    // http://stackoverflow.com/questions/28487831/how-to-convert-a-ternary-expression-to-a-binary-tree-structure
    public static Node parseTernaryToTree(String s) {
        int idx = s.length() - 1;
        Stack<Node> stack = new Stack<>();
        while (idx >= 0) {
            char current = s.charAt(idx);
            if (current == '?') {
                Node left = stack.pop();
                Node right = stack.pop();
                stack.push(new Node(s.charAt(idx - 1), left, right));
                idx -= 2;
            } else if (current == ':') {
                idx--;
            } else {
                stack.push(new Node(current));
                idx--;
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(TernaryExpression.parseTernary("T?2:3")); // 2
        System.out.println(TernaryExpression.parseTernary("F?1:T?4:5")); // 4
        System.out.println(TernaryExpression.parseTernary("T?T?F:5:3")); // F
        System.out.println(TernaryExpression.parseTernaryToTree("a?b:c"));
        System.out.println(TernaryExpression.parseTernaryToTree("a?b?c:d:e"));
    }
}
