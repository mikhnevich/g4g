package array;


import java.util.Arrays;

public class CoinAdjacency {

    int solution(int[] A) {
        System.out.println(Arrays.toString(A));
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        System.out.println("1st result: " + result);
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            System.out.println("count: " + count);
            r = Math.max(r, count);
        }
        System.out.println("Final result: " + (result + r));
        return result + r;
    }


    public static void main(String[] args) {
        CoinAdjacency ca = new CoinAdjacency();
        final int[] a = {0, 0, 1, 1, 0, 0};
        ca.solution(a);
    }

}
