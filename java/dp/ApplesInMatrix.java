package dp;

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=dynProg&module=Static
  A table composed of N x M cells, each having a certain quantity of apples, is given.
 You start from the upper-left corner. At each step you can go down or right one cell.
 Find the maximum number of apples you can collect.

 */
public class ApplesInMatrix {

    public static int appleCount(int[] table, int rows, int cols) {
        int[] solution = new int[rows*cols];
        solution[0] = table[0];
        for (int i = 1; i < cols; i++) {
            solution[i] += solution[i-1];
        }
        for (int i = 1; i < rows; i++) {
            solution[i*cols] += solution[(i-1)*cols];
        }
        for (int i = 2; i < rows; i++) {
            for (int j = 2; j < cols; j++) {
                int topCell = solution[(i - 1)*cols + j];
                int leftCell = solution[i*cols + j - 1];
                solution[i*cols + j] += Math.max(topCell, leftCell);
            }
        }
        return solution[rows*cols - 1];
    }

    public ApplesInMatrix() {
    }
}
