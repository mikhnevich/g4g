package heap;

/**
 * Created @ 3/31/2014
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …

 After reading 1st element of stream - 5 -> median - 5
 After reading 2nd element of stream - 5, 15 -> median - 10
 After reading 3rd element of stream - 5, 15, 1 -> median - 5
 After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 Making it clear, when the input n is odd, we take the middle element of sorted data.
 If the input n is even, we pick average of middle two elements in sorted stream.

 */
public class RunningMedian {
    // Minheap and maxheap
    // min element in minheap > max element in maxheap.
    // keep their size == (+-1)
}
