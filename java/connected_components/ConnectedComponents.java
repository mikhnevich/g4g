package connected_components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        Set<Integer> visited = new HashSet<>(adj.length);
        for (int i = 0; i < adj.length; i++) {
            if (!visited.contains(i)) {
                result++;
                explore(i, visited, adj);
            }
        }

        return result;
    }

    private static void explore(Integer v, Set<Integer> visited, ArrayList<Integer>[] adj) {
        visited.add(v);
        for (int i = 0; i < adj[v].size(); i++) {
            int w = adj[v].get(i);
            if (!visited.contains(w)) {
                explore(w, visited, adj);
            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

