/**
 * Created by user @ 2/19/14 11:31 AM
 */
public class Sqrt {
    public static int sqrt(int n) {
        if (n == 1) {
            return 1;
        }
        int low = 0;
        int high = n / 2 + 1;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            int square = mid * mid;
            if (square == n) {
                return square;
            } else if (square < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
