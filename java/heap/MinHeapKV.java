package heap;

import java.util.HashMap;
import java.util.Map;

public class MinHeapKV<K extends Comparable<K>, V> {
    public static class Tuple<K, V> {
        K key;
        V value;

        public Tuple(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public Tuple[] data;
    public int n = 0;
    private Map<K, Integer> location = new HashMap<>();

    public MinHeapKV(int capacity) {
        this.data = new Tuple[capacity];
        this.n = 0;
    }

/*
    public MinHeapKV(int[] data) {
        this(data.length);
        System.arraycopy(data, 0, this.data, 0, data.length);
        buildHeap();
    }
*/

    private void buildHeap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
        for (int i = 0; i < n; i++) {
            location.put((K) data[i].key, i);
        }
    }

    private void swap(int i, int j) {
        Tuple tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        location.put((K) tmp.key, j);
        location.put((K) data[i].key, i);
    }

    private void percolateDown(int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int min = i;

        if (left < n && ((K)data[left].key).compareTo((K)data[i].key) < 0) {
            min = left;
        }
        if (right < n && ((K)data[right].key).compareTo((K) data[min].key) < 0) {
            min = right;
        }
        if (min != i) {
            swap(i, min);
            percolateDown(min);
        }
    }

    public void decreaseKey(K oldVal, K newVal) {
        int i = location.get(oldVal);
        data[i].key = newVal;
        location.put(newVal, i);
        location.remove(oldVal);
        percolateUp(i);
    }

    public Tuple<K,V> min() {
        return data[0];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Tuple<K,V> deleteRoot() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty heap");
        }
        Tuple<K,V> root = min();
        location.remove(root.key);
        data[0] = data[n - 1];
        location.put((K)data[0].key, 0);
        n--;
        percolateDown(0);
        return root;
    }

    public void insert(K k, V v) {
        n = n + 1;
        if (n == data.length) {
            throw new IllegalStateException("Heap is full");
        }
        data[n] = new Tuple<K, V>(k, v);
        location.put(k, n);
        percolateUp(n);
    }

    private void percolateUp(int n) {
        while (n != 0) {
            int parent = (n - 1) / 2;
            if (((K)data[parent].key).compareTo((K)data[n].key) > 0) {
                swap(parent, n);
                n = parent;
            }
        }
    }

}
