package graph;

import java.util.*;

/**
 * Created by user2 on 2/11/14.
 */
public class BFS {
    private boolean visited[];
    private int edgeTo[];

    public Iterable<Integer> pathTo(Graph g, int source, int destination) {
        visited = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        Arrays.fill(edgeTo, -1);
        pathToHelper(g, source);

        int pt = destination;
        if (visited[pt]) {
            List<Integer> path = new ArrayList<>();
            while (pt != source) {
                path.add(pt);
                pt = edgeTo[pt];
            }
            path.add(source);
            Collections.reverse(path);
            return path;
        }
        return null;
    }

    private void pathToHelper(Graph g, int source) {
        visited[source] = true;
        for (Integer v : g.adj(source)) {
            if (!visited[v]) {
                edgeTo[v] = source;
                pathToHelper(g, v);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 7);
        g.addEdge(2, 4);
        g.addEdge(7, 9);
        g.addEdge(9, 8);
        g.addEdge(4, 6);
        g.addEdge(6, 8);
        g.addEdge(4, 5);

        BFS bfs = new BFS();
        Iterable<Integer> i = bfs.pathTo(g, 1, 8);
        if (i != null) {
            for (Integer v : i) {
                System.out.println(v);
            }
        }
    }
}
