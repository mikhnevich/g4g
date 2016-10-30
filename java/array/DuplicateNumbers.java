package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
Example:


Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

Idea is to go through numbers and make array[i] negative. Before changing sign - test - if already negative - then it's
 a duplicate.

 http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

*/
public class DuplicateNumbers {

    // mark negative
    public static Set<Integer> findDuplicates(int n[]) {
        Set<Integer> result = new HashSet<>();
        for (int i : n) {
            int absed = Math.abs(i) - 1;
            if (n[absed] < 0) {
                result.add(absed + 1);
            } else {
                n[absed] = -n[absed];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(DuplicateNumbers.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
