package misc;

public class Addition {

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1 ;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static int addRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return addRecursive(a ^ b, (a & b) << 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(add(5, 12));
        System.out.println(addRecursive(5, 12));
    }
}
