package array;

// https://www.careercup.com/question?id=12708671
/*
You are given an unsorted array with both positive and negative elements. You have to find the smallest positive
number missing from the array in O(n) time using constant extra space.
Eg:
Input = {2, 3, 7, 6, 8, -1, -10, 15}
Output = 1

Input = { 2, 3, -7, 6, 8, 1, -10, 15 }
Output = 4


I am assuming that we need to find smallest non-negative integer in the array, it can easily be extended to
smallest positive integer as well.

I am basically use the array itself as the hash-table. Since, solution would be in the range [0,sizeOfArray-1],
the array itself would suffice to find the solution.

Basically, while going through the array, I am moving the element to its correct location in array based on the
value as the hash-key itself. So, 2 -> index 2, 5 -> index 5, and so on. For elements, which are not in range
[0,sizeOfArray-1], I do not care, as they cannot be the answer.

 */
public class MinMissingPositive {

    public static void main(String[] args) {
        int A[] = {2, 3, 7, -6, 0, 1, 4, 5};
        int size = 8;
        int previousValue = -1;
        int currentIndex = 0;
        int currentValue = A[currentIndex];
        int nextIndex = currentIndex + 1;
        boolean isChaining = false;

        while (nextIndex < size) {
            if (currentValue != currentIndex &&
                    currentValue > -1 &&
                    currentValue < size) {
                isChaining = true;
                A[currentIndex] = previousValue;
                previousValue = currentValue;
                currentIndex = currentValue;
                currentValue = A[currentIndex];
            } else {
                if (isChaining) {
                    A[currentIndex] = previousValue;
                    isChaining = false;
                }

                currentIndex = nextIndex++;
                previousValue = -1;
                currentValue = A[currentIndex];
            }
        }

        int x;
        for (x = 0; x < size; x++) {
            if (A[x] != x) {
                System.out.println("\n" + x);
                break;
            }
        }
        if (x == size) {
            System.out.println("\n" + x);
        }

    }
}
