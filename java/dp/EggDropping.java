package dp;

import array.ArrayUtils;

/**
 * Created @ 4/21/2014
 * TODO add algorithm description and link
 */
public class EggDropping {
    public static int solve(int floors, int eggs) {
        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }
        int min = floors;
        for (int x = 1; x < floors; x++) {
            min = Math.min(
                    min, Math.max(
                            solve(x - 1, eggs - 1),
                            solve(floors - x, eggs)
                    )
            );
        }
        return min + 1;
    }

    public static int solveDP(int floors, int eggs) {
        int S[][] = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= eggs; i++) {
            S[i][1] = 1;
        }
        for (int i = 1; i <= floors; i++) {
            S[1][i] = i;
        }

        ArrayUtils.print(S);
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                S[i][j] = floors + 1;
                for (int x = 1; x <= j; x++) {
                    int count = 1 + Math.max(
                            S[i - 1][x - 1],
                            S[i][j - x]
                            );
                    S[i][j] = Math.min(S[i][j], count);
                }
            }
        }
        ArrayUtils.print(S);
        return S[eggs][floors];
    }

    public static void main(String[] args) {
        int floors = 36;
        int eggs = 2;
//        System.out.println(solve(floors, eggs));
        System.out.println(solveDP(floors, eggs));
    }
}
