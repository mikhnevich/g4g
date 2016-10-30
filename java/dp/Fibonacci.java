package dp;

import array.ArrayUtils;

/**
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * | 1 1 |^node  =  | F(node+1)  F(node)  |
 * | 1 0 |       |  F(node)  F(node-1) |
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[][] matrix = new int[][] {{1, 1}, {1, 0}};
        int[][] tmp = new int[][] {{1, 1}, {1, 0}};
        int k = n - 1;
        while (k > 1) {
             // todo WRONG MULTIPLICATION!
            if (k % 2 == 0) {
                tmp = multiply(tmp, tmp);
                k /= 2;
            } else {
                tmp = multiply(tmp, matrix);
                k--;
            }
        }
        return tmp[0][1];
    }




    private static int[][] multiply(int[][] tmp, int[][] matrix) {
        int[][] result = new int[2][2];
        result[0][0] = tmp[0][0] * matrix[0][0] + tmp[0][1] * matrix[1][0];
        result[0][1] = tmp[0][0] * matrix[0][1] + tmp[0][1] * matrix[1][1];
        result[1][0] = tmp[1][0] * matrix[0][0] + tmp[1][1] * matrix[1][0];
        result[1][1] = tmp[1][0] * matrix[0][1] + tmp[1][1] * matrix[1][1];
        ArrayUtils.print(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
