package misc;

/**
 * Created on 3/28/2014.
 */
public class Power {
    public static long power(int n, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return n;
        }
        if (power % 2 == 0) {
            return power(n * n, power / 2);
        } else {
            return n * power(n * n, (power - 1) / 2);
        }
    }

    public static long powerIterative(int n, int power) {
        long result = 1;
        while (power != 0) {
            if (power % 2 == 1) {
                result *= n;
                power--;
            } else {
                n *= n;
                power /= 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 5;
        System.out.println(power(n, k));
        System.out.println(powerIterative(n, k));
    }
}
