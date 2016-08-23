package graph;

/*
http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
NP-hard for generic graph.

The same idea as in ShortestPathDAG:

1) Initialize dist[] = {NINF, NINF, ….} and dist[s] = 0 where s is the source vertex. Here NINF means negative infinite.
2) Create a topological order of all vertices.
3) Do following for every vertex u in topological order.
………..Do following for every adjacent vertex v of u
………………if (dist[v] < dist[u] + weight(u, v)) ………………………dist[v] = dist[u] + weight(u, v)

*/
public class LongestPathDAG {
}
