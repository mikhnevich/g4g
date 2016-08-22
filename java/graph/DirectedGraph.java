package graph;

import java.util.*;

/*

*/
public class DirectedGraph implements Iterable<Integer> {

    private final Map<Integer, Map<Integer, Integer>> g = new HashMap<>();


    public int verticeCount() {
        return g.size();
    }

    public boolean addNode(int node) {
        if (g.containsKey(node))
            return false;

        g.put(node, new HashMap<Integer, Integer>());
        return true;
    }

    public void addEdge(int start, int dest, Integer length) {
        addNode(start);
        addNode(dest);
        g.get(start).put(dest, length);
    }


    public void removeEdge(int start, int dest) {
        g.get(start).remove(dest);
    }

    public Map<Integer, Integer> edgesFrom(int node) {
        Map<Integer, Integer> arcs = g.get(node);
        if (arcs == null)
            throw new IllegalArgumentException(node + " doesn't exist in the graph");

        return Collections.unmodifiableMap(arcs);
    }

    public Iterator<Integer> iterator() {
        return g.keySet().iterator();
    }
}