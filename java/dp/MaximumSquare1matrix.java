package dp;

import array.ArrayUtils;

/**
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * Given a binary matrix, find out the maximum node square sub-matrix with all 1s.
 * <p>
 * For example, consider the below binary matrix.
 * <p>
 * <p>
 * 0  1  1  0  1
 * 1  1  0  1  0
 * 0  1  1  1  0
 * 1  1  1  1  0
 * 1  1  1  1  1
 * 0  0  0  0  0
 * The maximum square sub-matrix with all set bits is
 * <p>
 * 1  1  1
 * 1  1  1
 * 1  1  1
 *
 * Algorithm:
 Let the given binary matrix be M[R][C]. The idea of the algorithm is to construct an auxiliary node matrix S[][] in which each entry S[i][j] represents node of the square sub-matrix with all 1s including M[i][j] where M[i][j] is the rightmost and bottommost entry in sub-matrix.

 1) Construct a sum matrix S[R][C] for the given M[R][C].
 a)	Copy first row and first columns as it is from M[][] to S[][]
 b)	For other entries, use following expressions to construct S[][]
 If M[i][j] is 1 then
    S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
 Else //If M[i][j] is 0
    S[i][j] = 0
        2) Find the maximum entry in S[R][C]
        3) Using the value and coordinates of maximum entry in S[i], print
        sub-matrix of M[][]
 */
public class MaximumSquare1matrix {

    public static int maxSubMatrix(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int size = cols * rows;
        int[][] S = new int[rows][cols];

        S[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            S[0][i] = matrix[0][i];
        }
        for (int i = 1; i < rows; i++) {
            S[i][0] = matrix[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int topCell = S[i - 1][j];
                int leftCell = S[i][j - 1];
                int diagonalCell = S[i - 1][j - 1];
                if (matrix[i][j] == 1) {
                    S[i][j] = Math.min(topCell, Math.min(leftCell, diagonalCell)) + 1;
                } else if (topCell >= 1 && leftCell >= 1) {
                    S[i][j] = 0;
                }
            }
        }
        ArrayUtils.print(S);
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, S[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{0, 1, 1, 0, 1},
                new int[]{1, 1, 0, 1, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{1, 1, 1, 1, 0},
                new int[]{1, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0},
        };


        System.out.println(maxSubMatrix(matrix));
    }
}
