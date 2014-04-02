package dp;

/**
 * Created by user2 on 2/16/14.
 */
public class Stairs {

    public static int count(int stairs) {
        if (stairs < 0) {
            return 0;
        }
        if (stairs == 0) {
            return 1;
        }
        return count(stairs - 1) + count(stairs - 2) + count(stairs - 3);
    }

    public static int cents(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return cents(n - 1) + cents(n - 5) + cents(n - 10) + cents(n - 25);
    }


    public static void main(String[] args) {
        System.out.println(cents(9));
        System.out.println(cents(5));
        System.out.println(cents(4));
    }
}
