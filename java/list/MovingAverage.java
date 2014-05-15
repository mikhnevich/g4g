package list;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sm84878 @ 4/28/2014 09:44
 */
public class MovingAverage {
    private final List<Integer> list;
    private final int count;
    private int sum = 0;

    public MovingAverage(int count) {
        this.count = count;
        list = new LinkedList<>();
    }

    public float getAverage() {
        return ((float) sum) / list.size();

    }

    public void add(int value) {
        if (list.size() < count) {
            list.add(value);
            sum += value;
        } else {
            list.add(value);
            sum += value;
            sum -= list.remove(0);
        }
    }
}
