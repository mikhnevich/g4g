package bit;

/*
http://www.geeksforgeeks.org/length-longest-consecutive-1s-binary-representation/

Naive Approach: One simple way would be to simply loop over the bits, and keep track of the number of consecutive set bits, and the maximum that this value has reached. In this approach, we need to convert it to binary (base-2) representation and then find and print the result.
Using Bit Magic: The idea is based on the concept that if we AND a bit sequence with a shifted version of itself, we’re effectively removing the trailing 1 from every sequence of consecutive 1s.
      11101111   (x)
    & 11011110   (x << 1)
    ----------
      11001110   (x & (x << 1))
        ^    ^
        |    |
   trailing 1 removed
So the operation x = (x & (x << 1)) reduces length of every sequence of 1s by one in binary representation of x. If we keep doing this operation in a loop, we end up with x = 0. The number of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s.

*/
public class LongestConsecutive1inBinary {
    public static int longestBinary1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n << 1);
        }
        return count;
    }
}
