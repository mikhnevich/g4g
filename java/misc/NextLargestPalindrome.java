package misc;

/**
 * Created on 3/29/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-73-for-sde-1/
 * Find the next largest palindrome number of the given number. Algo + Code
 Ex: 120 -121, 123 – 131

 Let the integers' digit be abcdef. As number of digits are even we will divide it in two parts, abc and def.
 Now we reverse first part and it becomes cba. if cba is greater than def then abccba is the answer.
 If it is smaller we increment the first part and it becomes (abc+1)=suppose xyz, so the answer would be xyzzyx.
 Now let's check what happens when number of digits are odd. Let the integer be abcdefg. We divide it into 3 parts.
 abc, d, efg. if cba is greater than efg then the answer is abcdcba. If it is smaller then abcd is incremented by 1.
 Suppose (abcd+1)=wxyz. Then the answer is wxyzyxw.

 */
public class NextLargestPalindrome {
}
