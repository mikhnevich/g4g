/**
 * Created by user @ 2/19/14 10:38 AM
 */
public class MatrixTranspose {

    public void transpose(int[] matrix, int rows, int cols) {
        // old_loc = oRow * C + oCol
        // new_loc = nRow * R + nCol
        //
        // observation: nRow == oCol, nCol == oRow:
        // new_loc = oCol * R + oRow
        //
        // old_loc = oRow * C + oCol
        // old_loc * R = oRow * C * R + oCol * R
        // old_loc * R = oRow * N + oCol * R
        // = oRow * N + new_loc - oRow
        // = oRow(N - 1) + new_loc
        //
        // new_loc = old_loc * R - oRow(N - 1)
        //
        // add mod (N-1):
        //
    }
}
