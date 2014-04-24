package dp;

/**
 * Created @ 4/23/2014
 *
 * infinite length chess board and if given two knights in a chess board .find minimum hops required for them meet.
 *
|X| |X| |X| |X| |
| |X| |X| |X| |X|
|X| |X| |X| |X| |
| |X| |X| |X| |X|
|X| |X| |X| |X| |
| |X| |X| |X| |X|
|X| |X| |X| |X| |
| |X| |X| |X| |X|

*/
public class ChessKnight {
    /*
    basic idea: if a knight in position (m, n), it can reach any of it's 8 surrounding cells in
    3 moves max (verifiable manually)
    build implicit graph and move knight towards to another one.

|X| |X| |X| |X| |
| |3|1|2|1|3| |X|
|X|1|2|3|2|1|X| |
| |2|3|+|3|2| |X|
|X|1|2|3|2|1|X| |
| |3|1|2|1|3| |X|
|X| |X| |X| |X| |
| |X| |X| |X| |X|

move until the knight is close enough to the target - see above. Number indicates how many
hops is required to get from the position to the destination (+)

    */

    public int solve(int row1, int col1, int row2, int col2) {
        int horizontalDirection = (int) Math.signum(col2 - col1);
        int verticalDirection = (int) Math.signum(row2 - row1);

//        while (row)
    }
}
