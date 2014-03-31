package array;

/**
 * Created on 3/30/2014.
 * http://stackoverflow.com/questions/1283231/given-an-array-of-numbers-find-out-if-3-of-them-add-up-to-0
 *
 * Given an array of numbers, find out if 3 of them add up to 0
 */
public class Sum3numbers {

    /*
    Sort the array // O(nlogn)

for each i from 1 to len(array) - 1
  iter = i + 1
  reviter = len(array) - 1
  while iter < reviter
    tmp = array[iter] + array[reviter] + array[i]
    if  tmp > 0
       reviter--
    else if tmp < 0
       iter++
    else
      return true
return false


     */

}
