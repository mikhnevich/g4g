package concurrent;

/**
 * Created by sm84878 @ 2/20/14 4:58 PM
 */
public class Semaphore {
    private final int capacity;
    private int count;

    public Semaphore(int capacity) {
        this.capacity = capacity;
        this.count = capacity;
    }

    public synchronized void acquire() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        count--;
    }

    public synchronized void release() {
        count++;
        if (count > capacity) {
            count = capacity;
        }
        notifyAll();
    }


}
