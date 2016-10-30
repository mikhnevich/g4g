package array;

/**
 * Created on 3/31/2014.
 *
 * http://stackoverflow.com/questions/14302636/how-do-i-calculate-the-k-nearest-numbers-to-the-median
 *
 You can find the median in O(node), w.g. using the O(node) nth_element algorithm.

 You loop through all elements substutiting each with a pair:
 <the absolute difference to the median>, <element's value>. Once more you do nth_element with n = k.
 after applying this algorithm you are guaranteed to have the k smallest elements in absolute difference
 first in the new array. You take their indices and DONE!

 Your algorithm, on the other hand uses sorting, and this makes it O(nlogn).

 EDIT: The requested example:

 Let the array be [14, 6, 7, 8, 10, 13, 21, 16, 23].

 After the step for finding the median it will be reordered to, say: [8, 7, 9, 10, 13, 16, 23, 14, 21], notice that the array is not sorted, but still the median (13) is exactly in the middle.
 Now let's do the pair substitution that got you confused: we create a new array of pairs: [<abs(14-13), 14>, <abs(6-13), 6>, <abs(7-13), 7>, <abs(8-13), 8>, <abs(10-13), 10>, <abs(13-13), 13>, <abs(21-13), 21>, <abs(16-13), 16>, <abs(23-13), 23>. Thus we obtain the array: [<1, 14>, <7, 6>, <6, 7>, <5, 8>, <3, 10>, <0, 13>, <8, 21>, <3, 16>, <10, 23>
 If e.g. k is 4 we make once more nth_element(using the first element of each pair for comparisons) and obtain: [<1, 14>, <3, 16>, <0, 13>, <3, 10>, <8, 21>, <7, 6>, <10, 23>, <6, 7>, <5, 8>] so the numbers you search for are the second elements of the first 4 pairs: 14, 16, 13 and 10

 */
public class _KnearestNumbers {
}
