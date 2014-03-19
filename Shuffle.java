/**
 * Created by sm84878 @ 12/9/13 3:12 PM
 */
public class Shuffle {
    public static void main(String[] args)
    {
        int n = 4;

        int A[] = {1,3,5,7,2,4,6,8};

        //First loop indexed by i goes from 0 to n-1
        //Second loop changes its start index depending on
        //which element we need to rotate to the left side
        //The number of times the second loop executes is
        //decreased by one for every element we rotate to
        //the left side of the array
        for (int y = 0; y  < 2*n; y++) System.out.print(A[y]);
        System.out.println();

        for (int i = 0, q =1, k = n; i < n; i++, k++, q++)
        {
            for (int j = k; j > i + q; j--)
            {
                int tmp = A[j-1];
                A[j-1] = A[j];
                A[j] = tmp;
            }
            for (int y = 0; y  < 2*n; y++) System.out.print(A[y]);
            System.out.println();
        }

        for (int y = 0; y  < 2*n; y++) System.out.print(A[y]);
        System.out.println();
    }
}
