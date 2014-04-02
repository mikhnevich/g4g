package misc;

/**
 * Created on 3/30/2014.
 * http://shashank7s.blogspot.com/2011/08/division-operation-without-using.html
 */
public class Division {

    /*int div(int a, int b) {
        if (b == 0) {
            return -1;
        }
        if (a < b) {
            return 0;
        }
        int q = 1, t = d, d = 1;
        while (t < a) {
            d = t;
            t = t << 2;
            q = q << 1;
        }
        while (d + b < a) {
            d = d + b;
            ++q;
        }
        printf("%d / %d = %d , remainder %d\n", a, b, q, a - d);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(div(20, 3));
    }*/
}
