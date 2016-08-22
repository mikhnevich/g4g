package heap;

import java.util.HashMap;
import java.util.Map;

public class MinHeap {
    public int[] data;
    public int n = 0;
    private Map<Integer, Integer> location = new HashMap<>();

    public MinHeap(int capacity) {
        this.data = new int[capacity];
        this.n = 0;
    }

    public MinHeap(int[] data) {
        this(data.length);
        System.arraycopy(data, 0, this.data, 0, data.length);
        buildHeap();
    }

    private void buildHeap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
        for (int i = 0; i < n; i++) {
            location.put(data[i], i);
        }
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        location.put(tmp, j);
        location.put(data[i], i);
    }

    private void percolateDown(int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int min = i;

        if (left < n && data[left] < data[i]) {
            min = left;
        }
        if (right < n && data[right] < min) {
            min = right;
        }
        if (min != i) {
            swap(i, min);
            percolateDown(min);
        }
    }

    public void decrease(int oldVal, int newVal) {
        int i = location.get(oldVal);
        data[i] = newVal;
        location.put(newVal, i);
        location.remove(oldVal);
        percolateUp(i);
    }

    public int min() {
        return data[0];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int deleteRoot() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty heap");
        }
        int root = min();
        location.remove(root);
        data[0] = data[n - 1];
        location.put(data[0], 0);
        n--;
        percolateDown(0);
        return root;
    }

    public void insert(int e) {
        n = n + 1;
        if (n == data.length) {
            throw new IllegalStateException("Heap is full");
        }
        data[n] = e;
        location.put(e, n);
        percolateUp(n);
    }

    private void percolateUp(int n) {
        while (n != 0) {
            int parent = (n - 1) / 2;
            if (data[parent] > data[n]) {
                swap(parent, n);
                n = parent;
            }
        }
    }

}
