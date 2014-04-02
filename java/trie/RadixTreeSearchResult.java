package trie;

import java.util.LinkedList;

/**
 * Created by user @ 2/24/14 1:05 PM
 */
public class RadixTreeSearchResult<T> {
    public LinkedList<RadixTreeNode<T>> matchList;
    public LinkedList<String> matchFullKeyList;
    public RadixTreeNode<T> partialMatch;
    public int lastTryNumMatchingChars;
    public boolean exactMatch;
    public RadixTreeNode<T> lastTry;
    public String lastMatchKey;
    public RadixTreeNode<T> previousNode;
    public boolean belongsBefore;
    public RadixTreeNode<T> parent;

    protected  RadixTreeSearchResult(){
        matchList = new LinkedList<RadixTreeNode<T>>();
        matchFullKeyList = new LinkedList<String>();
        exactMatch = false;
    }
}
