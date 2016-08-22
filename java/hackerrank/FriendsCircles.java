package hackerrank;

import java.util.LinkedList;
import java.util.List;

/*

*/
public class FriendsCircles {

    /*
    The probleam can be solved by finding strongly-connected components of the friendship graph.
     Alternatively - also by using Uninon-Find data structure (not quite sure though, need time to review)
     */
    static int friendCircles(String[] friends) {
        if (friends == null || friends.length == 0) {
            return 0;
        }
        int result = 1;
        int n = friends.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new LinkedList<>();

        list.add(0, 0);
        visited[0] = true;
        while (!list.isEmpty()) {
            int current = list.remove(0);
            String f = friends[current];
            for (int i = 0; i < f.length(); i++) {
                if (!visited[i] && i != current && f.charAt(i) == 'Y') {
                    visited[i] = true;
                    list.add(i);
                }
            }
            if (list.isEmpty()) {
                boolean foundMore = false;
                int i = 1;
                while (i < visited.length && !foundMore) {
                    if (!visited[i]) {
                        list.add(i);
                        visited[i] = true;
                        foundMore = true;
                        result++;
                    }
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String[] friends = {"NNNNN","NNNNN","NNNNN","NNNNN","NNNNN"};
        String[] friends = {"YNNNN","NYNNN","NNYNN","NNNYN","NNNNY"};
//        String[] friends = {"YYNN","YYYN","NYYN","NNNY"};
        System.out.println(friendCircles(friends));
    }
}
