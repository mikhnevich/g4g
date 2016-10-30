package misc;

/**
 * Created on 3/30/2014.
 * http://www.geeksforgeeks.org/amazon-interview-set-68-for-sde-1/
 * Given node, find the smallest number for which product of the digits is node, if no such number exists, print -1
 Note: Digits can only be split as single digits, i.e., 132 can’t considered as 1 * 32 or 13 * 2, it would only be 1 * 3 * 2
 Eg. Answer for 36 would be 49

 http://stackoverflow.com/questions/21403720/algorithm-to-find-integer-such-that-product-of-its-digits-is-n

 */
public class ProductOfDigits {
    // If there exist prime divisor D of N such that D>=10 there is no solution
    /*

    Your approach is almost correct. The only remark is 6 = 2*3.
Optimal strategy is transforming many numbers to one number, like 2*2*2->8 and if there exist many variants to transform choose those one which gives the smallest number.

Perform these steps in the following order:

1) transform all (2,2,2) triples to 8.

2) (2,2)->4

3) (2,3)->6

4) (3,3)->9

Put all numbers into one array and sort it. Note that you have to also put into the result array numbers like 5,7, and remainders of 2 and 3.

Output sorted array - it will be answer to your question.

Example N = 96 = 2*2*2*2*3*3 = 8*6*3. Sort(8,6,3) - 3,6,8. Answer is 368.








for (d = 9; d > 1; d--)
while (node % d == 0) {
node /= d;
list.addDigit(d);
}
if (node != 1) print("no such number"); else print(reverse(list));


     */
}
