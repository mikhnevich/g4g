package trie;

/**
 * Created by user @ 2/24/14 11:40 AM
 */
public class RadixTreeNode<T> {
    String key;
    T value;
    boolean real;
    RadixTreeNode<T> next;
    RadixTreeNode<T> firstChild;
    int childrenSize;
}
