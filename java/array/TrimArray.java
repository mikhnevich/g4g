package array;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-72-campus-sde-1/
 *
 * An array of integers is given, trim the array such that 2*min > max. min and max are the minimum and maximum elements of the array. You can remove elements either from start or from end of the array if above condition does not meet. No of removals should be minimum. (algo + code)
 For example a, b, c, d, e f are the elements of array, c is the min num and e is max no
 condition 2*c > e is true then we are done but if false then remove either from start i.e. a,b,c or from end i.e. e, f such that new min or max would satisfy the condition and removals should be minimum.

???
 def min_max(L):
    D = [[]]*len(L)
    for x in range(len(L)):
        D[x] = [0]*len(L)
    for x in range(len(L) - 1):
        if (2*L[x]) > L[x+1]: D[x][x+1] = 0
        else: D[x][x+1] = 1
    for x in range(2,len(L) + 1):
        for y in range(len(L) - x):
            if (2*L[y] > L[y+x]): D[y][y+x] = 0
            else: D[y][y+x] = min(D[y+1][y+x],D[y][y+x-1]) + 1
    return D[0][len(L) - 1]

    L = [3,6,7,11,13,25]
    i = min_max(L)
    print "Minimum removals to satisfy 2*min > max:", i

 Consider the following array.

 [3,6,7,11,13,25]

 Here, we can either remove 3 or 25. We don't know which one is better. We have to make a choice. Should we remove 3 or 25? Why try them both and choose the choice that yields minimum removals?

 So if we remove 3, we are left with a smaller sub-problem. Namely, find the min removals in the array [6,7,11,13,25]. If we remove 25, we are left with [3,6,7,11,13]. Two slightly smaller sub-problems. If you expand the sub-problems this way, you see that there are many overlapping sub-problems. Hence, we use DP.

 Define D(i,j) as the number of removals required to satisfy the given condition. We can easily compute this for all consecutive numbers, such as (6,7),(7,11) etc in our example.

 So D[x][x+1] = 0 if 2*L[x] > L[x+1] else 1

 Now, we move on to bigger sub-problems. Let us consider elements that differ by 2, that is, in our array [3,6,7,11,13,25], elements like

 (3,6,7), (6,7,11) and so on. Consider 3,6,7

 This is the sub-problem D[0][2]. According to our algorithm,

 If 2*L[x] > L[x+2], then D[x][x+2] = 0
 else D[0][2] = min(D[1][2], D[0,1]) + 1

 But we have already solved, D[1][2] and D[0][1].

 Similarly, we solve for all offsets, namely, D[0][3], D[1][4], if offset = 3, till offset = 5, namely D[0][5] (which is our final answer)

--------------------------
 Another approach:

 The algo goes as follows:

 - Find the indexes of both the min and max elements in the array.
 - If 2 * min > max is met then no trimming operations are required.
 - Otherwise, since removing any item that's not min or max won't change the output of 2 * min > max, we can derive two sub-problems: one that removes all items from left to the left-most index of either max or min + 1 and other that removes all items from right to the right-most index of either max or min + 1, i.e., in each sub-problem we removed either the min or max of the previous problem.
 - Trivial case is for an array with one element that doesn't require any trimming.

 If the problem were divided always in half, running time would be O(nlgn), but since we have cases that cause uneven partitions, e.g., sorted inputs, the worst case is quadratic.
 http://ideone.com/CnAVhC


 */
public class TrimArray {
}
