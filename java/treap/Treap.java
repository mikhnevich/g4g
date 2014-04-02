package treap;

/*
http://habrahabr.ru/post/101818/

 */
import java.util.Random;

public class Treap {
    private final Random random = new Random();
    public final int value;
    public final int priority;
    public final Treap left;
    public final Treap right;
    public int size = 1;


    public Treap(int value, int priority) {
        this(value, priority, null, null);
    }

    public Treap(int value, int priority, Treap left, Treap right) {
        this.value = value;
        this.priority = priority;
        this.left = left;
        this.right = right;
        this.size = sizeOf(left) + sizeOf(right) + 1;
    }

    public static Treap merge(Treap L, Treap R) {
        if (L == null) {
            return R;
        }
        if (R == null) {
            return L;
        }
        if (L.priority > R.priority) {
            Treap newR = merge(L.right, R);
            return new Treap(L.value, L.priority, L.left, newR);
        } else {
            Treap newL = merge(L, R.left);
            return new Treap(R.value, R.priority, newL, R.right);
        }
    }

    public Treap add(int x) {
        Treap[] tmp = split(x);
        Treap newNode = new Treap(x, random.nextInt());
        return merge(merge(tmp[0], newNode), tmp[1]);
    }

    public Treap delete(int x) {
        Treap[] less = split(x - 1);
        Treap[] greater = less[1].split(x);
        return merge(less[0], greater[1]);
    }

    public Treap[] split(int splitBy) {
        Treap[] result = new Treap[2];
        if (value <= splitBy) {
            Treap[] t = new Treap[2];
            if (right != null) {
                t = right.split(splitBy);
                result[1] = t[1];
            }
            result[0] = new Treap(value, priority, left, t[0]);
        } else {
            Treap[] t = new Treap[2];
            if (left != null) {
                t = left.split(splitBy);
                result[0] = t[0];
            }
            result[1] = new Treap(value, priority, t[1], right);
        }
        return result;
    }

    private int sizeOf(Treap treap) {
        return treap != null ? treap.size : 0;
    }

    public Integer kStatistics(int k) {
        int sL = sizeOf(left);
        if (sL == k) {
            return value;
        } else if (sL > k) {
            return left.kStatistics(k);
        } else {
            return right.kStatistics(k - sL - 1);
        }
    }

    public static void main(String[] args) {
        Treap treap = new Treap(10, 8,
                new Treap(8, 7,
                        new Treap(4, 5,
                                new Treap(1, 3),
                                new Treap(6, 2)
                        ),
                        null
                ),
                new Treap(14, 6,
                        new Treap(11, 4,
                                null,
                                new Treap(13, 1)
                        ),
                        new Treap(16, 0)
                )
        );
        TreapUtils.printTreap(treap);
        Treap[] t = treap.split(8);
        System.out.println(t[0].size);
        System.out.println(t[1].size);
        Treap t2 = merge(t[0], t[1]);
        System.out.println(t2.size);
    }
}
