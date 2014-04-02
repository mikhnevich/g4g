package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-74/
 *
 * 2) given a number n, print all pairs of valid parenthesis

 eg: n=2 -> (()), ()()
 n=3 -> ()()(), (())(),()(()), ((()))

 */
public class Brackets {
    public static void printBrackets(int parenthesis, int square) {
        char[] value = new char[parenthesis*2 + square*2];
        Arrays.fill(value, ' ');
        printBrackets(value, 0, parenthesis, parenthesis, square, square);
    }

    private static void printBrackets(char[] value, int index, int leftP, int rightP, int leftC, int rightC) {
        if (leftP == 0 && rightP == 0 && leftC == 0 && rightC == 0) {
            System.out.println(value);
            return;
        }
        if (leftP > 0) {
            value[index] = '(';
            printBrackets(value, index + 1, leftP - 1, rightP, leftC, rightC);
        }
        if (leftC > 0) {
            value[index] = '{';
            printBrackets(value, index + 1, leftP, rightP, leftC - 1, rightC);
        }
        if (leftC < rightC  && value[index - 1] != '(') {
            value[index] = '}';
            printBrackets(value, index + 1, leftP, rightP, leftC, rightC - 1);
        }
        if (leftP < rightP && value[index - 1] != '{') {
            value[index] = ')';
            printBrackets(value, index + 1, leftP, rightP - 1, leftC, rightC);
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
    }
    private static void printBracketsRecursive(int parenthesis, int square) {
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
            if (s.leftP < s.rightP && !s.value.endsWith("{")) {
                q.add(new Combination(s.value + ')', s.leftP, s.rightP - 1, s.leftC, s.rightC));
            }
            if (s.leftC < s.rightC && !s.value.endsWith("(")) {
                q.add(new Combination(s.value + '}', s.leftP, s.rightP, s.leftC, s.rightC - 1));
            }
        }
    }

    public static void main(String[] args) {
//        printBrackets(1, 2);
        printBracketsRecursive(2, 1);
    }
}
