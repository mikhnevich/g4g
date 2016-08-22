package graph;

import heap.MinHeapKV;

import java.util.Arrays;

/*
relevant links:
https://gabormakrai.wordpress.com/2015/02/11/experimenting-with-dijkstras-algorithm/

*/
public class Dijkstra {
    private int distance[];
    private int previous[];
    private MinHeapKV<Integer, String> q;

    public Dijkstra(DirectedGraph g, int start) {
        distance = new int[g.verticeCount()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for (int i = 0; i < previous.length; i++) {
            previous[i] = i;
        }
        /*for (int i = 0; i < distance.length; i++) {
            q.insert(i, distance[i]);
        }
*/
    }
}
