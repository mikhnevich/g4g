package concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user @ 2/20/14 5:39 PM
 */
public class ReadWriteLock {
    private Map<Thread, Integer> readers = new HashMap<>();
    private Thread writer = null;
    private int writerRequestPending = 0;

    public ReadWriteLock() {
    }

    public synchronized void lockRead() throws InterruptedException {
        Integer count = readers.get(Thread.currentThread());
        while (writer != null && writerRequestPending > 0) {
            wait();
        }
        if (count == null) {
            count = 1;
        } else {
            count = count + 1;
        }
        readers.put(Thread.currentThread(), count);
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writerRequestPending++;
        if (writer != Thread.currentThread()) {
           /* while (writer != null && readers > 0) {
                wait();
            }*/
            writer = Thread.currentThread();
            notifyAll();
        }
        writerRequestPending--;
    }

    public synchronized void unlockRead() {
//        readers--;
        notifyAll();
    }

    public synchronized void unlockWrite() {
        if (writer != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        }
        writer = null;
        notifyAll();
    }
}
