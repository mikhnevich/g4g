package graph;

import java.util.*;

/**
 * Created @ 4/2/2014
 */
public class DFS {
    public static List<Integer> dfs(Graph g) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.getV(); i++) {
            if (!visited.contains(i)) {
                dfs(g, i, visited, q);
            }
        }
        return q;
    }

    private static void dfs(Graph g, int source, Set<Integer> visited, List<Integer> q) {
        visited.add(source);
        q.add(source);
        for (int v : g.adj(source)) {
            if (!visited.contains(v)) {
                dfs(g, v, visited, q);
            }
        }
    }

    /*
    DFS(G,v)   ( v is the vertex where the search starts )
         Stack S := {};   ( start with an empty stack )
         for each vertex u, set visited[u] := false;
         push S, v;
         while (S is not empty) do
            u := pop S;
            if (not visited[u]) then
               visited[u] := true;
               for each unvisited neighbour w of u
                  push S, w;
            end if
         end while
      END DFS()

     */
    public static List<Integer> dfsIterative(Graph g) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.getV(); i++) {
            if (!visited.contains(i)) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int s = stack.pop();
                    if (!visited.contains(s)) {
                        q.add(s);
                        visited.add(s);
                        for (int v : g.adj(s)) {
                            if (!visited.contains(v)) {
                                stack.push(v);
                            }
                        }
                    }
                }
            }
        }
        return q;
    }


    public static void main(String[] args) {
        Graph g = new Graph(new In("tinyG.txt"));
        System.out.println(dfs(g));
        System.out.println(dfsIterative(g));
    }

}
