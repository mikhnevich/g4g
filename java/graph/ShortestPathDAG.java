package graph;

/*
http://www.utdallas.edu/~sizheng/CS4349.d/l-notes.d/L17.pdf
http://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/

Do topological sort (V+E), then process in the order and update adjacent vertices according to the edge weight (V+E).

1) Initialize dist[] = {INF, INF, ….} and dist[s] = 0 where s is the source vertex.
2) Create a toplogical order of all vertices.
3) Do following for every vertex u in topological order.
………..Do following for every adjacent vertex v of u
………………if (dist[v] > dist[u] + weight(u, v))
………………………dist[v] = dist[u] + weight(u, v)


*/
public class ShortestPathDAG {
}
