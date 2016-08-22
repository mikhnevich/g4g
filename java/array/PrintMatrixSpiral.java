package array;

/*
Print a matrix in spiral fashion.
We will first print the periphery of the matrix by the help of 4 for loops.
Then recursively call this function to do the same thing with inner concentric rectangles.
We will pass this information by a variable named depth, which will tell how many layers from outside should be ignored.
*/
public class PrintMatrixSpiral {
    private static void printSpiral(int[][] matrix) {

    }

    public static void main(String[] args) {
        int[][] matrix = {
                        {3, 4, 5, 6, 2, 5},
                        {2, 4, 6, 2, 5, 7},
                        {2, 5, 7, 8, 9, 3},
                        {2, 4, 7, 3, 5, 8},
                        {6, 4, 7, 3, 5, 7}};

        printSpiral(matrix);
    }

}
