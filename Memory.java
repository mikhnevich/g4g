/**
 * Created by sm84878 @ 3/13/14 3:04 PM
 */
public class Memory {
    private final int capacity;
    private final Node[] data;
    private int freeHead = 0;

    public Memory(int capacity) {
        this.capacity = capacity;
        data = new Node[capacity];
        for (int i = 0; i < capacity - 1; i++) {
            data[i] = new Node(i + 1);
        }
        data[capacity - 1] = new Node(-1);
    }

    private static class Node {
        int next;
        boolean free = true;

        private Node(int next) {
            this.next = next;
        }
    }

    public int allocate() {
        if (freeHead < 0) {
            throw new IllegalStateException("OutOfMemory");
        }
        int allocated = freeHead;
        data[freeHead].free = false;
        freeHead = data[freeHead].next;
        return allocated;
    }

    public void free(int i) {
        data[i].next = freeHead;
        data[i].free = true;
        freeHead = i;
    }

    public boolean isFree(int i) {
        return data[i].free;
    }



}
