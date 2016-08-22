package dp;

import java.util.Arrays;

/**
 * Created by user2 on 2/3/14.
 */
public class RodCutting {
    private int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    private int[] r = new int[price.length + 1];

    public RodCutting() {
        Arrays.fill(r, -1);
    }

    private int cut(int length) {
        return cut(length, 0);
    }


    private int cutRecursive(int length) {
        return cutRecursive(length, 0);
    }

    private int cutRecursive(int length, int pricePerCut) {
        if (length == 0) return 0;
        int result = 0;
        for (int i = 1; i <= price.length; i++) {
            if (length - i >= 0) {
                int k = price[i-1] + cutRecursive(length - i, pricePerCut);
                result = Integer.max(result, k);
            }
        }
        return result;
    }

    private int cut(int length, int pricePerCut) {
        if (r[length] >= 0) {
            return r[length];
        }
        int q;
        if (length == 0) {
            q = 0;
        } else {
            q = -1;
            for (int i = 1; i <= length; i++) {
                q = Math.max(q, price[i - 1] + cut(length - i, pricePerCut));
            }
        }
        r[length] = q;
        return q;
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
//        System.out.println(rc.cut(1));
//        System.out.println(rc.cut(2));
//        System.out.println(rc.cut(3));
//        System.out.println(rc.cut(30));
        System.out.println(rc.cutRecursive(20));
//        System.out.println(rc.cut(5));
//        System.out.println(rc.cut(6));
//        System.out.println(rc.cut(7));
//        System.out.println(rc.cut(8));
//        System.out.println(rc.cut(9));
//        System.out.println(rc.cut(10));
    }
}
