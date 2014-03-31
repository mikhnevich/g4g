package graph;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-72-campus-sde-1/
 *
 * There are n balls kept on a table and connected in random fashion but there is no cycle (no back edge). Write the code to select a ball such that after lifting the whole structure from that ball height will be minimum. (algo+code+ mathematical proof of correctness)
 *
 * Nonetheless the problem is a simple case of finding the diameter of an acyclic graph and then select the midpoint on the diameter. Now regarding the proof, it all boils down to the fact as to whether the BFS yields a node on the longest path or not. There are several papers which discuss the proof of the BFS and that should suffice.
 *
 */
public class MinHeight {
}
