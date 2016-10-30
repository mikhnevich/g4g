package array;

/**
 * Created on 3/30/2014.
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 *
 *
 * You are given an array of node+2 elements. All elements of the array are in range 1 to node. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

 For example, array = {4, 2, 4, 5, 2, 3, 1} and node = 5

 The above array has node + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.

 */
public class Find2Repeating {

/*
Method 4 (Use XOR)
Thanks to neophyte for suggesting this method.
The approach used here is similar to method 2 of this post.
Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from 1 to node, then the result is X xor Y.
The 1’s in binary representation of X xor Y is corresponding to the different bits between X and Y. Suppose that the kth bit of X xor Y is 1, we can xor all the elements in the array and all integers from 1 to node, whose kth bits are 1. The result will be one of X and Y.

void printRepeating(int arr[], int node)
{
  int xor = arr[0]; // Will hold xor of all elements
int set_bit_no;  // Will have only single set bit of xor
    int i;
    int node = node - 2;
    int x = 0, y = 0;

  // Get the xor of all elements in arr[] and {1, 2 .. node}
    for(i = 1; i < node; i++)
    xor ^= arr[i];
    for(i = 1; i <= node; i++)
    xor ^= i;

  // Get the rightmost set bit in set_bit_no
    set_bit_no = xor & ~(xor-1);

  // Now divide elements in two sets by comparing rightmost set
  // bit of xor with bit at same position in each element.
    for(i = 0; i < node; i++)
    {
        if(arr[i] & set_bit_no)
            x = x ^ arr[i]; //XOR of first set in arr[]
        else
            y = y ^ arr[i]; //XOR of second set in arr[]
    }
    for(i = 1; i <= node; i++)
    {
        if(i & set_bit_no)
            x = x ^ i; //XOR of first set in arr[] and {1, 2, ...node }
        else
            y = y ^ i; //XOR of second set in arr[] and {1, 2, ...node }
    }

    printf("\node The two repeating elements are %d & %d ", x, y);
}
 */


    /*
    Method 5 (Use array elements as index)
Thanks to Manish K. Aasawat for suggesting this method.

Traverse the array. Do following for every index i of A[].
{
check for sign of A[abs(A[i])] ;
if positive then
   make it negative by   A[abs(A[i])]=-A[abs(A[i])];
else  // i.e., A[abs(A[i])] is negative
   this   element (ith element of list) is a repetition
}
Example: A[] =  {1, 1, 2, 3, 2}
i=0;
Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative.
Array now becomes {1, -1, 2, 3, 2}

i=1;
Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

i=2;
Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
Array now becomes {1, -1, -2, 3, 2}

i=3;
Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative.
Array now becomes {1, -1, -2, -3, 2}

i=4;
Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.
Note that this method modifies the original array and may not be a recommended method if we are not allowed to modify the array.
//todo Method 5 actually works for any number of repeats. Also it needs special 0 handling
     */
}

