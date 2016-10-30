package string;

/*
http://stackoverflow.com/questions/22737407/permutation-of-string-as-substring-of-another

Given a string A and another string B. Find whether any permutation of B exists as a substring of A.

For example,
if A = "encyclopedia"
if B="dep" then return true as ped is a permutation of dep and ped is a substring of A.

*/
public class StringPermutationsInString {
    /*
1. Build up in freqB[i] the number of times character i appears in B.
(E.g. in your example, freqB['d'] == freqB['e'] == freqB['p'] == 1,
and freqB[i] == 0 for all other characters i.)

2. For each length-m window of A, do the same, but storing them in freqA[], and then check whether,
for each character i, freqA[i] == freqB[i].

If so, you have a match. To move from the length-m window starting at position j to the next one,
you'll need to do --freqA[A[j]] and ++freqA[A[j+m]].
     */

    // upper case only!!!
    public static boolean solution1(String a, String b) {
        int[] freqB = new int[26];
        for (int i = 0; i < b.length(); i++) {
            freqB[b.charAt(i) - 65]++;
        }
        return true;
    }

/*
Building a little on the algorithm presented by j_random_hacker in comments, it is possible to find
the match in O(|A|+|B|), as follows: (Note: throughout, we use |A| to mean "the length of A".)

1. Create an integer array count whose domain is the size of the alphabet, initialized to all 0s.
2. Set distance to 0
3. For each character B[i] in B:
 - Decrement count[B[i]].
 - If the previous count of count[B[i]] was 0, also increment distance.
4. For each character A[i] in A:
 - Increment count[A[i]]
 - If i is greater than |B| decrement count[A[i-|B|]].
For each of the two count values modified, if the previous value was 0, then increment distance and if the new value is 0 then decrement distance.
If the result is that distance is 0 then a match has been found.

Note: The algorithm presented by j_random_hacker is also O(|A|+|B]) because the cost of comparing freqA with freqB
is O(|alphabet|), which is a constant. However, the above algorithm reduces the comparison cost to a small constant.
In addition, it is theoretically possible to make this work even if the alphabet is not a constant size by using the
standard trick for uninitialized arrays.



I like it! So distance is the number of characters whose counts disagree in the substrings (from A and from B)
being considered at the moment. And I think it's fair to make alphabet size a parameter k, so that my algorithm is
O(k|A| + |B|) and yours is O(|A| + |B| + k).

http://www.dsalgo.com/2013/03/permutation-of-string-as-substring-of.html

http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/


 */
/*
    public static boolean solution2(String a, String b) {
        int[] count = new int[26];
        int distance = 0;
        for (int i = 0; i < b.length(); i++) {
            int idx = b.charAt(i) - 65;
            if (count[idx] == 0) {
                distance++;
            }
            count[idx]--;
        }
        for (int i = 0; i < a.length(); i++) {
            int idx = a.charAt(i) - 65;
            count[idx]++;
            if (i >= b.length()) {
                count[a.charAt(i - b.length()) - 65]--;
            }
            if (countA[a.charAt(i) - 65] == 0) {
                distance++;
            }
        }
        return true;
    }
*/

}

