package dp;

/**
 * http://www.geeksforgeeks.org/ugly-numbers/
 * <p>
 * Ugly Numbers
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 * shows the first 11 ugly numbers. By convention, 1 is included.
 * Write a program to find and print the 150′th ugly number.
 */
public class UglyNumbers {
    public static int findUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int[] numbers = new int[n];
        numbers[0] = 1;
        int currentIdx = 0;
        while (numbers[n - 1] == 0) {
            int by2 = findNextBy(numbers, currentIdx, 2);
            int by3 = findNextBy(numbers, currentIdx, 3);
            int by5 = findNextBy(numbers, currentIdx, 5);
            int nextNumber = Math.min(by2, Math.min(by3, by5));
            currentIdx++;
            numbers[currentIdx] = nextNumber;
        }
        return numbers[n - 1];
    }

    private static int findNextBy(int[] numbers, int currentIdx, int multiplier) {
        int currentNumber = numbers[currentIdx];
        int i = currentIdx;
        while (i >= 0 && numbers[i] * multiplier > currentNumber) {
            i--;
        }

        return numbers[i + 1] * multiplier;
    }

    public static int findUglyNumber2(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 1;
        int current = 1;
        while (count != n) {
            current++;
            int t = current;
            while (t % 2 == 0) {
                t = t / 2;
            }
            while (t % 3 == 0) {
                t = t / 3;
            }
            while (t % 5 == 0) {
                t = t / 5;
            }
            if (t == 1) {
                count++;
            }
        }
        return current;
    }

    public static int findUglyNumber3(int n) {
        if (n == 1) {
            return 1;
        }

        int[] numbers = new int[n];
        numbers[0] = 1;
        int by2 = 0;
        int by3 = 0;
        int by5 = 0;
        int currentIdx = 1;
        while (numbers[n - 1] == 0) {
            int next2 = numbers[by2] * 2;
            int next3 = numbers[by3] * 3;
            int next5 = numbers[by5] * 5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));
            if (next2 == nextUgly) {
                by2++;
            }
            if (next3 == nextUgly) {
                by3++;
            }
            if (next5 == nextUgly) {
                by5++;
            }
            numbers[currentIdx] = nextUgly;
            currentIdx++;
        }
        return numbers[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(findUglyNumber(11));
        System.out.println(findUglyNumber2(11));
        System.out.println(findUglyNumber3(11));
    }

}
