package binary_search;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-74/
 * Given a 2D matrix where every row is sorted, give the index of row which has maximum number of one’s
 */
public class SortedMatrixRowWithOnes {

    // assuming matrix is non-empty
    public static int row(int[][] a) {
        int max = 0;
        int M = a.length;
        int N = a[0].length;

        for (int i = 0; i < M; i++) {
            if (a[i][0] == 1 && a[i][N - 1] == 1) { // all elements == 1
                return N - 1;
            } else if (a[i][0] > 1 || a[i][N - 1] < 1) { // all greater or all less
                continue;
            } else {
                int left = BinarySearchUtils.binarySearch(a[i], BinarySearchUtils.equalOrGreater(1));
                int right = BinarySearchUtils.binarySearch(a[i], BinarySearchUtils.greater(1));
                if (right == -1) {
                    right = N;
                }
                max = Math.max(max, right - left);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(row(new int[][] {
                {0, 1, 2, 3, 4, 5},
                {0, 1, 1, 3, 4, 5},
                {0, 1, 2, 3, 4, 5},
        }));
    }

}
