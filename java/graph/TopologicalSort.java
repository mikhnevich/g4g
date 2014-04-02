package graph;

import java.util.*;

/**
 * Created @ 4/2/2014
 */
public class TopologicalSort {

    public static List<Integer> toposort(DiGraph g) {
        Stack<Integer> topSortStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < g.getV(); i++) {
            if (!visited.contains(i)) {
                toposort(g, i, visited, topSortStack);
            }
        }

        List<Integer> q = new ArrayList<>();
        while (!topSortStack.isEmpty()) {
            q.add(topSortStack.pop());
        }
        return q;
    }

    private static void toposort(DiGraph g, int vertex, Set<Integer> visited, Stack<Integer> q) {
        visited.add(vertex);
        for (int v : g.adj(vertex)) {
            if (!visited.contains(v)) {
                toposort(g, v, visited, q);
            }
        }
        q.push(vertex);
    }

    public static List<Integer> toposortIterative(DiGraph g) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> topSortStack = new Stack<>();
        Set<Integer> sorted = new HashSet<>();
        for (int i = 0; i < g.getV(); i++) {
            if (!visited.contains(i)) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int s = stack.peek();
                    if (!visited.contains(s)) {
                        visited.add(s);
                        for (int v : g.adj(s)) {
                            if (!visited.contains(v)) {
                                stack.push(v);
                            }
                        }
                    } else {
                        stack.pop();
                        if (!sorted.contains(s)) {
                            sorted.add(s);
                            topSortStack.push(s);
                        }
                    }
                }
            }
        }
        List<Integer> q = new ArrayList<>();
        while (!topSortStack.isEmpty()) {
            q.add(topSortStack.pop());
        }
        return q;
    }

    public static void main(String[] args) {
        DiGraph g = new DiGraph(new In("tiny2G.txt"));
        System.out.println(toposort(g));
        System.out.println(toposortIterative(g));
    }
}
