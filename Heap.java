/**
 * Created by sm84878 @ 2/19/14 11:06 AM
 */
public class Heap<T extends Comparable<? super T>> {
/*
    private static final int DEFAULT_SIZE = 16;
    private T[] array;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public Heap(int[] array) {
        this(array.length);
        System.arraycopy(array, 0, this.array, 1, array.length);
        buildHeap();
    }

    private void buildHeap() {
        for (int i = size / 2; i >= 0)
    }


    private int parent(int i) {
        if (i == 0) {
            return 0;
        }
        return i/2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    public void add(T value) {
        if (size <= array.length) {
            resize();
        }
        int idx = size;
        size++;
        array[idx] = value;
        percolateUp(idx);
    }

    private void resize() {
        int newCapacity = size*2;
        T[] newArray = (T[]) new Comparable[newCapacity + 1];
        System.arraycopy(array, 0, newArray, 1, size);
        array = newArray;
        capacity = newCapacity;
    }

    private void percolateUp(int i) {
        int position = i;
        T value = array[position];
        while (position > 0) {
            int parent = parent(position);
            if (array[position].compareTo(array[parent]) > 0) {
                array[position] = array[parent];
            } else {
                break;
            }
            position = parent;
        }
        array[position] = value;
    }

    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    public void deleteMax() {
        if (!isEmpty()) {
            array[0] = array[size];
            size--;
            percolateDown(0);
        }
    }

    private void percolateDown(int i) {
        int position = i;
        T value = array[position];
        while (position * 2 < size) {
            int right = right(position);
        }

            if (array[position].compareTo(array[right]) < 0) {
                array[position] = array[right];
            } else {
                break;
            }
            position = right;
        }
        array[position] = value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
*/
}
