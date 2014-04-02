package tree;

/**
 * http://www.geeksforgeeks.org/g-fact-18/
 * Total number of possible Binary Search Trees with n different keys = Catalan number Cn = (2n)!/(n+1)!*n!
 */
public class CatalanNumber {

    public static int catalan(int n) {
        if (n <= 1) {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
//            System.out.println("recursion " + i + ", " + (n - i - 1));
            total += catalan(i) * catalan(n - i - 1);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(catalan(1));
        System.out.println(catalan(2));
        System.out.println(catalan(3));
        System.out.println(catalan(4));
        System.out.println(catalan(5));
    }
}
